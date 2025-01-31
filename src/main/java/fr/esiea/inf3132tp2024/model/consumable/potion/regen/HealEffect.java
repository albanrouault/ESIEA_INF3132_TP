package fr.esiea.inf3132tp2024.model.consumable.potion.regen;

import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public class HealEffect implements ConsumableEffect {
    private final int life;

    public HealEffect(int life) {
        this.life = life;
    }

    @Override
    public boolean apply(Terrain terrain, Monster monster) {
        if (monster.isAlive()) {
            monster.heal(life);
            return true;
        }
        return false;
    }
}
