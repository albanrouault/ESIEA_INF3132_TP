package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.game.GameView;

public class QuitGameButton extends TButton {
    private final EscapeMenu escapeMenu;
    private final GameView gameView;

    public QuitGameButton(EscapeMenu escapeMenu, GameView gameView) {
        super("Quitter la partie");

        this.escapeMenu = escapeMenu;
        this.gameView = gameView;
    }

    @Override
    public void execute() {
        escapeMenu.stopLoopingMode();
        gameView.stopLoopingMode();
    }
}
