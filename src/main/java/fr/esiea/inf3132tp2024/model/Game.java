package fr.esiea.inf3132tp2024.model;

import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Objects;
import java.util.Random;

public class Game {
    private final long seed;
    private final Random random;
    private final Player playerOne;
    private final Player playerTwo;
    private final Terrain terrain;
    private final GameStatistic gameStatistic;

    private int round = 0;

    public Game(long seed, Random random, Player playerOne, Player playerTwo) {
        this.seed = seed;
        this.random = Objects.requireNonNullElseGet(random, () -> new Random(seed));
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.terrain = new Terrain();
        this.gameStatistic = new GameStatistic(seed, playerOne.getName(), playerTwo.getName());
    }

    public long getSeed() {
        return seed;
    }

    public Random getRandom() {
        return random;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public GameStatistic getGameStatistic() {
        return gameStatistic;
    }

    public int getRound() {
        return round;
    }

    public void nextRound() {
        round++;
    }
}
