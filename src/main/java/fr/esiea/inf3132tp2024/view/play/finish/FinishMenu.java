package fr.esiea.inf3132tp2024.view.play.finish;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.view.play.game.GameView;
import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TTextField;

public class FinishMenu extends TFrame implements DisplayableComponent {
    private final TChoices buttons;
    private final TQuitComponentButton quitButton;
    private TLabel nameLabel1, nameLabel2;
    private TTextField nameField1, nameField2;
    private boolean display = true;

    public FinishMenu(GameView gameView, boolean won) {
        super(0, 0, "Fin de la partie");

        // Texte de résultat
        TLabel result;
        if (won) {
            result = new TLabel("Bravo !\n \nVous avez réussi à sortir du château !");
            result.getColors().add(TColor.BRIGHT_GREEN);
        } else {
            result = new TLabel("Dommage !\n \nVous êtes morts !");
            result.getColors().add(TColor.RED);
        }
        result.getColors().add(TColor.BOLD);
        this.getContentPane().getComponents().add(result);

        // Statistiques
        GameStatistic gameStatistic = gameView.getStatistic();
//        gameStatistic.setXX();
        gameStatistic.calculScore();
        //this.getContentPane().getComponents().add(gameStatistic);

        // Boutons
        this.buttons = new TChoices(1);

        // Vérification du mode triche pour changer de nom
        if (!gameView.getStatistic().isCheatModeActivated()) {
            // Label et champs pour le joueur 1
            this.nameLabel1 = new TLabel("Entrez un pseudo pour Joueur 1:");
            this.getContentPane().getComponents().add(nameLabel1);
            this.nameField1 = new TTextField("Pseudo Joueur 1", AppSettings.CONSOLE_MIN_LENGTH - 10, gameView.getGame().getPlayerOne().getName());
            buttons.add(nameField1);

            // Label et champs pour le joueur 2
            this.nameLabel2 = new TLabel("Entrez un pseudo pour Joueur 2:");
            this.getContentPane().getComponents().add(nameLabel2);
            this.nameField2 = new TTextField("Pseudo Joueur 2", AppSettings.CONSOLE_MIN_LENGTH - 10, gameView.getGame().getPlayerTwo().getName());
            buttons.add(nameField2);

            // Bouton de sauvegarde des stats
            buttons.add(new SaveStatsButton(gameView, this));
        }

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