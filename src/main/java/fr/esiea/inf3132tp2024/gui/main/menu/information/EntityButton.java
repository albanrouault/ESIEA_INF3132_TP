package fr.esiea.inf3132tp2024.gui.main.menu.information;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.gui.component.CButton;
import fr.esiea.inf3132tp2024.gui.main.menu.information.entities.EntitiesMenu;

public class EntityButton extends CButton {

    private final App app;

    public EntityButton(App app) {
        super(app, "Afficher les entités");

        this.app = app;
    }


    @Override
    public void execute() {
        app.getConsole().show(new EntitiesMenu(app));
    }
}