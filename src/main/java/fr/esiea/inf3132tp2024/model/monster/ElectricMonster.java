package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;

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
     * @param attacks
     */
    public ElectricMonster(String name, int health, int attack, int speed, int defense, float paralyzeChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.ELECTRIC, name, health, attack, speed, defense, attacks);

        this.paralyzeChance = paralyzeChance;
    }

    /**
     * Récupérer la chance de paralyser l'adversaire
     */
    public float getParalyzeChance() {
        return paralyzeChance;
    }
}
