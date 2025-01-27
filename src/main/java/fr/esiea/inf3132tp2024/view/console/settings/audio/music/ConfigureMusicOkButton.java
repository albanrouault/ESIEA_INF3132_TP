package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.CSlider;

public class ConfigureMusicOkButton extends QuitComponentButton {
    private final AppSettings settings;
    private final CSlider gauge;

    public ConfigureMusicOkButton(App app, ConfigureMusicFrame configureMusicFrame, CSlider gauge) {
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
