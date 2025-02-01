package fr.esiea.inf3132tp2024.view.play.game;

import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.fight.FightView;

public class NextRoundButton extends TButton {
    private final GameView game;

    public NextRoundButton(GameView game) {
        super("Tour suivant");

        this.game = game;
    }

    @Override
    public void execute() {
        // Next round
        game.getGame().nextRound();

        // Monster alive
        Fight round = new Fight(game.getGame());
        FightView fightView = new FightView(round);

        Terminal.getInstance().show(fightView);
    }
}
