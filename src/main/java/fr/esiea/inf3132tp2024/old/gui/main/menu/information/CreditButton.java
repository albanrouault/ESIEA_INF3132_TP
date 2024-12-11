package fr.esiea.inf3132tp2024.old.gui.main.menu.information;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.main.menu.information.credits.CreditsMenu;

public class CreditButton extends CButton {

    private final App app;

    public CreditButton(App app) {
        super(app, "Crédits");

        this.app = app;
    }


    @Override
    public void execute() {
        app.getConsole().show(new CreditsMenu());
    }
}
