package fr.esiea.inf3132tp2024.view.console;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TLabel;
import fr.esiea.inf3132tp2024.utils.direction.Direction;
import fr.esiea.inf3132tp2024.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.utils.direction.DirectionUtils;

public class AdjustSizeFrame extends TFrame implements DisplayableComponent {
    private final AppSettings settings;

    private boolean display = true;

    public AdjustSizeFrame(AppSettings settings) {
        super(0, 0, "Réglage des dimensions de la console");

        this.settings = settings;

        TLabel instructions_1 = new TLabel(new String[]{"Veuillez ajustez le cadre pour qu'il soit sur les bords de l'écran",
                "Pour cela vous pouvez utiliser les flèches directionnelles ou les touches zqsd"});
        TLabel instructions_2 = new TLabel("Appuyez sur \"Entrée\" pour valider");

        this.getContentPane().getComponents().add(instructions_1);
        this.getContentPane().getComponents().add(instructions_2);
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        super.onKeyPressed(event);

        int key = event.getKey();

        // 10 = Entrée dans netbeans ; 13 = Entrée dans un terminal
        if (key == 10 || key == 13) {
            stopLoopingMode();
            return;
        }

        try {
            Direction direction = DirectionUtils.parseDirection(key, true);
            switch (direction) {
                case LEFT -> settings.setConsoleLength(settings.getConsoleLength() - 1);
                case RIGHT -> settings.setConsoleLength(settings.getConsoleLength() + 1);
                case TOP -> settings.setConsoleHeight(settings.getConsoleHeight() - 1);
                case BOTTOM -> settings.setConsoleHeight(settings.getConsoleHeight() + 1);
            }
        } catch (DirectionNotFoundException ignored) {
        }
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public void stopLoopingMode() {
        this.display = false;
    }
}
