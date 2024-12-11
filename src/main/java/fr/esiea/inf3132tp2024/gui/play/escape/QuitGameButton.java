package fr.esiea.inf3132tp2024.gui.play.escape;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.gui.component.CButton;

public class QuitGameButton extends CButton {
    private final App app;
    private final EscapeMenu escapeMenu;

    public QuitGameButton(App app, EscapeMenu escapeMenu) {
        super(app, "Quitter la partie");

        this.app = app;
        this.escapeMenu = escapeMenu;
    }

    @Override
    public void execute() {
        escapeMenu.stopLoopingMode();
        app.getCurrentGame().stopLoopingMode();
    }
}
