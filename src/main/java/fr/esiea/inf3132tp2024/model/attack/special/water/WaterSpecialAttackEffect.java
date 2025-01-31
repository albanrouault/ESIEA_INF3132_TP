package fr.esiea.inf3132tp2024.model.attack.special.water;

import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.WaterMonster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.model.terrain.TerrainHasAlreadyAnEffect;
import fr.esiea.inf3132tp2024.model.terrain.effect.FloodTerrainEffect;

import java.util.Random;

public class WaterSpecialAttackEffect implements SpecialAttackEffect {
    // Les monstres de type eau ont la possibilité d’inonder le terrain pendant un à trois tours.
    // Quand le terrain est inondé, l’adversaire a une chance de glisser pendant son attaque.
    // L’attaque est alors annulée et ce dernier subit des dégâts équivalents aux quart de sa propre attaque.
    @Override
    public boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster) {
        if (monster instanceof WaterMonster waterMonster && monster.isAlive()) {
            // Générer un nombre aléatoire entre 1 et 3 inclus
            int randomTurns = random.nextInt(3) + 1;

            FloodTerrainEffect floodTerrainEffect = new FloodTerrainEffect(waterMonster, randomTurns);
            try {
                terrain.setEffect(floodTerrainEffect);
                return true;
            } catch (TerrainHasAlreadyAnEffect e) {
                return false;
            }
        }
        return false;
    }
}
