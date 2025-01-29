package fr.esiea.inf3132tp2024.view.settings.audio.music;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

public class ConfigureMusicCancelButton extends TQuitComponentButton {
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
