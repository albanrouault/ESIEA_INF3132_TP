package fr.esiea.inf3132tp2024.view.console.play.escape.cheat;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.api.component.TChoices;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TTextField;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.view.console.play.escape.EscapeMenu;

public class CheatMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;
    private final TTextField cheatCodeField;

    public CheatMenu(Game game, EscapeMenu escapeMenu) {
        super(0, 0, "Menu de triche");

        TChoices choices = new TChoices(1);
        this.cheatCodeField = new TTextField("Entrez le code de triche", AppSettings.CONSOLE_MIN_LENGTH - 10, "");
        choices.add(cheatCodeField);
        choices.add(new ActivateCheatButton(this, game, escapeMenu));
        choices.add(new QuitComponentButton(this, "Retour"));

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

    public TTextField getCheatCodeField() {
        return this.cheatCodeField;
    }
}
