package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;

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
     * @param attacks
     */
    public PlantMonster(String name, int health, int attack, int speed, int defense, float healAfterAttackChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.NATURE_PLANT, name, health, attack, speed, defense, attacks);

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
