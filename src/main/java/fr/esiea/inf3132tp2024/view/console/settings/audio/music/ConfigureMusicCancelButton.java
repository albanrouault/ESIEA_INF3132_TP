package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;

public class ConfigureMusicCancelButton extends QuitComponentButton {
    private final AppSettings settings;
    private final NativeAudioTrack menuPlayer;

    public ConfigureMusicCancelButton(App app, ConfigureMusicFrame configureMusicFrame, NativeAudioTrack menuPlayer) {
        super(app, configureMusicFrame, "Annuler");

        this.settings = app.getSettings();
        this.menuPlayer = menuPlayer;
    }

    @Override
    public void execute() {
        super.execute();

        try {
            menuPlayer.setVolume(settings.getMusicVolume());
        } catch (Exception ignored) {
        }
    }
}
