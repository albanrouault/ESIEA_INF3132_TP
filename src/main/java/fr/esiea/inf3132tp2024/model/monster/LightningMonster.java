package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

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
     * @param specialAttack
     * @param attacks
     */
    public LightningMonster(String name, int health, int attack, int speed, int defense, float paralyzeChance, Attack specialAttack, Attack[] attacks) throws MonsterTooManyAttacks {
        super(name, health, attack, speed, defense, specialAttack, attacks);

        this.paralyzeChance = paralyzeChance;
    }

    /**
     * Récupérer la chance de paralyser l'adversaire
     */
    public float getParalyzeChance() {
        return paralyzeChance;
    }
}
