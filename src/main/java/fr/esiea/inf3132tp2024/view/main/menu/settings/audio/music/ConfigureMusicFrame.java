package fr.esiea.inf3132tp2024.view.main.menu.settings.audio.music;

import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TSlider;

public class ConfigureMusicFrame extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public ConfigureMusicFrame(AudioTrack menuAudioTrack) {
        super(0, 0, "Configurer le niveau sonore de la musique");

        TSlider gauge = new ConfigureMusicSlider(menuAudioTrack);

        TChoices buttons = new TChoices(Orientation.HORIZONTAL, 10);
        buttons.add(new ConfigureMusicOkButton(this, gauge));
        buttons.add(new ConfigureMusicCancelButton(this, menuAudioTrack));

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
