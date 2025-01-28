package fr.esiea.inf3132tp2024.view.console.play.start;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TTextField;
import fr.esiea.inf3132tp2024.view.console.main.menu.MainMenu;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class PlayMenu extends TFrame implements DisplayableComponent {
    private final TTextField playerNameField;
    private final TTextField seedField;
    private boolean display = true;

    public PlayMenu(App app, MainMenu mainMenu) {
        super(0, 0, "Créer une partie");

        this.playerNameField = new TTextField("Nom du joueur (aléatoire si vide)", AppSettings.CONSOLE_MIN_LENGTH - 10);
        this.seedField = new TTextField("Graine de la carte à générer (aléatoire si vide)", AppSettings.CONSOLE_MIN_LENGTH - 10);
        TButton okButton = new OkButton(app, mainMenu, this);
        QuitComponentButton backButton = new QuitComponentButton(app, this, "Retour");
        TChoices actions = new TChoices(app, Orientation.HORIZONTAL, 10);
        actions.add(okButton);
        actions.add(backButton);

        TChoices choices = new TChoices(app, 1);
        choices.add(playerNameField);
        choices.add(seedField);
        choices.add(actions);
        choices.select(actions);

        this.getContentPane().getComponents().add(choices);
    }

    public TTextField getPlayerNameField() {
        return playerNameField;
    }

    public TTextField getSeedField() {
        return seedField;
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
