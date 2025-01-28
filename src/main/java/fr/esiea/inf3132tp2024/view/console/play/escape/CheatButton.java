package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.game.Game;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.api.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.console.api.dialog.InfoDialog;
import fr.esiea.inf3132tp2024.view.console.play.escape.cheat.CheatMenu;

public class CheatButton extends TButton {
    private final Game game;
    private final EscapeMenu escapeMenu;

    public CheatButton(Game game, EscapeMenu escapeMenu) {
        super("Triche");

        this.game = game;
        this.escapeMenu = escapeMenu;
    }

    @Override
    public void execute() {
        if (!game.getStatistic().isCheatModeActivated()) {
            Console.getInstance().show(new InfoDialog(DialogType.WARNING, "Une fois la triche activée, vos statistiques ne seront pas sauvegardées."));
        }
        Console.getInstance().show(new CheatMenu(game, escapeMenu));
    }
}
