package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.controller.App;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class QuitGameButton extends TButton {
    private final EscapeMenu escapeMenu;

    public QuitGameButton(EscapeMenu escapeMenu) {
        super("Quitter la partie");

        this.escapeMenu = escapeMenu;
    }

    @Override
    public void execute() {
        escapeMenu.stopLoopingMode();
        App.getInstance().getCurrentGame().stopLoopingMode();
    }
}
