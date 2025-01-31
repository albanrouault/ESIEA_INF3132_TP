package fr.esiea.inf3132tp2024.model.monster.file.factory;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.ElectricMonster;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterTooManyAttacks;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterFactory;

import java.util.Random;

public class ElectricMonsterFactory extends MonsterFactory {
    @Override
    protected Monster buildMonster(Random random,
                                   String name, int health, int attack, int speed, int defense,
                                   Attack[] attacks, MonsterTemplate monsterTemplate
    ) {
        // Extraction des propriétés spécifiques à l'électricité
        float paralysis = monsterTemplate.getRandomCustomFloat("paralysis", random);

        try {
            return new ElectricMonster(
                    name, health, attack, speed, defense,
                    paralysis, attacks
            );
        } catch (MonsterTooManyAttacks e) {
            throw new RuntimeException("Erreur création ElectricMonster", e);
        }
    }
}
