package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.view.console.AdjustSizeFrame;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class ConfigureScreenButton extends TButton {
    public ConfigureScreenButton() {
        super("Configurer les dimensions de la fenêtre");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new AdjustSizeFrame());
    }
}
