package fr.esiea.inf3132tp2024.view.play.finish;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.controller.game.Game;
import fr.esiea.inf3132tp2024.model.GameStatistic;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TTextField;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

public class FinishMenu extends TFrame implements DisplayableComponent {
    private final TChoices buttons;
    private final TQuitComponentButton quitButton;
    private TLabel nameLabel;
    private TTextField nameField;

    private boolean display = true;

    // afficher message de fin "Vous avez réussi à sortir du château !"
    // afficher les scores
    // Changer de nom pour les scores
    // bouton continuer
    public FinishMenu(Game game, boolean won) {
        super(0, 0, "Fin de la partie");

        // Texte
        TLabel result;
        if (won) {
            result = new TLabel("Bravo !\n \nVous avez réussi à sortir du château !");
            result.getColors().add(TColor.BRIGHT_GREEN);
        } else {
            result = new TLabel("Dommage !\n \nVous êtes mort !");
            result.getColors().add(TColor.RED);
        }
        result.getColors().add(TColor.BOLD);
        this.getContentPane().getComponents().add(result);

        // Statistiques
        // On actualise les statistiques
        GameStatistic gameStatistic = game.getStatistic();
        gameStatistic.calculScore();
        this.getContentPane().getComponents().add(game.getStatistic());

        // Boutons
        this.buttons = new TChoices(1);

        // On propose de changer de nom seulement si les cheats sont désactivés
        if (!game.getStatistic().isCheatModeActivated()) {
            // Label pseudo
            this.nameLabel = new TLabel("Entrez un pseudo:");
            this.getContentPane().getComponents().add(nameLabel);

            this.nameField = new TTextField("Pseudo pour enregistrer les statistiques", AppSettings.CONSOLE_MIN_LENGTH - 10, game.getPlayer().getName());
            buttons.add(nameField);
            buttons.add(new SaveStatsButton(game, this));
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

    public TLabel getNameLabel() {
        return nameLabel;
    }

    public TTextField getNameField() {
        return nameField;
    }

    public TQuitComponentButton getQuitButton() {
        return quitButton;
    }
}
