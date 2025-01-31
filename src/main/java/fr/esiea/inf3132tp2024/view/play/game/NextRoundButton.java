package fr.esiea.inf3132tp2024.view.play.game;

import fr.esiea.inf3132tp2024.model.Player;
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
        // Player one
        Player playerOne = game.getGame().getPlayerOne();
        Player playerTwo = game.getGame().getPlayerTwo();
        // Choose default monster
        if (playerOne.getCurrentMonster() == null || !playerOne.getCurrentMonster().isAlive()) {
            playerOne.setCurrentMonster(playerOne.getMonsters()[0]);
        }
        // Player two
        if (playerTwo.getCurrentMonster() == null || !playerTwo.getCurrentMonster().isAlive()) {
            playerTwo.setCurrentMonster(playerTwo.getMonsters()[0]);
        }

        Fight round = new Fight(game.getGame());
        FightView fightView = new FightView(round);

        Terminal.getInstance().show(fightView);
    }
}
