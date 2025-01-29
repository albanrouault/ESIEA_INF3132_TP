package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

public class LightningMonster extends Monster {
    /***
     * Constructeur d'un monstre de type Foudre
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    public LightningMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, attacks);
    }
}
