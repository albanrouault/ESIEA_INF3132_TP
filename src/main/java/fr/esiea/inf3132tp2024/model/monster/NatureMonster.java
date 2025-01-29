package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.capacity.SpecialCapacity;

public class NatureMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Nature
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param specialCapacity
     * @param specialCapacityChance
     * @param attacks
     */
    public NatureMonster(String name, int health, int attack, int speed, int defense, SpecialCapacity specialCapacity, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, specialCapacity, specialCapacityChance, attacks);
    }
}
