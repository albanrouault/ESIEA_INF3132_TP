package fr.esiea.inf3132tp2024.gui.play.escape.cheat;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.AppSettings;
import fr.esiea.inf3132tp2024.game.Game;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CChoices;
import fr.esiea.inf3132tp2024.gui.component.CFrame;
import fr.esiea.inf3132tp2024.gui.component.CTextField;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.gui.play.escape.EscapeMenu;

public class CheatMenu extends CFrame implements DisplayableComponent {
    private boolean display = true;
    private final CTextField cheatCodeField;

    public CheatMenu(App app, Game game, EscapeMenu escapeMenu) {
        super(0, 0, "Menu de triche");

        CChoices choices = new CChoices(app, 1);
        this.cheatCodeField = new CTextField("Entrez le code de triche", AppSettings.CONSOLE_MIN_LENGTH - 10, "");
        choices.add(cheatCodeField);
        choices.add(new ActivateCheatButton(app, this, game, escapeMenu));
        choices.add(new QuitComponentButton(app, this, "Retour"));

        this.getContentPane().getComponents().add(choices);

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

    public CTextField getCheatCodeField() {
        return this.cheatCodeField;
    }
}
