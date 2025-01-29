package fr.esiea.inf3132tp2024.view.main.menu.statistics;

import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.controller.game.StatisticsManager;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

import java.util.List;

public class StatisticsMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public StatisticsMenu() {
        super(0, 0, "Statistiques");

        List<GameStatistic> stats = StatisticsManager.getInstance().getStatistics();
        if (stats.isEmpty()) {
            this.getContentPane().getComponents().add(new TLabel("Aucune statistique répertoriée !"));
        }

        TChoices choices = new TChoices(1);

        for (int i = 0; i < stats.size(); i++) {
            choices.add(new ShowStatButton(stats.get(i), i + 1));
        }

        choices.add(new TQuitComponentButton(this, "Retour"));

        this.getContentPane().getComponents().add(choices);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    public void stopLoopingMode() {
        display = false;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }
}
