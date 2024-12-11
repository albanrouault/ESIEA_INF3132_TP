package fr.esiea.inf3132tp2024.gui.main.menu.statistics;

import fr.esiea.inf3132tp2024.game.Statistic;
import fr.esiea.inf3132tp2024.gui.component.CFrame;
import fr.esiea.inf3132tp2024.gui.component.CLabel;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;

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
