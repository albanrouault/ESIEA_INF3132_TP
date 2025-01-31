package fr.esiea.inf3132tp2024.model.consumable;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public interface ConsumableEffect {
    /**
     * Apply the effect of the consumable on the terrain and the monster
     *
     * @return true if the effect was applied, false otherwise
     */
    boolean apply(Terrain terrain, Monster monster);
}
