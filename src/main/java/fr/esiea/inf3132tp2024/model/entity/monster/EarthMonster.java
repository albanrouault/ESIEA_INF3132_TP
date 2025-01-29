package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

/**
 * Cette classe représente le type de monstre Terre.
 */
public class EarthMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Terre
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    public EarthMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) {
        super(name, health, attack, speed, defense, attacks);
    }
}