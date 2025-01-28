package fr.esiea.inf3132tp2024.view.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TSlider;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

public class ConfigureSoundEffectsOkButton extends TQuitComponentButton {
    private final TSlider gauge;

    public ConfigureSoundEffectsOkButton(ConfigureSoundEffectsFrame configureSoundEffectsFrame, TSlider gauge) {
        super(configureSoundEffectsFrame, "Valider");

        this.gauge = gauge;
    }

    @Override
    public void execute() {
        super.execute();

        AppSettings.getInstance().setSoundEffectsVolume((float) gauge.getValue() / gauge.getMaxValue());
    }
}
