package fr.esiea.inf3132tp2024.view.console.play.finish;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.old.game.Statistic;
import fr.esiea.inf3132tp2024.view.console.CColor;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.CChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.CFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.CLabel;
import fr.esiea.inf3132tp2024.view.console.api.component.CTextField;

public class FinishMenu extends CFrame implements DisplayableComponent {
    private final CChoices buttons;
    private final QuitComponentButton quitButton;
    private CLabel nameLabel;
    private CTextField nameField;

    private boolean display = true;

    // afficher message de fin "Vous avez réussi à sortir du château !"
    // afficher les scores
    // Changer de nom pour les scores
    // bouton continuer
    public FinishMenu(App app, Game game, boolean won) {
        super(0, 0, "Fin de la partie");

        // Texte
        CLabel result;
        if (won) {
            result = new CLabel("Bravo !\n \nVous avez réussi à sortir du château !");
            result.getColors().add(CColor.BRIGHT_GREEN);
        } else {
            result = new CLabel("Dommage !\n \nVous êtes mort !");
            result.getColors().add(CColor.RED);
        }
        result.getColors().add(CColor.BOLD);
        this.getContentPane().getComponents().add(result);

        // Statistiques
        // On actualise les statistiques
        Statistic statistic = game.getStatistic();
        statistic.calculScore();
        this.getContentPane().getComponents().add(game.getStatistic());

        // Boutons
        this.buttons = new CChoices(app, 1);

        // On propose de changer de nom seulement si les cheats sont désactivés
        if (!game.getStatistic().isCheatModeActivated()) {
            // Label pseudo
            this.nameLabel = new CLabel("Entrez un pseudo:");
            this.getContentPane().getComponents().add(nameLabel);

            this.nameField = new CTextField("Pseudo pour enregistrer les statistiques", AppSettings.CONSOLE_MIN_LENGTH - 10, game.getPlayer().getName());
            buttons.add(nameField);
            buttons.add(new SaveStatsButton(app, game, this));
        }
        this.quitButton = new QuitComponentButton(app, this, "Quitter la partie");
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

    public CChoices getButtons() {
        return buttons;
    }

    public CLabel getNameLabel() {
        return nameLabel;
    }

    public CTextField getNameField() {
        return nameField;
    }

    public QuitComponentButton getQuitButton() {
        return quitButton;
    }
}
