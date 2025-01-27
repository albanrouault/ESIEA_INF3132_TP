package fr.esiea.inf3132tp2024.view.console.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.CSlider;

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
