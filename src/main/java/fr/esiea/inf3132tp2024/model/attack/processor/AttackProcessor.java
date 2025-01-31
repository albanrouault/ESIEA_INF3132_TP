package fr.esiea.inf3132tp2024.model.attack.processor;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackFactory;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class AttackProcessor {
    public static void processAttack(Random random, Monster attacker, Attack attack, Monster defender, Terrain terrain) {
        if (!attack.isUsable()) return;

        // Calcul des dégâts
        int damage = calculateDamage(attacker, attack, defender);
        defender.damage(damage);
        attack.use();

        // Gestion des effets spéciaux
        if (attack.getType() != Types.NORMAL) {
            applySpecialEffect(random, attacker, defender, terrain);
        }
    }

    private static int calculateDamage(Monster attacker, Attack attack, Monster defender) {
        float advantage = calculateTypeAdvantage(attack.getType(), defender.getType());
        float coef = 0.85f + (float) Math.random() * 0.15f;

        double baseDamage = ((11.0 * attacker.getAttack() * attack.getDamage())
                / (25.0 * defender.getDefense()) + 2)
                * advantage * coef;

        return (int) Math.round(baseDamage);
    }

    private static float calculateTypeAdvantage(Types attackType, Types defenderType) {
        if (attackType.isStrongAgainst(defenderType)) return 2.0f;
        if (attackType.isWeakAgainst(defenderType)) return 0.5f;
        return 1.0f;
    }

    private static void applySpecialEffect(Random random, Monster attacker, Monster defender, Terrain terrain) {
        SpecialAttackEffect specialAttackEffect = SpecialAttackFactory.getSpecialAttackEffect(attacker.getType());
        if (specialAttackEffect != null) {
            specialAttackEffect.apply(random, terrain, attacker, defender);
        }
    }
}
