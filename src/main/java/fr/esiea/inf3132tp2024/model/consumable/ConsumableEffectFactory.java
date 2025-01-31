package fr.esiea.inf3132tp2024.model.consumable;

import fr.esiea.inf3132tp2024.model.consumable.medicine.Medicine;
import fr.esiea.inf3132tp2024.model.consumable.medicine.curedryfield.CureDryField;
import fr.esiea.inf3132tp2024.model.consumable.medicine.curedryfield.DryTerrainEffect;
import fr.esiea.inf3132tp2024.model.consumable.medicine.healburn.CureBurnEffect;
import fr.esiea.inf3132tp2024.model.consumable.medicine.healburn.HealBurn;
import fr.esiea.inf3132tp2024.model.consumable.potion.Potion;
import fr.esiea.inf3132tp2024.model.consumable.potion.power.BoostAttackEffect;
import fr.esiea.inf3132tp2024.model.consumable.potion.power.PowerPotion;
import fr.esiea.inf3132tp2024.model.consumable.potion.regen.HealEffect;
import fr.esiea.inf3132tp2024.model.consumable.potion.regen.RegenPotion;

public class ConsumableEffectFactory {
    public static ConsumableEffect createEffect(Consumable consumable) {
        // CAT : Médicaments
        if (consumable instanceof Medicine medicine) {
            // Asséchement du terrain
            if (medicine instanceof CureDryField cureDryField) {
                return new DryTerrainEffect();
            }
            // Soin de brûlure
            else if (medicine instanceof HealBurn healBurn) {
                return new CureBurnEffect();
            }
        }
        // CAT : Potions
        else if (consumable instanceof Potion potion) {
            // Soins
            if (potion instanceof RegenPotion regenPotion) {
                return new HealEffect(regenPotion.getRegenAmount());
            }
            // Force
            else if (potion instanceof PowerPotion powerPotion) {
                return new BoostAttackEffect(powerPotion.getAttackBoost());
            }
        }

        // Effet non défini -> throw exception
        throw new IllegalArgumentException("Effet non défini pour le consommable " + consumable.getName());
    }
}
