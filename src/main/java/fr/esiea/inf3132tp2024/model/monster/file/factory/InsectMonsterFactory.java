package fr.esiea.inf3132tp2024.model.monster.file.factory;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.InsectMonster;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterTooManyAttacks;
import fr.esiea.inf3132tp2024.model.monster.file.FileMonster;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterFactory;

import java.util.Random;

public class InsectMonsterFactory extends MonsterFactory {
    @Override
    protected Monster buildMonster(Random random,
                                   String name, int health, int attack, int speed, int defense,
                                   Attack[] attacks, FileMonster fileMonster
    ) {
        try {
            return new InsectMonster(
                    name, health, attack, speed, defense,
                    attacks
            );
        } catch (MonsterTooManyAttacks e) {
            throw new RuntimeException("Erreur création InsectMonster", e);
        }
    }
}
