package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

public class PlantMonster extends NatureMonster {
    /***
     * Constructeur d'un monstre de type Plante
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    public PlantMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, attacks);
    }
}
