package fr.esiea.inf3132tp2024.controller.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.model.audio.SoundEffect;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TSlider;

public class ConfigureSoundEffectsSlider extends TSlider {
    public ConfigureSoundEffectsSlider() {
        super(AppSettings.CONSOLE_MIN_LENGTH - 10, 1, (int) (AppSettings.getInstance().getSoundEffectsVolume() * 20), 20, "%PERCENT%");
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);

        AudioTrack audioTrack = AudioPlayer.getInstance().createAudioTrack(SoundEffect.HOVER);
        audioTrack.setVolume((float) this.getValue() / this.getMaxValue());
        audioTrack.play();
    }
}
