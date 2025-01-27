package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.CButton;
import fr.esiea.inf3132tp2024.view.console.api.component.CChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.CFrame;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.utils.audio.SimpleAudioPlayer;

public class SettingsMenu extends CFrame implements DisplayableComponent {
    private boolean display = true;

    public SettingsMenu(App app, SimpleAudioPlayer menuPlayer) {
        super(0, 0, "Paramètres");

        CButton saveButton = new SaveButton(app, this);

        CChoices choices = new CChoices(app, 1);
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
