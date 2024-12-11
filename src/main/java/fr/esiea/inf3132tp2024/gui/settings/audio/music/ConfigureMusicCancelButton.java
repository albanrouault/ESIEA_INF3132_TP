package fr.esiea.inf3132tp2024.gui.settings.audio.music;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.AppSettings;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.utils.audio.SimpleAudioPlayer;

public class ConfigureMusicCancelButton extends QuitComponentButton {
    private final AppSettings settings;
    private final SimpleAudioPlayer menuPlayer;

    public ConfigureMusicCancelButton(App app, ConfigureMusicFrame configureMusicFrame, SimpleAudioPlayer menuPlayer) {
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
