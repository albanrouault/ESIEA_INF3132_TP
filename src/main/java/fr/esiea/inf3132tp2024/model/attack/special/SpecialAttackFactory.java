package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.special.earth.EarthSpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.electric.ElectricSpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.fire.FireSpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.nature.insect.NatureInsectSpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.nature.plant.NaturePlantSpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.water.WaterSpecialAttackEffect;

import java.util.HashMap;
import java.util.Map;

public class SpecialAttackFactory {
    // Bloquer l'instanciation de la classe
    private SpecialAttackFactory() {
    }

    private static final Map<Types, SpecialAttackEffect> specialEffects = new HashMap<>();

    static {
        specialEffects.put(Types.EARTH, new EarthSpecialAttackEffect());
        specialEffects.put(Types.ELECTRIC, new ElectricSpecialAttackEffect());
        specialEffects.put(Types.WATER, new WaterSpecialAttackEffect());
        specialEffects.put(Types.FIRE, new FireSpecialAttackEffect());
        specialEffects.put(Types.NATURE_PLANT, new NaturePlantSpecialAttackEffect());
        specialEffects.put(Types.NATURE_INSECT, new NatureInsectSpecialAttackEffect());
    }

    public static SpecialAttackEffect getSpecialAttackEffect(Types type) {
        return specialEffects.getOrDefault(type.getMainType(), null);
    }
}
