package fr.esiea.inf3132tp2024.model.fight;

import fr.esiea.inf3132tp2024.model.Game;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class Fight {
    private final Random random;
    private final int round;
    private final Game game;
    private final Terrain terrain;
    private final Player playerOne;
    private final Player playerTwo;
    private FightState state = FightState.STARTING;

    public Fight(Game game) {
        this.random = game.getRandom();
        this.round = game.getRound();
        this.game = game;
        this.terrain = game.getTerrain();
        this.playerOne = game.getPlayerOne();
        this.playerTwo = game.getPlayerTwo();
    }

    public Random getRandom() {
        return random;
    }

    public int getRound() {
        return round;
    }

    public Game getGame() {
        return game;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public FightState getState() {
        return state;
    }

    public void setState(FightState state) {
        this.state = state;
    }
}
