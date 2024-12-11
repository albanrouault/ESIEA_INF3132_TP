package fr.esiea.inf3132tp2024.old.gui.main.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.main.menu.statistics.StatisticsMenu;

public class StatisticsButton extends CButton {

    App app;
    MainMenu menu;

    public StatisticsButton(App app, MainMenu menu) {
        super(app, "Statistiques");

        this.app = app;
        this.menu = menu;
    }

    @Override
    public void execute() {
        app.getConsole().show(new StatisticsMenu(app));
    }
}
