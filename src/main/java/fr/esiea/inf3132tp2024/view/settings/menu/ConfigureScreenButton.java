package fr.esiea.inf3132tp2024.view.settings.menu;

import fr.esiea.inf3132tp2024.view.AdjustSizeFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ConfigureScreenButton extends TButton {
    public ConfigureScreenButton() {
        super("Configurer les dimensions de la fenêtre");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new AdjustSizeFrame());
    }
}
