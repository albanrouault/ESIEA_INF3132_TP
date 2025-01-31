package fr.esiea.inf3132tp2024.controller.exemple;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffectFactory;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public class ConsumableApplier {
    public void applyConsumable(Consumable consumable, Terrain terrain, Monster target) {
        if (!consumable.isConsumed()) {
            ConsumableEffect effect = ConsumableEffectFactory.createEffect(consumable);
            if (effect.apply(terrain, target)) {
                consumable.consume();
            }
        }
    }
}
