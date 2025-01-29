package fr.esiea.inf3132tp2024.view.main.menu.statistics;

import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ShowStatButton extends TButton {
    private final GameStatistic gameStatistic;

    public ShowStatButton(GameStatistic gameStatistic, int placement) {
        super(placement + ". " + gameStatistic.getPlayerName() + " " + gameStatistic.getScore());

        this.gameStatistic = gameStatistic;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new ViewStatisticMenu(gameStatistic));
    }
}
