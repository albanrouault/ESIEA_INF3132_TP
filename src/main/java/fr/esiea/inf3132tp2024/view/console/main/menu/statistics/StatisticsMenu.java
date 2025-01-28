package fr.esiea.inf3132tp2024.view.console.main.menu.statistics;

import fr.esiea.inf3132tp2024.old.game.Statistic;
import fr.esiea.inf3132tp2024.old.game.StatisticsManager;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TLabel;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;

import java.util.List;

public class StatisticsMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public StatisticsMenu() {
        super(0, 0, "Statistiques");

        List<Statistic> stats = StatisticsManager.getInstance().getStatistics();
        if (stats.isEmpty()) {
            this.getContentPane().getComponents().add(new TLabel("Aucune statistique répertoriée !"));
        }

        TChoices choices = new TChoices(1);

        for (int i = 0; i < stats.size(); i++) {
            choices.add(new ShowStatButton(stats.get(i), i + 1));
        }

        choices.add(new QuitComponentButton(this, "Retour"));

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
