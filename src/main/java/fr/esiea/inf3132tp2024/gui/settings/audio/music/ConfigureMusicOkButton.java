package fr.esiea.inf3132tp2024.gui.settings.audio.music;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.AppSettings;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CSlider;

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
