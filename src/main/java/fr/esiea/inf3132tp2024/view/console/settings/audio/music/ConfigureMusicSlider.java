package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.api.component.CSlider;
import fr.esiea.inf3132tp2024.utils.audio.SimpleAudioPlayer;

public class ConfigureMusicSlider extends CSlider {
    private final SimpleAudioPlayer menuPlayer;

    public ConfigureMusicSlider(AppSettings settings, SimpleAudioPlayer menuPlayer) {
        super(AppSettings.CONSOLE_MIN_LENGTH - 10, 1, (int) (settings.getMusicVolume() * 20), 20, "%PERCENT%");

        this.menuPlayer = menuPlayer;
    }

    @Override
    public void setValue(int value) {
        super.setValue(value);

        try {
            menuPlayer.setVolume((float) this.getValue() / this.getMaxValue());
        } catch (Exception ignored) {
        }
    }
}
