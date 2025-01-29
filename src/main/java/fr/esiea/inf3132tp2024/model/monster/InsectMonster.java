package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.NatureInsectSpecialAttack;

public class InsectMonster extends NatureMonster {
    /***
     * Constructeur d'un monstre de type Insecte
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param specialCapacityChance
     * @param attacks
     */
    public InsectMonster(String name, int health, int attack, int speed, int defense, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.NATURE_INSECT, name, health, attack, speed, defense, new NatureInsectSpecialAttack(), specialCapacityChance, attacks);
    }
}


