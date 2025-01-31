package fr.esiea.inf3132tp2024.view.play.game;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseMonster.ChooseMonsterView;
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
        // Player one
        Player playerOne = game.getGame().getPlayerOne();
        Player playerTwo = game.getGame().getPlayerTwo();
        // Choose default monster
        do {
            ChooseMonsterView chooseMonsterView = new ChooseMonsterView(playerOne, false);
            Terminal.getInstance().show(chooseMonsterView);
        } while (playerOne.getCurrentMonster() == null);
        // Player two
        do {
            ChooseMonsterView chooseMonsterView = new ChooseMonsterView(playerTwo, false);
            Terminal.getInstance().show(chooseMonsterView);
        } while (playerTwo.getCurrentMonster() == null);

        Fight round = new Fight(game.getGame());
        FightView fightView = new FightView(round);

        Terminal.getInstance().show(fightView);
    }
}
