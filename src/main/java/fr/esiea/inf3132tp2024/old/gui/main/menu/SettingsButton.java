package fr.esiea.inf3132tp2024.old.gui.main.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.settings.menu.SettingsMenu;
import fr.esiea.inf3132tp2024.old.utils.audio.SimpleAudioPlayer;

public class SettingsButton extends CButton {
    private final App app;
    private final SimpleAudioPlayer menuPlayer;

    public SettingsButton(App app, SimpleAudioPlayer menuPlayer) {
        super(app, "Paramètres");

        this.app = app;
        this.menuPlayer = menuPlayer;
    }

    @Override
    public void execute() {
        app.getConsole().show(new SettingsMenu(app, menuPlayer));
    }
}
