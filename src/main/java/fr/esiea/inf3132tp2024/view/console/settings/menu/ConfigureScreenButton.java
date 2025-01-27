package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.AdjustSizeFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.CButton;

public class ConfigureScreenButton extends CButton {
    private final App app;

    public ConfigureScreenButton(App app) {
        super(app, "Configurer les dimensions de la fenêtre");

        this.app = app;
    }

    @Override
    public void execute() {
        app.getConsole().show(new AdjustSizeFrame(app.getSettings()));
    }
}
