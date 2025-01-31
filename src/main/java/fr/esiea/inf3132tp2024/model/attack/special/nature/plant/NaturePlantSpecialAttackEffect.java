package fr.esiea.inf3132tp2024.model.attack.special.nature.plant;

import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.PlantMonster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class NaturePlantSpecialAttackEffect implements SpecialAttackEffect {
    // Les monstres de type plante ont une chance, à la fin d’une attaque, de se soigner, ce qui
    // supprime les altérations d’état (empoisonnement, paralysie, brûlure)
    @Override
    public boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster) {
        if (monster instanceof PlantMonster plantMonster && monster.isAlive() && monster.hasState()) {
            float healChance = plantMonster.getHealAfterAttackChance();
            if (random.nextFloat() < healChance) {
                try {
                    monster.setState(null);
                    return true;
                } catch (MonsterHasAlreadyAState e) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
