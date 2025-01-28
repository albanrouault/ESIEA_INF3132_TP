package fr.esiea.inf3132tp2024.view.console.main.menu.information;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class InfoButton extends TButton {
    public InfoButton() {
        super("Informations");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new InfoMenu());
    }
}
