package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.capacity.SpecialCapacity;

public class LightningMonster extends Monster {
    private final float paralyzeChance;

    /***
     * Constructeur d'un monstre de type Foudre
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param paralyzeChance
     * @param specialCapacity
     * @param attacks
     */
    public LightningMonster(String name, int health, int attack, int speed, int defense, float paralyzeChance, SpecialCapacity specialCapacity, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, specialCapacity, attacks);

        this.paralyzeChance = paralyzeChance;
    }

    /**
     * Récupérer la chance de paralyser l'adversaire
     */
    public float getParalyzeChance() {
        return paralyzeChance;
    }
}
