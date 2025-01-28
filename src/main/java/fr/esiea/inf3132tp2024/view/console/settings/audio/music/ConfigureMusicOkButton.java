package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TSlider;

public class ConfigureMusicOkButton extends QuitComponentButton {
    private final AppSettings settings;
    private final TSlider gauge;

    public ConfigureMusicOkButton(App app, ConfigureMusicFrame configureMusicFrame, TSlider gauge) {
        super(app, configureMusicFrame, "Valider");

        this.settings = app.getSettings();
        this.gauge = gauge;
    }

    @Override
    public void execute() {
        super.execute();

        settings.setMusicVolume((float) gauge.getValue() / gauge.getMaxValue());
    }
}
