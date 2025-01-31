package fr.esiea.inf3132tp2024.controller.main.menu;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.controller.main.menu.statistics.StatisticsMenu;

public class StatisticsButton extends TButton {
    public StatisticsButton() {
        super("Statistiques");
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new StatisticsMenu());
    }
}
