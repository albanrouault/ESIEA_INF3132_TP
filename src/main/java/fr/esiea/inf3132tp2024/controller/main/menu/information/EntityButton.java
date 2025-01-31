package fr.esiea.inf3132tp2024.controller.main.menu.information;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.controller.main.menu.information.entities.EntitiesMenu;

public class EntityButton extends TButton {
    public EntityButton() {
        super("Afficher les entités");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new EntitiesMenu());
    }
}