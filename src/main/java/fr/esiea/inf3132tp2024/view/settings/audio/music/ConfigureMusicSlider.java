package fr.esiea.inf3132tp2024.view.settings.audio.music;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TSlider;

public class ConfigureMusicSlider extends TSlider {
    private final AudioTrack menuAudioTrack;

    public ConfigureMusicSlider(AudioTrack menuAudioTrack) {
        super(AppSettings.CONSOLE_MIN_LENGTH - 10, 1, (int) (AppSettings.getInstance().getMusicVolume() * 20), 20, "%PERCENT%");

        this.menuAudioTrack = menuAudioTrack;
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);

        menuAudioTrack.setVolume((float) this.getValue() / this.getMaxValue());
    }
}
