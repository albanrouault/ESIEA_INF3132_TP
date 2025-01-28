package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.settings.audio.music.ConfigureMusicFrame;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;

public class ConfigureMusicButton extends TButton {
    private final App app;
    private final NativeAudioTrack menuPlayer;

    public ConfigureMusicButton(App app, NativeAudioTrack menuPlayer) {
        super(app, "Configurer le volume de la musique");

        this.app = app;
        this.menuPlayer = menuPlayer;
    }

    @Override
    public void execute() {
        app.getConsole().show(new ConfigureMusicFrame(app, menuPlayer));
    }
}
