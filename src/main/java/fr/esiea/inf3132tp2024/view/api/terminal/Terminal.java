package fr.esiea.inf3132tp2024.view.api.terminal;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.utils.console.RawConsoleInput;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

// Sources ANSI codes:
// https://gist.github.com/fnky/458719343aabd01cfb17a3a4f7296797
// https://askubuntu.com/questions/558280/changing-colour-of-text-and-background-of-terminal
// https://en.wikipedia.org/wiki/ANSI_escape_code
// https://github.com/htop-dev/htop/blob/d0d9f202c56c1fc8919548418b339d31a6b49c02/CRT.c#L944
public class Terminal extends TPanel {
    private static final Terminal INSTANCE = new Terminal();

    public static Terminal getInstance() {
        return INSTANCE;
    }

    private final AppSettings settings = AppSettings.getInstance();

    public Terminal() {
        super(0, 0);

        // Rendre le curseur invisible
        System.out.print("\033[?25l");
    }

    public void show(DisplayableComponent displayableComponent) {
        if (displayableComponent instanceof TComponent component) {
            List<TComponent> save = new LinkedList<>(this.getComponents());
            this.getComponents().clear();

            this.getComponents().add(component);

            boolean continueShowing;
            do {
                clear();
                if (settings.getConsoleLength() != this.getLength()) {
                    this.setLength(settings.getConsoleLength());
                }
                if (settings.getConsoleHeight() != this.getHeight()) {
                    this.setHeight(settings.getConsoleHeight());
                }
                for (TComponent comp : this.getComponents()) {
                    if (!displayableComponent.isInFullScreenMode()) {
                        continue;
                    }
                    if (this.getLength() != comp.getLength()) {
                        comp.setLength(this.getLength());
                    }
                    if (this.getHeight() != comp.getHeight()) {
                        comp.setHeight(this.getHeight());
                    }
                }
                System.out.print(this);
                try {
                    int input = RawConsoleInput.read(true);

                    // Ce bout de code est nécessaire pour interpreter les caractères "spéciaux" sous linux
                    // Si un caractère d'échappement est entré
                    // 91 = [
                    if (input == 27 && RawConsoleInput.read(false) == 91) {
                        switch (RawConsoleInput.read(false)) {
                            // 51 = 3
                            case 51 -> {
                                // 126 = ~
                                if (RawConsoleInput.read(false) == 126) {
                                    // 57427 = suppr
                                    input = 57427;
                                }
                            }
                            // 65 = A
                            case 65 -> // 57416 = Flèche du haut
                                    input = 57416;
                            // 66 = B
                            case 66 -> // 57424 = Flèche du bas
                                    input = 57424;
                            // 67 = C
                            case 67 -> // 57421 = Flèche de droite
                                    input = 57421;
                            // 68 = D
                            case 68 -> // 57419 = Flèche de gauche
                                    input = 57419;
                        }
                    }

                    // On notifie les éléments graphiques de la touche entrée
                    this.onKeyPressed(new KeyPressedEvent(input));
                } catch (IOException ex) {
                    System.out.println("ERREUR");
                    System.exit(1);
                }
                continueShowing = displayableComponent.isInLoopingMode();
            } while (continueShowing);

            this.getComponents().clear();
            this.getComponents().addAll(save);
        }
    }

    // Méthode pour effacer la console
    private void clear() {
        for (int i = 0; i < this.getHeight() - 1; i++) {
            // On déplace le curseur sur la ligne au-dessus
            System.out.print("\033[F");
        }
        // On efface le terminal à partir du curseur
        System.out.print("\033[0J");
    }

    public void finalClear(boolean clear) {
        if (clear) {
            clear();
        } else {
            System.out.println();
        }

        // Rendre le curseur visible
        System.out.print("\033[?25h");

        try {
            RawConsoleInput.resetConsoleMode();
        } catch (IOException ignored) {
        }
    }
}
