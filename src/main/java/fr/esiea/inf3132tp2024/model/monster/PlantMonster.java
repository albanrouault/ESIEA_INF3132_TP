package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public class PlantMonster extends NatureMonster {
    private final float healAfterAttackChance;

    /***
     * Constructeur d'un monstre de type Plante
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param healAfterAttackChance
     * @param specialAttack
     * @param specialCapacityChance
     * @param attacks
     */
    public PlantMonster(String name, int health, int attack, int speed, int defense, float healAfterAttackChance, SpecialAttack specialAttack, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.NATURE_PLANT, name, health, attack, speed, defense, specialAttack, specialCapacityChance, attacks);

        this.healAfterAttackChance = healAfterAttackChance;
    }

    /**
     * Retourne la chance de soigner après une attaque
     *
     * @return La chance de soigner après une attaque
     */
    public float getHealAfterAttackChance() {
        return healAfterAttackChance;
    }
}
