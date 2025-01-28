package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.utils.audio.NativeAudioTrack;

public class SettingsMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public SettingsMenu(App app, NativeAudioTrack menuPlayer) {
        super(0, 0, "Paramètres");

        TButton saveButton = new SaveButton(app, this);

        TChoices choices = new TChoices(app, 1);
        choices.add(new ConfigureScreenButton(app));
        choices.add(new ConfigureMusicButton(app, menuPlayer));
        choices.add(new ConfigureSoundEffectsButton(app));
        choices.add(saveButton);
        //choices.add(new DebugKeysButton(app));
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
