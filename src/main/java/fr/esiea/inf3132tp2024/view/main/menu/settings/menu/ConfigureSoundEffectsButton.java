package fr.esiea.inf3132tp2024.view.main.menu.settings.menu;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.main.menu.settings.audio.soundeffects.ConfigureSoundEffectsFrame;

public class ConfigureSoundEffectsButton extends TButton {
    public ConfigureSoundEffectsButton() {
        super("Configurer le volume des effects sonores");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new ConfigureSoundEffectsFrame());
    }
}
