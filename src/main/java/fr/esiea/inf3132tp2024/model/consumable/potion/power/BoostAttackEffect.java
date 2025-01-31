package fr.esiea.inf3132tp2024.model.consumable.potion.power;

import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public class BoostAttackEffect implements ConsumableEffect {
    private final int power;

    public BoostAttackEffect(int power) {
        this.power = power;
    }

    @Override
    public boolean apply(Terrain terrain, Monster monster) {
        monster.strengthen(power);
        return true;
    }
}
