package fr.esiea.inf3132tp2024.gui.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.AppSettings;
import fr.esiea.inf3132tp2024.audio.SoundEffect;
import fr.esiea.inf3132tp2024.gui.component.CSlider;
import fr.esiea.inf3132tp2024.utils.audio.SimpleAudioPlayer;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class ConfigureSoundEffectsSlider extends CSlider {
    private final App app;

    public ConfigureSoundEffectsSlider(App app) {
        super(AppSettings.CONSOLE_MIN_LENGTH - 10, 1, (int) (app.getSettings().getSoundEffectsVolume() * 20), 20, "%PERCENT%");

        this.app = app;
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);

        try {
            SimpleAudioPlayer audioPlayer = app.createAudioPlayer(SoundEffect.HOVER);
            audioPlayer.setVolume((float) this.getValue() / this.getMaxValue());
            audioPlayer.play();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException |
                 IllegalArgumentException ignored) {
        }
    }
}
