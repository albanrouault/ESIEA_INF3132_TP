package fr.esiea.inf3132tp2024.model.attack.special.nature.insect;

import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.monster.InsectMonster;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.state.PoisonedState;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class NatureInsectSpecialAttackEffect implements SpecialAttackEffect {
    // A l’instar des monstres de type feu, les monstres de type insecte peuvent empoisonner leur
    // cible. Une cible empoisonnée subit alors un dixième de son attaque au début de son tour et
    // l’état d’empoisonnement est retiré quand le monstre se trouve dans un terrain inondé. Cela
    // se déclenche à chaque fois que le monstre utilise une attaque spéciale (type nature).
    @Override
    public boolean apply(Random random, Terrain terrain, Monster monster, Monster opponentMonster) {
        if (monster instanceof InsectMonster insectMonster && monster.isAlive()) {
            PoisonedState poisonedState = new PoisonedState(Integer.MAX_VALUE);
            try {
                opponentMonster.setState(poisonedState);
                return true;
            } catch (MonsterHasAlreadyAState e) {
                return false;
            }
        }
        return false;
    }
}
