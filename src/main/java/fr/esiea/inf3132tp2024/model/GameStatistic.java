package fr.esiea.inf3132tp2024.model;

public class GameStatistic implements Comparable<GameStatistic> {
    private final long seed;

    private String playerOneName;
    private String playerTwoName;
    private int score;

    private boolean cheatModeActivated = false;

    /**
     * Constructeur
     *
     * @param seed          la graine de la carte utilisée
     * @param playerOneName le nom du premier joueur de la partie
     * @param playerTwoName le nom du deuxième joueur de la partie
     */
    public GameStatistic(long seed, String playerOneName, String playerTwoName) {
        this(playerOneName, playerTwoName, 0, seed);
    }

    public GameStatistic(String playerOneName, String playerTwoName, int score, long seed) {
        this.seed = seed;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.score = score;
    }

    public void activeCheat() {
        this.cheatModeActivated = true;
    }

    public boolean isCheatModeActivated() {
        return this.cheatModeActivated;
    }

    /**
     * Setter pour changer le nom du joueur 1 défini dans les statistiques.
     *
     * @param playerName le nouveau nom à mettre
     */
    public void setPlayerOneName(String playerName) {
        this.playerOneName = playerName;
    }

    /**
     * Setter pour changer le nom du joueur 2 défini dans les statistiques.
     *
     * @param playerName le nouveau nom à mettre
     */
    public void setPlayerTwoName(String playerName) {
        this.playerTwoName = playerName;
    }

    /**
     * Méthode pour simuler un calcul de score non exhaustif.
     */
    public void calculScore() {
        this.score = 0;
    }


    public long getSeed() {
        return seed;
    }

    public String getPlayerOneName() {
        return playerOneName;
    }

    public String getPlayerTwoName() {
        return playerTwoName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public int compareTo(GameStatistic stat) {
        if (stat == null) {
            return 1;
        }
        return Integer.compare(stat.score, this.score);
    }
}
