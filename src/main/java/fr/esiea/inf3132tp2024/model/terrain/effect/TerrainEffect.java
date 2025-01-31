package fr.esiea.inf3132tp2024.model.terrain.effect;

public abstract class TerrainEffect {
    private final String name;
    private final boolean isPermanent;
    private final int initialTurnsLeft;
    private int turnsLeft;
    private int turnsPassed = 0;

    protected TerrainEffect(String name, int turnsLeft) {
        this.name = name;
        this.isPermanent = false;
        this.initialTurnsLeft = turnsLeft;
        this.turnsLeft = turnsLeft;
    }

    protected TerrainEffect(String name) {
        this.name = name;
        this.isPermanent = true;
        this.initialTurnsLeft = Integer.MAX_VALUE;
        this.turnsLeft = Integer.MAX_VALUE;
    }

    /**
     * Get the name of the state
     *
     * @return the name of the state
     */
    public String getName() {
        return name;
    }

    /**
     * Check if the state is permanent
     *
     * @return true if the state is permanent, false otherwise
     */
    public boolean isPermanent() {
        return isPermanent;
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
     * Get the number of turns passed for the terrain effect
     *
     * @return the number of turns passed
     */
    public int getTurnsPassed() {
        return turnsPassed;
    }

    /**
     * Decrement the number of turns left for the terrain effect
     */
    public void decrementTurnsLeft() {
        if (!isPermanent) {
            turnsLeft--;
        }
        turnsPassed++;
    }

    /**
     * Reset the number of turns left for the terrain effect
     */
    public void resetTurnsLeft() {
        turnsLeft = initialTurnsLeft;
    }
}
