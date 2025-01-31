package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.view.play.game.GameView;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.settings.menu.SettingsMenu;

public class SettingsButton extends TButton {
    private final GameView gameView;

    public SettingsButton(GameView gameView) {
        super("Paramètres");

        this.gameView = gameView;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new SettingsMenu(gameView.getGameAudioTrack()));
    }
}
