package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
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
    public NatureMonster(String name, int health, int attack, int speed, int defense, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.NATURE, name, health, attack, speed, defense, attacks);
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
     * @param attacks
     */
    protected NatureMonster(Types type, String name, int health, int attack, int speed, int defense, Attack[] attacks) throws MonsterTooManyAttacks {
        super(type, name, health, attack, speed, defense, attacks);
    }
}
