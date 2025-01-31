package fr.esiea.inf3132tp2024.controller.main.menu.information;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.controller.main.menu.information.credits.CreditsMenu;

public class CreditButton extends TButton {
    public CreditButton() {
        super("Crédits");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new CreditsMenu());
    }
}
