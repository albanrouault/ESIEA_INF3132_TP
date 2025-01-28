package fr.esiea.inf3132tp2024.view.console.main.menu;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.main.menu.statistics.StatisticsMenu;

public class StatisticsButton extends TButton {
    public StatisticsButton() {
        super("Statistiques");
    }

    @Override
    public void execute() {
        Console.getInstance().show(new StatisticsMenu());
    }
}
