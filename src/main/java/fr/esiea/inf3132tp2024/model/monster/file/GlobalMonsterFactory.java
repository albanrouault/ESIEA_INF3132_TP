package fr.esiea.inf3132tp2024.model.monster.file;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.file.factory.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GlobalMonsterFactory {
    // Bloquer l'instanciation de la classe
    private GlobalMonsterFactory() {
    }

    private static final Map<Types, MonsterFactory> monsterFactories = new HashMap<>();

    static {
        monsterFactories.put(Types.WATER, new WaterMonsterFactory());
        monsterFactories.put(Types.EARTH, new EarthMonsterFactory());
        monsterFactories.put(Types.FIRE, new FireMonsterFactory());
        monsterFactories.put(Types.ELECTRIC, new ElectricMonsterFactory());
        monsterFactories.put(Types.NATURE_PLANT, new PlantMonsterFactory());
        monsterFactories.put(Types.NATURE_INSECT, new InsectMonsterFactory());
        monsterFactories.put(Types.NATURE, new NatureMonsterFactory());
    }

    public static Monster createMonster(Random random, FileMonster fileMonster, Attack[] attacks) {
        MonsterFactory factory = monsterFactories.get(fileMonster.getType());
        if (factory == null) {
            throw new IllegalArgumentException("Type non supporté: " + fileMonster.getType());
        }
        return factory.createMonster(random, fileMonster, attacks);
    }
}
