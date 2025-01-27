package fr.esiea.inf3132tp2024.view.console;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.console.api.component.CFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.CLabel;
import fr.esiea.inf3132tp2024.utils.direction.Direction;
import fr.esiea.inf3132tp2024.utils.direction.DirectionNotFoundException;
import fr.esiea.inf3132tp2024.utils.direction.DirectionUtils;

public class AdjustSizeFrame extends CFrame implements DisplayableComponent {
    private final AppSettings settings;

    private boolean display = true;

    public AdjustSizeFrame(AppSettings settings) {
        super(0, 0, "Réglage des dimensions de la console");

        this.settings = settings;

        CLabel instructions_1 = new CLabel(new String[]{"Veuillez ajustez le cadre pour qu'il soit sur les bords de l'écran",
                "Pour cela vous pouvez utiliser les flèches directionnelles ou les touches zqsd"});
        CLabel instructions_2 = new CLabel("Appuyez sur \"Entrée\" pour valider");

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
