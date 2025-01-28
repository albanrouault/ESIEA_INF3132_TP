package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class QuitGameButton extends TButton {
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
