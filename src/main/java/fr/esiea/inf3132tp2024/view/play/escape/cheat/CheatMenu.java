package fr.esiea.inf3132tp2024.view.play.escape.cheat;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.view.play.game.GameView;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TTextField;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.play.escape.EscapeMenu;

public class CheatMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;
    private final TTextField cheatCodeField;

    public CheatMenu(GameView gameView, EscapeMenu escapeMenu) {
        super(0, 0, "Menu de triche");

        TChoices choices = new TChoices(1);
        this.cheatCodeField = new TTextField("Entrez le code de triche", AppSettings.CONSOLE_MIN_LENGTH - 10, "");
        choices.add(cheatCodeField);
        choices.add(new ActivateCheatButton(this, gameView, escapeMenu));
        choices.add(new TQuitComponentButton(this, "Retour"));

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
