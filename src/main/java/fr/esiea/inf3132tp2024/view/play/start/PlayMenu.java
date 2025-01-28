package fr.esiea.inf3132tp2024.view.play.start;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TTextField;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.main.menu.MainMenu;

public class PlayMenu extends TFrame implements DisplayableComponent {
    private final TTextField playerNameField;
    private final TTextField seedField;
    private boolean display = true;

    public PlayMenu(MainMenu mainMenu) {
        super(0, 0, "Créer une partie");

        this.playerNameField = new TTextField("Nom du joueur (aléatoire si vide)", AppSettings.CONSOLE_MIN_LENGTH - 10);
        this.seedField = new TTextField("Graine de la carte à générer (aléatoire si vide)", AppSettings.CONSOLE_MIN_LENGTH - 10);
        TButton okButton = new OkButton(mainMenu, this);
        TQuitComponentButton backButton = new TQuitComponentButton(this, "Retour");
        TChoices actions = new TChoices(Orientation.HORIZONTAL, 10);
        actions.add(okButton);
        actions.add(backButton);

        TChoices choices = new TChoices(1);
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
