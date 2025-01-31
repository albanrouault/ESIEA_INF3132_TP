package fr.esiea.inf3132tp2024.model.attack.file;

import fr.esiea.inf3132tp2024.model.attack.Attack;

import java.util.Random;

public class AttackFactory {
    public static Attack createAttack(Random random, FileAttack fileAttack) {
        // Mapping des propriétés
        int damage = fileAttack.getRandomPower(random);
        float chanceOfSuccess = 1.0f - fileAttack.getRandomMaxFail(random);
        int nbUses = fileAttack.getRandomNbUse(random);

        return new Attack(
                fileAttack.getType(),
                fileAttack.getName(),
                damage,
                chanceOfSuccess,
                nbUses
        );
    }
}
