package fr.esiea.inf3132tp2024.view.console.main.menu.information;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.main.menu.information.entities.EntitiesMenu;

public class EntityButton extends TButton {
    public EntityButton() {
        super("Afficher les entités");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new EntitiesMenu());
    }
}