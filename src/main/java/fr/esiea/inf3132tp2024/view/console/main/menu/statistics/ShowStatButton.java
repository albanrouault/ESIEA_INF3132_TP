package fr.esiea.inf3132tp2024.view.console.main.menu.statistics;

import fr.esiea.inf3132tp2024.old.game.Statistic;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class ShowStatButton extends TButton {
    private final Statistic statistic;

    public ShowStatButton(Statistic statistic, int placement) {
        super(placement + ". " + statistic.getPlayerName() + " " + statistic.getScore());

        this.statistic = statistic;
    }

    @Override
    public void execute() {
        Console.getInstance().show(new ViewStatisticMenu(statistic));
    }
}
