package fr.esiea.inf3132tp2024.old.gui.settings.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.settings.audio.music.ConfigureMusicFrame;
import fr.esiea.inf3132tp2024.old.utils.audio.SimpleAudioPlayer;

public class ConfigureMusicButton extends CButton {
    private final App app;
    private final SimpleAudioPlayer menuPlayer;

    public ConfigureMusicButton(App app, SimpleAudioPlayer menuPlayer) {
        super(app, "Configurer le volume de la musique");

        this.app = app;
        this.menuPlayer = menuPlayer;
    }

    @Override
    public void execute() {
        app.getConsole().show(new ConfigureMusicFrame(app, menuPlayer));
    }
}
