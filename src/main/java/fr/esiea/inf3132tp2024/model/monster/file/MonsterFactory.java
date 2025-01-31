package fr.esiea.inf3132tp2024.model.monster.file;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.Monster;

import java.util.Random;

public abstract class MonsterFactory {
    public Monster createMonster(Random random, MonsterTemplate monsterTemplate, Attack[] attacks) {
        // Propriétés communes à tous les monstres
        String name = monsterTemplate.getName();
        int health = monsterTemplate.getRandomHealth(random);
        int attack = monsterTemplate.getRandomAttack(random);
        int speed = monsterTemplate.getRandomSpeed(random);
        int defense = monsterTemplate.getRandomDefense(random);

        // Appel à la méthode spécialisée pour les propriétés uniques
        return buildMonster(random, name, health, attack, speed, defense, attacks, monsterTemplate);
    }

    protected abstract Monster buildMonster(Random random,
                                            String name, int health, int attack, int speed, int defense,
                                            Attack[] attacks, MonsterTemplate monsterTemplate
    );
}
