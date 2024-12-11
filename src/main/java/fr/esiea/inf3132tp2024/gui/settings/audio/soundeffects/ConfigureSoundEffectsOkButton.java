package fr.esiea.inf3132tp2024.gui.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.AppSettings;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CSlider;

public class ConfigureSoundEffectsOkButton extends QuitComponentButton {
    private final AppSettings settings;
    private final CSlider gauge;

    public ConfigureSoundEffectsOkButton(App app, ConfigureSoundEffectsFrame configureSoundEffectsFrame, CSlider gauge) {
        super(app, configureSoundEffectsFrame, "Valider");

        this.settings = app.getSettings();
        this.gauge = gauge;
    }

    @Override
    public void execute() {
        super.execute();

        settings.setSoundEffectsVolume((float) gauge.getValue() / gauge.getMaxValue());
    }
}
