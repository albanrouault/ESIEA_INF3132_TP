package fr.esiea.inf3132tp2024.view.settings.menu;

import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;

public class SettingsMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public SettingsMenu(AudioTrack menuAudioTrack) {
        super(0, 0, "Paramètres");

        TButton saveButton = new SaveButton(this);

        TChoices choices = new TChoices(1);
        choices.add(new ConfigureScreenButton());
        choices.add(new ConfigureMusicButton(menuAudioTrack));
        choices.add(new ConfigureSoundEffectsButton());
        choices.add(saveButton);
        //choices.add(new DebugKeysButton());
        choices.select(saveButton);

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
