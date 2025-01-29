package fr.esiea.inf3132tp2024.model.terrain.effect;

public abstract class TerrainEffect {
    private final int initialTurnsLeft;
    private int turnsLeft;

    protected TerrainEffect(int turnsLeft) {
        this.initialTurnsLeft = turnsLeft;
        this.turnsLeft = turnsLeft;
    }

    /**
     * Get the number of turns left for the terrain effect
     *
     * @return the number of turns left
     */
    public int getTurnsLeft() {
        return turnsLeft;
    }

    /**
     * Decrement the number of turns left for the terrain effect
     */
    public void decrementTurnsLeft() {
        turnsLeft--;
    }

    /**
     * Reset the number of turns left for the terrain effect
     */
    public void resetTurnsLeft() {
        turnsLeft = initialTurnsLeft;
    }
}
