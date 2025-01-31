package fr.esiea.inf3132tp2024.model.monster.file.factory;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterTooManyAttacks;
import fr.esiea.inf3132tp2024.model.monster.PlantMonster;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterFactory;

import java.util.Random;

public class PlantMonsterFactory extends MonsterFactory {
    @Override
    protected Monster buildMonster(Random random,
                                   String name, int health, int attack, int speed, int defense,
                                   Attack[] attacks, MonsterTemplate monsterTemplate
    ) {
        // Extraction des propriétés spécifiques à la plante
        float healing = monsterTemplate.getRandomCustomFloat("healing", random);

        try {
            return new PlantMonster(
                    name, health, attack, speed, defense, healing,
                    attacks
            );
        } catch (MonsterTooManyAttacks e) {
            throw new RuntimeException("Erreur création PlantMonster", e);
        }
    }
}
