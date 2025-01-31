package fr.esiea.inf3132tp2024.model.attack.special.fire;

import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.monster.FireMonster;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.state.BurntState;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class FireSpecialAttackEffect implements SpecialAttackEffect {
    // Les monstres de type feu ont la possibilité de brûler leur adversaire. Quand un monstre est
    // brûlé, il subit au début de chaque tour un dixième de son attaque. Cela se déclenche à
    // chaque fois que le monstre utilise une attaque spéciale (type feu). La seule possibilité de
    // soigner un monstre d’une brûlure est de se trouver dans un terrain inondé.
    @Override
    public boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster) {
        if (monster instanceof FireMonster fireMonster && monster.isAlive()) {
            BurntState burntState = new BurntState();
            try {
                opponentMonster.setState(burntState);
                return true;
            } catch (MonsterHasAlreadyAState e) {
                return false;
            }
        }
        return false;
    }
}
