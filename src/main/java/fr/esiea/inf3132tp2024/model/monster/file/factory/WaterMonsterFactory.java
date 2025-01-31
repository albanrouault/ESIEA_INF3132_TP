package fr.esiea.inf3132tp2024.model.monster.file.factory;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterTooManyAttacks;
import fr.esiea.inf3132tp2024.model.monster.WaterMonster;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterFactory;

import java.util.Random;

public class WaterMonsterFactory extends MonsterFactory {
    @Override
    protected Monster buildMonster(Random random,
                                   String name, int health, int attack, int speed, int defense,
                                   Attack[] attacks, MonsterTemplate monsterTemplate
    ) {
        // Extraction des propriétés spécifiques à l'eau
        float floodChance = monsterTemplate.getRandomCustomFloat("flood", random);
        float fallChance = monsterTemplate.getRandomCustomFloat("fall", random);

        try {
            return new WaterMonster(
                    name, health, attack, speed, defense,
                    floodChance, fallChance, attacks
            );
        } catch (MonsterTooManyAttacks e) {
            throw new RuntimeException("Erreur création WaterMonster", e);
        }
    }
}
