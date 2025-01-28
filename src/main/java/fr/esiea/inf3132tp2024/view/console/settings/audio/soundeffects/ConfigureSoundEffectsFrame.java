package fr.esiea.inf3132tp2024.view.console.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TSlider;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class ConfigureSoundEffectsFrame extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public ConfigureSoundEffectsFrame(App app) {
        super(0, 0, "Configurer le niveau sonore des effets sonores");

        TSlider gauge = new ConfigureSoundEffectsSlider(app);

        TChoices buttons = new TChoices(app, Orientation.HORIZONTAL, 10);
        buttons.add(new ConfigureSoundEffectsOkButton(app, this, gauge));
        buttons.add(new QuitComponentButton(app, this, "Annuler"));

        TChoices choices = new TChoices(app, 5);
        choices.add(gauge);
        choices.add(buttons);

        this.getContentPane().getComponents().add(choices);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    public void stopLoopingMode() {
        display = false;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }
}
