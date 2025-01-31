package fr.esiea.inf3132tp2024.model.attack.special.earth;

import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.monster.EarthMonster;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.state.BurriedState;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class EarthSpecialAttackEffect implements SpecialAttackEffect {
    // Les monstres de type terre ont la possibilité de se cacher sous terre pendant un à trois tours (nombre aléatoire)
    @Override
    public boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster) {
        if (monster instanceof EarthMonster earthMonster && monster.isAlive()) {
            // Générer un nombre aléatoire entre 1 et 3 inclus
            int randomTurns = random.nextInt(3) + 1;

            BurriedState burriedState = new BurriedState(randomTurns);
            try {
                monster.setState(burriedState);
                return true;
            } catch (MonsterHasAlreadyAState e) {
                return false;
            }
        }
        return false;
    }
}
