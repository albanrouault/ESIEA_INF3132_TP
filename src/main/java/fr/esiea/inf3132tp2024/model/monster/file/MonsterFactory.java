package fr.esiea.inf3132tp2024.model.monster.file;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.Monster;

import java.util.Random;

public abstract class MonsterFactory {
    public Monster createMonster(Random random, FileMonster fileMonster, Attack[] attacks) {
        // Propriétés communes à tous les monstres
        String name = fileMonster.getName();
        int health = fileMonster.getRandomHealth(random);
        int attack = fileMonster.getRandomAttack(random);
        int speed = fileMonster.getRandomSpeed(random);
        int defense = fileMonster.getRandomDefense(random);

        // Appel à la méthode spécialisée pour les propriétés uniques
        return buildMonster(random, name, health, attack, speed, defense, attacks, fileMonster);
    }

    protected abstract Monster buildMonster(Random random,
                                            String name, int health, int attack, int speed, int defense,
                                            Attack[] attacks, FileMonster fileMonster
    );
}
