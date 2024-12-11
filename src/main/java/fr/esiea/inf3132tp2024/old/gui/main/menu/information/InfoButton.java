package fr.esiea.inf3132tp2024.old.gui.main.menu.information;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;

public class InfoButton extends CButton {
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
