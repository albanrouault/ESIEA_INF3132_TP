package fr.esiea.inf3132tp2024.view.console.main.menu.information;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.main.menu.information.commands.CommandsMenu;

public class CommandButton extends TButton {
    private final App app;

    public CommandButton(App app) {
        super(app, "Afficher les commandes");

        this.app = app;
    }

    @Override
    public void execute() {
        app.getConsole().show(new CommandsMenu());
    }
}