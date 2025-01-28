package fr.esiea.inf3132tp2024.view.console.main.menu.information;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.main.menu.information.commands.CommandsMenu;

public class CommandButton extends TButton {
    public CommandButton() {
        super("Afficher les commandes");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new CommandsMenu());
    }
}