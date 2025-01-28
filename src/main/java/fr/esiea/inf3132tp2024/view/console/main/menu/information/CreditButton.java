package fr.esiea.inf3132tp2024.view.console.main.menu.information;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.main.menu.information.credits.CreditsMenu;

public class CreditButton extends TButton {
    public CreditButton() {
        super("Crédits");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new CreditsMenu());
    }
}
