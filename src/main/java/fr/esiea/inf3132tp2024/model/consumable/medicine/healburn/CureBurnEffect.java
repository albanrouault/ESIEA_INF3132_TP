package fr.esiea.inf3132tp2024.model.consumable.medicine.healburn;

import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.state.BurntState;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public class CureBurnEffect implements ConsumableEffect {
    @Override
    public boolean apply(Terrain terrain, Monster monster) {
        if (monster.isAlive() && monster.getState() instanceof BurntState) {
            try {
                monster.setState(null);
            } catch (MonsterHasAlreadyAState e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
