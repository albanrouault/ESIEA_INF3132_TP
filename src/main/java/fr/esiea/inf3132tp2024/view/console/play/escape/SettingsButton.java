package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.settings.menu.SettingsMenu;

public class SettingsButton extends TButton {
    private final Game game;

    public SettingsButton(Game game) {
        super("Paramètres");

        this.game = game;
    }

    @Override
    public void execute() {
        Console.getInstance().show(new SettingsMenu(game.getGameAudioTrack()));
    }
}
