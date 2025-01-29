package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public abstract class NatureMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Nature
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param specialCapacityChance
     * @param attacks
     */
    public NatureMonster(String name, int health, int attack, int speed, int defense, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.NATURE, name, health, attack, speed, defense, null, specialCapacityChance, attacks);
    }

    /***
     * Constructeur d'un monstre de type Nature
     *
     * @param type
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param specialAttack
     * @param specialCapacityChance
     * @param attacks
     */
    protected NatureMonster(Types type, String name, int health, int attack, int speed, int defense, SpecialAttack specialAttack, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(type, name, health, attack, speed, defense, specialAttack, specialCapacityChance, attacks);
    }
}
