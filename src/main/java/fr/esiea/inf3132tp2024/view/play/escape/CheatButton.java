package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.view.play.game.Game;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TInfoDialog;
import fr.esiea.inf3132tp2024.view.play.escape.cheat.CheatMenu;

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
            Terminal.getInstance().show(new TInfoDialog(DialogType.WARNING, "Une fois la triche activée, vos statistiques ne seront pas sauvegardées."));
        }
        Terminal.getInstance().show(new CheatMenu(game, escapeMenu));
    }
}
