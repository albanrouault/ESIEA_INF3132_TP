package fr.esiea.inf3132tp2024.view.console.main.menu.statistics;

import fr.esiea.inf3132tp2024.old.game.Statistic;
import fr.esiea.inf3132tp2024.view.console.api.component.CFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.CLabel;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;

public class ViewStatisticMenu extends CFrame implements DisplayableComponent {
    public ViewStatisticMenu(Statistic statistic) {
        super(0, 0, "Statistique");

        this.getContentPane().getComponents().add(statistic);

        this.getContentPane().getComponents().add(new CLabel("Appuyez sur une touche pour continuer..."));
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
