package fr.esiea.inf3132tp2024.view.main.menu.settings.audio.music;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TSlider;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

public class ConfigureMusicOkButton extends TQuitComponentButton {
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
