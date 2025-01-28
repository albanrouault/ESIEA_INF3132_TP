package fr.esiea.inf3132tp2024.view.console.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TSlider;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;

public class ConfigureSoundEffectsFrame extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public ConfigureSoundEffectsFrame() {
        super(0, 0, "Configurer le niveau sonore des effets sonores");

        TSlider gauge = new ConfigureSoundEffectsSlider();

        TChoices buttons = new TChoices(Orientation.HORIZONTAL, 10);
        buttons.add(new ConfigureSoundEffectsOkButton(this, gauge));
        buttons.add(new QuitComponentButton(this, "Annuler"));

        TChoices choices = new TChoices(5);
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
