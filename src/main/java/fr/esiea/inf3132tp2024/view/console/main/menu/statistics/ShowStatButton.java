package fr.esiea.inf3132tp2024.view.console.main.menu.statistics;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.game.Statistic;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class ShowStatButton extends TButton {
    private final App app;
    private final Statistic statistic;

    public ShowStatButton(App app, Statistic statistic, int placement) {
        super(app, "" + placement + ". " + statistic.getPlayerName() + " " + statistic.getScore());

        this.app = app;
        this.statistic = statistic;
    }

    @Override
    public void execute() {
        app.getConsole().show(new ViewStatisticMenu(statistic));
    }
}
