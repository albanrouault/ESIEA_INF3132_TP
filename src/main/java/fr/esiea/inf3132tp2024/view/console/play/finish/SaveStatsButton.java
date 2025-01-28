package fr.esiea.inf3132tp2024.view.console.play.finish;

import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.old.game.Statistic;
import fr.esiea.inf3132tp2024.old.game.StatisticsManager;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TTextField;

public class SaveStatsButton extends TButton {
    private final Game game;
    private final FinishMenu finishMenu;

    public SaveStatsButton(Game game, FinishMenu finishMenu) {
        super("Sauvegarder les statistiques");

        this.game = game;
        this.finishMenu = finishMenu;
    }

    @Override
    public void execute() {
        TTextField nameField = finishMenu.getNameField();

        // Sauvegarde des statistiques
        Statistic statistic = game.getStatistic();
        statistic.setPlayerName(nameField.getText());
        StatisticsManager.getInstance().addStatistic(statistic);

        // On enlève les boutons
        finishMenu.getContentPane().getComponents().remove(finishMenu.getNameLabel());
        finishMenu.getButtons().remove(nameField);
        finishMenu.getButtons().remove(this);
        finishMenu.getQuitButton().setSelected(true);
    }
}
