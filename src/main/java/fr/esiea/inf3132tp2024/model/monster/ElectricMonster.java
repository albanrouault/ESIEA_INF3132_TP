package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.ElectricSpecialAttack;

public class ElectricMonster extends Monster {
    private final float paralyzeChance;

    /***
     * Constructeur d'un monstre de type Électrique
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param paralyzeChance
     * @param specialCapacityChance
     * @param attacks
     */
    public ElectricMonster(String name, int health, int attack, int speed, int defense, float paralyzeChance, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.ELECTRIC, name, health, attack, speed, defense, new ElectricSpecialAttack(), specialCapacityChance, attacks);

        this.paralyzeChance = paralyzeChance;
    }

    /**
     * Récupérer la chance de paralyser l'adversaire
     */
    public float getParalyzeChance() {
        return paralyzeChance;
    }
}
