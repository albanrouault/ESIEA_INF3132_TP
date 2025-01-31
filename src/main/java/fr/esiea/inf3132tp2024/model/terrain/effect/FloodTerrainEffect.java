package fr.esiea.inf3132tp2024.model.terrain.effect;

import fr.esiea.inf3132tp2024.model.monster.WaterMonster;

public class FloodTerrainEffect extends TerrainEffect {
    private final WaterMonster author;
    private final float opponentFloodedFallChance;

    /**
     * Constructor of the FloodTerrainEffect class
     *
     * @param author    the author of the effect
     * @param turnsLeft the number of turns left for the effect
     */
    public FloodTerrainEffect(WaterMonster author, int turnsLeft) {
        super("Terrain inondé", turnsLeft);

        this.author = author;
        this.opponentFloodedFallChance = author.getOpponentFloodedFallChance();
    }

    /**
     * Get the author of the effect
     *
     * @return the author of the effect
     */
    public WaterMonster getAuthor() {
        return author;
    }

    /**
     * Get the chance of the opponent to fall in the flooded terrain
     *
     * @return the chance of the opponent to fall in the flooded terrain
     */
    public float getOpponentFloodedFallChance() {
        return opponentFloodedFallChance;
    }
}
