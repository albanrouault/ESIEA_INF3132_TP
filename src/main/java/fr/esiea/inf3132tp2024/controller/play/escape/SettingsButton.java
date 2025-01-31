package fr.esiea.inf3132tp2024.controller.play.escape;

import fr.esiea.inf3132tp2024.controller.play.game.Game;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.controller.settings.menu.SettingsMenu;

public class SettingsButton extends TButton {
    private final Game game;

    public SettingsButton(Game game) {
        super("Paramètres");

        this.game = game;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new SettingsMenu(game.getGameAudioTrack()));
    }
}
