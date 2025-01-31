package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public interface SpecialAttackEffect {
    /**
     * Apply the effect of the special attack on the terrain and the monster and the opponent monster.
     *
     * @return true if the effect was applied, false otherwise
     */
    boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster);
}
