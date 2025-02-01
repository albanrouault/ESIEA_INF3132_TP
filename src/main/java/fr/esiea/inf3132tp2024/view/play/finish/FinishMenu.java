package fr.esiea.inf3132tp2024.view.play.finish;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TTextField;
import fr.esiea.inf3132tp2024.view.play.game.GameView;

public class FinishMenu extends TFrame implements DisplayableComponent {
    private final TChoices buttons;
    private final TQuitComponentButton quitButton;
    private TLabel nameLabel1, nameLabel2;
    private TTextField nameField1, nameField2;
    private boolean display = true;

    /**
     * Constructeur adapté pour indiquer le joueur gagnant.
     *
     * @param gameView      La vue de la partie en cours.
     * @param winningPlayer Le numéro du joueur gagnant (1 ou 2).
     */
    public FinishMenu(GameView gameView) {
        super(0, 0, "Fin de la partie");

        // Message de résultat adapté en fonction du joueur gagnant
        TLabel result;
        if (gameView.getGame().getPlayerTwo().hasLost()) {
            result = new TLabel("Bravo !\n\nLe joueur " + gameView.getGame().getPlayerOne().getName() + " a gagné !");
            result.getColors().add(TColor.BRIGHT_GREEN);
        } else if (gameView.getGame().getPlayerOne().hasLost()) {
            result = new TLabel("Bravo !\n\nLe joueur " + gameView.getGame().getPlayerTwo().getName() + " a gagné !");
            result.getColors().add(TColor.BRIGHT_GREEN);
        } else {
            result = new TLabel("Dommage !\n\nAucun joueur n'a gagné !");
            result.getColors().add(TColor.RED);
        }
        result.getColors().add(TColor.BOLD);
        this.getContentPane().getComponents().add(result);

        // Calcul et affichage (éventuel) des statistiques
        GameStatistic gameStatistic = gameView.getGame().getGameStatistic();
        gameView.getGame().getGameStatistic().setRound(gameView.getGame().getRound());
        gameStatistic.calculScore();
        // Vous pouvez ajouter ici l'affichage des statistiques si nécessaire.
        // this.getContentPane().getComponents().add(gameStatistic);

        // Création des boutons
        this.buttons = new TChoices(1);

        // Si le mode triche n'est pas activé, proposer la saisie de pseudos pour modifier les noms des joueurs.
        if (!gameView.getGame().getGameStatistic().isCheatModeActivated()) {
            // Joueur 1
            this.nameLabel1 = new TLabel("Entrez un pseudo pour Joueur 1 :");
            buttons.getComponents().add(nameLabel1);
            this.nameField1 = new TTextField("Pseudo Joueur 1", AppSettings.CONSOLE_MIN_LENGTH - 10, gameView.getGame().getPlayerOne().getName());
            buttons.add(nameField1);

            // Joueur 2
            this.nameLabel2 = new TLabel("Entrez un pseudo pour Joueur 2 :");
            buttons.getComponents().add(nameLabel2);
            this.nameField2 = new TTextField("Pseudo Joueur 2", AppSettings.CONSOLE_MIN_LENGTH - 10, gameView.getGame().getPlayerTwo().getName());
            buttons.add(nameField2);

            // Bouton de sauvegarde des statistiques
            buttons.add(new SaveStatsButton(gameView, this));
        }

        // Bouton pour quitter la partie
        this.quitButton = new TQuitComponentButton(this, "Quitter la partie");
        buttons.add(quitButton);
        this.getContentPane().getComponents().add(buttons);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    public void stopLoopingMode() {
        display = false;
    }

    public TChoices getButtons() {
        return buttons;
    }

    public TLabel getNameLabel1() {
        return nameLabel1;
    }

    public TTextField getNameField1() {
        return nameField1;
    }

    public TLabel getNameLabel2() {
        return nameLabel2;
    }

    public TTextField getNameField2() {
        return nameField2;
    }

    public TQuitComponentButton getQuitButton() {
        return quitButton;
    }
}
