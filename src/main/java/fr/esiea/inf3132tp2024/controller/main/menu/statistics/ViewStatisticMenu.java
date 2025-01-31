package fr.esiea.inf3132tp2024.controller.main.menu.statistics;

import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;

public class ViewStatisticMenu extends TFrame implements DisplayableComponent {
    public ViewStatisticMenu(GameStatistic gameStatistic) {
        super(0, 0, "Statistique");

        this.getContentPane().getComponents().add(gameStatistic);

        this.getContentPane().getComponents().add(new TLabel("Appuyez sur une touche pour continuer..."));
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public boolean isInLoopingMode() {
        return false;
    }

    @Override
    public void stopLoopingMode() {
    }
}
