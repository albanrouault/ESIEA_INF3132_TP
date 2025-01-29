package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.capacity.SpecialCapacity;

/**
 * Cette classe représente le type de monstre Feu.
 */
public class FireMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Feu
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param specialCapacity
     * @param attacks
     */
    public FireMonster(String name, int health, int attack, int speed, int defense, SpecialCapacity specialCapacity, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, specialCapacity, attacks);
    }
}