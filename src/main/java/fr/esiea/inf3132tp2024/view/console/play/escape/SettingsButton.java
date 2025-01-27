package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.view.console.api.component.CButton;
import fr.esiea.inf3132tp2024.view.console.settings.menu.SettingsMenu;

public class SettingsButton extends CButton {
    private final App app;
    private final Game game;

    public SettingsButton(App app, Game game) {
        super(app, "Paramètres");

        this.app = app;
        this.game = game;
    }

    @Override
    public void execute() {
        app.getConsole().show(new SettingsMenu(app, game.getAudioPlayer()));
    }
}
