package fr.esiea.inf3132tp2024.old.gui.play.start;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.old.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.component.CChoices;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CTextField;
import fr.esiea.inf3132tp2024.old.gui.main.menu.MainMenu;
import fr.esiea.inf3132tp2024.old.utils.direction.Orientation;

public class PlayMenu extends CFrame implements DisplayableComponent {
    private final CTextField playerNameField;
    private final CTextField seedField;
    private boolean display = true;

    public PlayMenu(App app, MainMenu mainMenu) {
        super(0, 0, "Créer une partie");

        this.playerNameField = new CTextField("Nom du joueur (aléatoire si vide)", AppSettings.CONSOLE_MIN_LENGTH - 10);
        this.seedField = new CTextField("Graine de la carte à générer (aléatoire si vide)", AppSettings.CONSOLE_MIN_LENGTH - 10);
        CButton okButton = new OkButton(app, mainMenu, this);
        QuitComponentButton backButton = new QuitComponentButton(app, this, "Retour");
        CChoices actions = new CChoices(app, Orientation.HORIZONTAL, 10);
        actions.add(okButton);
        actions.add(backButton);

        CChoices choices = new CChoices(app, 1);
        choices.add(playerNameField);
        choices.add(seedField);
        choices.add(actions);
        choices.select(actions);

        this.getContentPane().getComponents().add(choices);
    }

    public CTextField getPlayerNameField() {
        return playerNameField;
    }

    public CTextField getSeedField() {
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
