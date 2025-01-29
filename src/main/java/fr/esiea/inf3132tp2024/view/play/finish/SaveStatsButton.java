package fr.esiea.inf3132tp2024.view.play.finish;

import fr.esiea.inf3132tp2024.controller.game.Game;
import fr.esiea.inf3132tp2024.controller.game.StatisticsManager;
import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TTextField;

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
        TTextField nameFieldPlayer1 = finishMenu.getNameField1();
        TTextField nameFieldPlayer2 = finishMenu.getNameField2();

        // Récupération et sauvegarde des statistiques de la partie
        GameStatistic gameStatistic = game.getStatistic();
        gameStatistic.setPlayerOneName(nameFieldPlayer1.getText());
        gameStatistic.setPlayerTwoName(nameFieldPlayer2.getText());
        StatisticsManager.getInstance().addStatistic(gameStatistic);

        // Suppression des composants liés à la sauvegarde
        finishMenu.getContentPane().getComponents().remove(finishMenu.getNameLabel1());
        finishMenu.getContentPane().getComponents().remove(finishMenu.getNameLabel2());
        finishMenu.getButtons().remove(nameFieldPlayer1);
        finishMenu.getButtons().remove(nameFieldPlayer2);
        finishMenu.getButtons().remove(this);

        // Sélection automatique du bouton de sortie
        finishMenu.getQuitButton().setSelected(true);
    }
}
