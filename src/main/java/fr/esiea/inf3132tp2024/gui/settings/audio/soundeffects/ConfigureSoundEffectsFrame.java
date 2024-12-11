package fr.esiea.inf3132tp2024.gui.settings.audio.soundeffects;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CChoices;
import fr.esiea.inf3132tp2024.gui.component.CFrame;
import fr.esiea.inf3132tp2024.gui.component.CSlider;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class ConfigureSoundEffectsFrame extends CFrame implements DisplayableComponent {
    private boolean display = true;

    public ConfigureSoundEffectsFrame(App app) {
        super(0, 0, "Configurer le niveau sonore des effets sonores");

        CSlider gauge = new ConfigureSoundEffectsSlider(app);

        CChoices buttons = new CChoices(app, Orientation.HORIZONTAL, 10);
        buttons.add(new ConfigureSoundEffectsOkButton(app, this, gauge));
        buttons.add(new QuitComponentButton(app, this, "Annuler"));

        CChoices choices = new CChoices(app, 5);
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
