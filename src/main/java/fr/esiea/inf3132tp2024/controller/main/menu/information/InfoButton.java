package fr.esiea.inf3132tp2024.controller.main.menu.information;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class InfoButton extends TButton {
    public InfoButton() {
        super("Informations");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new InfoMenu());
    }
}
