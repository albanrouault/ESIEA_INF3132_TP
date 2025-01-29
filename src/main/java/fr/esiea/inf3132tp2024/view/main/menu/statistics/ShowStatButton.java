package fr.esiea.inf3132tp2024.view.main.menu.statistics;

import fr.esiea.inf3132tp2024.controller.game.Statistic;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ShowStatButton extends TButton {
    private final Statistic statistic;

    public ShowStatButton(Statistic statistic, int placement) {
        super(placement + ". " + statistic.getPlayerName() + " " + statistic.getScore());

        this.statistic = statistic;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new ViewStatisticMenu(statistic));
    }
}
