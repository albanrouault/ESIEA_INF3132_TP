package fr.esiea.inf3132tp2024.model.attack.processor;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackFactory;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

import java.util.Random;

public class AttackProcessor {
    private static final float BASE_ATTACK_COEF = 0.85f;
    private static final int BASE_ATTACK_MULTIPLIER = 20;

    public static void processAttack(Random random, Monster attacker, Attack attack, Monster defender, Terrain terrain) {
        // Gestion des attaques de base (mains nues)
        if (attack == null) {
            int damage = calculateBasicAttackDamage(random, attacker, defender);
            defender.damage(damage);
            return;
        }

        // Vérification utilisabilité de l'attaque spéciale
        if (!attack.isUsable()) return;

        // Calcul des dégâts selon le type d'attaque
        int damage = calculateDamage(random, attacker, attack, defender);
        defender.damage(damage);
        attack.use();

        // Application des effets spéciaux
        applySpecialEffects(random, attacker, attack, defender, terrain);
    }

    private static int calculateBasicAttackDamage(Random random, Monster attacker, Monster defender) {
        float advantage = calculateTypeAdvantage(attacker.getType(), defender.getType());
        float coef = BASE_ATTACK_COEF + random.nextFloat() * (1 - BASE_ATTACK_COEF);

        double damage = 1.0 * BASE_ATTACK_MULTIPLIER * ((float) attacker.getAttack() / defender.getDefense()) * advantage * coef;

        return (int) Math.round(damage);
    }

    private static int calculateDamage(Random random, Monster attacker, Attack attack, Monster defender) {
        float advantage = calculateTypeAdvantage(attacker.getType(), defender.getType());
        float coef = BASE_ATTACK_COEF + random.nextFloat() * (1 - BASE_ATTACK_COEF);

        double damage = ((11.0 * attacker.getAttack() * attack.getDamage())
                / (25.0 * defender.getDefense()) + 2)
                * advantage * coef;

        return (int) Math.round(damage);
    }

    private static float calculateTypeAdvantage(Types attackType, Types defenderType) {
        if (attackType.isStrongAgainst(defenderType)) return 2.0f;
        if (attackType.isWeakAgainst(defenderType)) return 0.5f;
        return 1.0f;
    }

    private static void applySpecialEffects(Random random, Monster attacker, Attack attack,
                                            Monster defender, Terrain terrain) {
        if (attack.getType() != Types.NORMAL && attack.getType() == attacker.getType()) {
            SpecialAttackEffect effect = SpecialAttackFactory.getSpecialAttackEffect(attacker.getType());
            if (effect != null) {
                effect.apply(random, terrain, attacker, defender);
            }
        }
    }
}
