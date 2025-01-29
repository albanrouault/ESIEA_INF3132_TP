package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.EarthSpecialAttack;

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
     * @param specialCapacityChance
     * @param attacks
     */
    public EarthMonster(String name, int health, int attack, int speed, int defense, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.EARTH, name, health, attack, speed, defense, new EarthSpecialAttack(), specialCapacityChance, attacks);
    }
}