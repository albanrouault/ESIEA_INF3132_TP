package fr.esiea.inf3132tp2024.view.console.main.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.settings.menu.SettingsMenu;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;

public class SettingsButton extends TButton {
    private final App app;
    private final NativeAudioTrack menuPlayer;

    public SettingsButton(App app, NativeAudioTrack menuPlayer) {
        super(app, "Paramètres");

        this.app = app;
        this.menuPlayer = menuPlayer;
    }

    @Override
    public void execute() {
        app.getConsole().show(new SettingsMenu(app, menuPlayer));
    }
}
