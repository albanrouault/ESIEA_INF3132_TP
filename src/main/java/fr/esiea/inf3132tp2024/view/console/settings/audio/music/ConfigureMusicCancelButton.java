package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;

public class ConfigureMusicCancelButton extends QuitComponentButton {
    private final AudioTrack menuAudioTrack;

    public ConfigureMusicCancelButton(ConfigureMusicFrame configureMusicFrame, AudioTrack menuAudioTrack) {
        super(configureMusicFrame, "Annuler");

        this.menuAudioTrack = menuAudioTrack;
    }

    @Override
    public void execute() {
        super.execute();

        menuAudioTrack.setVolume(AppSettings.getInstance().getMusicVolume());
    }
}
