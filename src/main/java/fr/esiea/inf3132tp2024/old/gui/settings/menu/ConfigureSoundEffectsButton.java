package fr.esiea.inf3132tp2024.old.gui.settings.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.settings.audio.soundeffects.ConfigureSoundEffectsFrame;

public class ConfigureSoundEffectsButton extends CButton {
    private final App app;

    public ConfigureSoundEffectsButton(App app) {
        super(app, "Configurer le volume des effects sonores");

        this.app = app;
    }

    @Override
    public void execute() {
        app.getConsole().show(new ConfigureSoundEffectsFrame(app));
    }
}
