package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

public class NatureMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Nature
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    public NatureMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) {
        super(name, health, attack, speed, defense, attacks);
    }
}
