package fr.esiea.inf3132tp2024.model;

import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class GameStatistic extends TPanel implements Comparable<GameStatistic> {
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
        this(seed, playerOneName, playerTwoName, 0);
    }

    public GameStatistic(long seed, String playerOneName, String playerTwoName, int score) {
        super(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);

        this.seed = seed;
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
        this.score = score;

        this.update();
    }

    private void update() {
        this.getComponents().clear();
        int labelLength = 0;
        int valueLength = 0;

        // Nom des valeurs
        TLabel playerOneLabel = new TLabel(HorizontalAlignment.RIGHT, "Joueur 1:");
        playerOneLabel.getColors().add(TColor.GREEN);
        if (playerOneLabel.getLength() > labelLength) {
            labelLength = playerOneLabel.getLength();
        }
        TLabel playerTwoLabel = new TLabel(HorizontalAlignment.RIGHT, "Joueur 2:");
        playerTwoLabel.getColors().add(TColor.GREEN);
        if (playerTwoLabel.getLength() > labelLength) {
            labelLength = playerTwoLabel.getLength();
        }
        TLabel scoreLabel = new TLabel(HorizontalAlignment.RIGHT, "Score:");
        scoreLabel.getColors().add(TColor.GREEN);
        if (scoreLabel.getLength() > labelLength) {
            labelLength = scoreLabel.getLength();
        }
        TLabel seedLabel = new TLabel(HorizontalAlignment.RIGHT, "Graine utilisée:");
        seedLabel.getColors().add(TColor.GREEN);
        if (seedLabel.getLength() > labelLength) {
            labelLength = seedLabel.getLength();
        }

        playerOneLabel.setLength(labelLength);
        playerTwoLabel.setLength(labelLength);
        scoreLabel.setLength(labelLength);
        seedLabel.setLength(labelLength);

        // Valeurs
        TLabel playerOneValue = new TLabel(HorizontalAlignment.LEFT, this.playerOneName);
        playerOneValue.getColors().add(TColor.YELLOW);
        if (playerOneValue.getLength() > valueLength) {
            valueLength = playerOneValue.getLength();
        }
        TLabel playerTwoValue = new TLabel(HorizontalAlignment.LEFT, this.playerTwoName);
        playerTwoValue.getColors().add(TColor.YELLOW);
        if (playerTwoValue.getLength() > valueLength) {
            valueLength = playerTwoValue.getLength();
        }
        TLabel scoreValue = new TLabel(HorizontalAlignment.LEFT, String.valueOf(this.score));
        scoreValue.getColors().add(TColor.YELLOW);
        if (scoreValue.getLength() > valueLength) {
            valueLength = scoreValue.getLength();
        }
        TLabel seedValue = new TLabel(HorizontalAlignment.LEFT, String.valueOf(this.seed));
        seedValue.getColors().add(TColor.YELLOW);
        if (seedValue.getLength() > valueLength) {
            valueLength = seedValue.getLength();
        }

        playerOneValue.setLength(valueLength);
        playerTwoValue.setLength(valueLength);
        scoreValue.setLength(valueLength);
        seedValue.setLength(valueLength);

        // Panels pour chaque champ
        TPanel playerOnePanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        playerOnePanel.getComponents().add(playerOneLabel);
        playerOnePanel.getComponents().add(playerOneValue);
        playerOnePanel.autoResize();
        this.getComponents().add(playerOnePanel);

        TPanel playerTwoPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        playerTwoPanel.getComponents().add(playerTwoLabel);
        playerTwoPanel.getComponents().add(playerTwoValue);
        playerTwoPanel.autoResize();
        this.getComponents().add(playerTwoPanel);

        TPanel scorePanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        scorePanel.getComponents().add(scoreLabel);
        scorePanel.getComponents().add(scoreValue);
        scorePanel.autoResize();
        this.getComponents().add(scorePanel);

        TPanel seedPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        seedPanel.getComponents().add(seedLabel);
        seedPanel.getComponents().add(seedValue);
        seedPanel.autoResize();
        this.getComponents().add(seedPanel);

        this.autoResize();
    }

    public void activeCheat() {
        this.cheatModeActivated = true;
        this.update();
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
        this.update();
    }

    /**
     * Setter pour changer le nom du joueur 2 défini dans les statistiques.
     *
     * @param playerName le nouveau nom à mettre
     */
    public void setPlayerTwoName(String playerName) {
        this.playerTwoName = playerName;
        this.update();
    }

    /**
     * Méthode pour simuler un calcul de score non exhaustif.
     */
    public void calculScore() {
        this.score = 0;
        this.update();
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
