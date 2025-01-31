package fr.esiea.inf3132tp2024.model.attack.special.electric;

import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.monster.ElectricMonster;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.state.ParalysedState;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class ElectricSpecialAttackEffect implements SpecialAttackEffect {
    // Après une attaque, les monstres de type foudre ont une chance de paralyser leur adversaire
    // pendant un certain nombre de tour. Un monstre déjà paralysé peut-être de nouveau
    // paralysé.
    @Override
    public boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster) {
        if (monster instanceof ElectricMonster electricMonster && monster.isAlive()) {
            // Générer un nombre aléatoire entre 1 et 3 inclus
            int randomTurns = random.nextInt(3) + 1;

            ParalysedState paralysedState = new ParalysedState(randomTurns);
            try {
                opponentMonster.setState(paralysedState);
                return true;
            } catch (MonsterHasAlreadyAState e) {
                // Un monstre déjà paralysé peut-être de nouveau paralysé
                if (opponentMonster.getState() instanceof ParalysedState) {
                    opponentMonster.getState().resetTurnsLeft();
                    return true;
                }
                return false;
            }
        }
        return false;
    }
}
