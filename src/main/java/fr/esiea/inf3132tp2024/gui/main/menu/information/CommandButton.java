package fr.esiea.inf3132tp2024.gui.main.menu.information;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.gui.component.CButton;
import fr.esiea.inf3132tp2024.gui.main.menu.information.commands.CommandsMenu;

public class CommandButton extends CButton {
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