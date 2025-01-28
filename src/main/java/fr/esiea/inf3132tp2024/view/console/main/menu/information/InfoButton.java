package fr.esiea.inf3132tp2024.view.console.main.menu.information;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class InfoButton extends TButton {
    private final App app;

    public InfoButton(App app) {
        super(app, "Informations");
        this.app = app;
    }

    @Override
    public void execute() {
        app.getConsole().show(new InfoMenu(app));
    }
}
