package fr.esiea.inf3132tp2024.model.consumable;

import fr.esiea.inf3132tp2024.model.consumable.medicine.curedryfield.CureDryField;
import fr.esiea.inf3132tp2024.model.consumable.medicine.healburn.HealBurn;
import fr.esiea.inf3132tp2024.model.consumable.potion.power.PowerPotion;
import fr.esiea.inf3132tp2024.model.consumable.potion.regen.RegenPotion;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class ConsumableGen {
    private static final List<Consumable> consumables = new LinkedList<>();

    static {
        for (int i = 0; i < 3; i++) {
            consumables.add(new CureDryField(1));
            consumables.add(new HealBurn(1));
            consumables.add(new PowerPotion(30));
            consumables.add(new RegenPotion(50));
        }
    }

    public static Consumable getRandomConsumable(Random random) {
        return consumables.get(random.nextInt(consumables.size()));
    }
}
