package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.capacity.SpecialCapacity;

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
    public InsectMonster(String name, int health, int attack, int speed, int defense, SpecialCapacity specialCapacity, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, specialCapacity, attacks);
    }
}


