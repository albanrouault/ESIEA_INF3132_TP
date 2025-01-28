package fr.esiea.inf3132tp2024.view.console.main.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.main.menu.statistics.StatisticsMenu;

public class StatisticsButton extends TButton {

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
