package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.settings.audio.soundeffects.ConfigureSoundEffectsFrame;

public class ConfigureSoundEffectsButton extends TButton {
    public ConfigureSoundEffectsButton() {
        super("Configurer le volume des effects sonores");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new ConfigureSoundEffectsFrame());
    }
}
