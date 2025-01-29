package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

public class InsectMonster extends NatureMonster {
    /***
     * Constructeur d'un monstre de type Insecte
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    public InsectMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) {
        super(name, health, attack, speed, defense, attacks);
    }
}


