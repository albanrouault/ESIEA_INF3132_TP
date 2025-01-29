package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.WaterSpecialAttack;

/**
 * Cette classe représente le type de monstre Eau.
 */
public class WaterMonster extends Monster {
    private final float floodChance;
    private final float opponentFloodedFallChance;

    /***
     * Constructeur d'un monstre de type Eau
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param floodChance
     * @param opponentFloodedFallChance
     * @param specialCapacityChance
     * @param attacks
     */
    public WaterMonster(String name, int health, int attack, int speed, int defense, float floodChance, float opponentFloodedFallChance, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.WATER, name, health, attack, speed, defense, new WaterSpecialAttack(), specialCapacityChance, attacks);

        this.floodChance = floodChance;
        this.opponentFloodedFallChance = opponentFloodedFallChance;
    }

    /**
     * Récupérer la chance de provoquer une inondation
     *
     * @return La chance de provoquer une inondation
     */
    public float getFloodChance() {
        return floodChance;
    }

    /**
     * Récupérer la chance de faire tomber l'adversaire lorsque le terrain est inondé
     *
     * @return La chance de faire tomber l'adversaire
     */
    public float getOpponentFloodedFallChance() {
        return opponentFloodedFallChance;
    }
}