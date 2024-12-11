package fr.esiea.inf3132tp2024.old.gui.settings.audio.music;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CChoices;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CSlider;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.old.utils.audio.SimpleAudioPlayer;
import fr.esiea.inf3132tp2024.old.utils.direction.Orientation;

public class ConfigureMusicFrame extends CFrame implements DisplayableComponent {
    private boolean display = true;

    public ConfigureMusicFrame(App app, SimpleAudioPlayer menuPlayer) {
        super(0, 0, "Configurer le niveau sonore de la musique");

        CSlider gauge = new ConfigureMusicSlider(app.getSettings(), menuPlayer);

        CChoices buttons = new CChoices(app, Orientation.HORIZONTAL, 10);
        buttons.add(new ConfigureMusicOkButton(app, this, gauge));
        buttons.add(new ConfigureMusicCancelButton(app, this, menuPlayer));

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
