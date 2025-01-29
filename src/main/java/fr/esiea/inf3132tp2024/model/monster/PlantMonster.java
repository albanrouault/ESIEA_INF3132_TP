package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.capacity.SpecialCapacity;

public class PlantMonster extends NatureMonster {
    /***
     * Constructeur d'un monstre de type Plante
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param specialCapacity
     * @param attacks
     */
    public PlantMonster(String name, int health, int attack, int speed, int defense, SpecialCapacity specialCapacity, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, specialCapacity, attacks);
    }
}
