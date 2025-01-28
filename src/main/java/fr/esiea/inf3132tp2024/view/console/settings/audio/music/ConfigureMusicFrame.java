package fr.esiea.inf3132tp2024.view.console.settings.audio.music;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TSlider;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class ConfigureMusicFrame extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public ConfigureMusicFrame(App app, NativeAudioTrack menuPlayer) {
        super(0, 0, "Configurer le niveau sonore de la musique");

        TSlider gauge = new ConfigureMusicSlider(app.getSettings(), menuPlayer);

        TChoices buttons = new TChoices(app, Orientation.HORIZONTAL, 10);
        buttons.add(new ConfigureMusicOkButton(app, this, gauge));
        buttons.add(new ConfigureMusicCancelButton(app, this, menuPlayer));

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
