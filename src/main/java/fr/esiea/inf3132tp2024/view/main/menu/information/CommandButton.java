package fr.esiea.inf3132tp2024.view.main.menu.information;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.main.menu.information.commands.CommandsMenu;

public class CommandButton extends TButton {
    public CommandButton() {
        super("Afficher les commandes");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new CommandsMenu());
    }
}