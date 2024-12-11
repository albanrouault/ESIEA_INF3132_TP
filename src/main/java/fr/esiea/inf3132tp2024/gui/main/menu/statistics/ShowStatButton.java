package fr.esiea.inf3132tp2024.gui.main.menu.statistics;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.game.Statistic;
import fr.esiea.inf3132tp2024.gui.component.CButton;

public class ShowStatButton extends CButton {
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
