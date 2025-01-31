package fr.esiea.inf3132tp2024.model.attack.file;

import fr.esiea.inf3132tp2024.model.attack.Attack;

import java.util.Random;

public class AttackFactory {
    public static Attack createAttack(Random random, AttackTemplate attackTemplate) {
        // Mapping des propriétés
        int damage = attackTemplate.getRandomPower(random);
        float chanceOfSuccess = 1.0f - attackTemplate.getRandomMaxFail(random);
        int nbUses = attackTemplate.getRandomNbUse(random);

        return new Attack(
                attackTemplate.getType(),
                attackTemplate.getName(),
                damage,
                chanceOfSuccess,
                nbUses
        );
    }
}
