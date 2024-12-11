package fr.esiea.inf3132tp2024.gui.play.escape;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.game.Game;
import fr.esiea.inf3132tp2024.gui.component.CButton;
import fr.esiea.inf3132tp2024.gui.dialog.DialogType;
import fr.esiea.inf3132tp2024.gui.dialog.InfoDialog;
import fr.esiea.inf3132tp2024.gui.play.escape.cheat.CheatMenu;

public class CheatButton extends CButton {
    private final App app;
    private final Game game;
    private final EscapeMenu escapeMenu;

    public CheatButton(App app, Game game, EscapeMenu escapeMenu) {
        super(app, "Triche");

        this.app = app;
        this.game = game;
        this.escapeMenu = escapeMenu;
    }

    @Override
    public void execute() {
        if (!game.getStatistic().isCheatModeActivated()) {
            app.getConsole().show(new InfoDialog(DialogType.WARNING, "Une fois la triche activée, vos statistiques ne seront pas sauvegardées."));
        }
        app.getConsole().show(new CheatMenu(app, game, escapeMenu));
    }
}
