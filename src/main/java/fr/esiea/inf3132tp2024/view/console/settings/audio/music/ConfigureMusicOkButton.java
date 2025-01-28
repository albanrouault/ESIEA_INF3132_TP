package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.api.component.TSlider;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;

public class ConfigureMusicOkButton extends QuitComponentButton {
    private final TSlider gauge;

    public ConfigureMusicOkButton(ConfigureMusicFrame configureMusicFrame, TSlider gauge) {
        super(configureMusicFrame, "Valider");

        this.gauge = gauge;
    }

    @Override
    public void execute() {
        super.execute();

        AppSettings.getInstance().setMusicVolume((float) gauge.getValue() / gauge.getMaxValue());
    }
}
