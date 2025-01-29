package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

/**
 * Cette classe représente le type de monstre Eau.
 */
public class WaterMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Eau
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    public WaterMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, attacks);
    }
}