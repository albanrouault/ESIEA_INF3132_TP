package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.entity.Entity;

/**
 * This class represents a monster in the game.
 */
public abstract class Monster {
    private String name;
    private int health;
    private int defense;
    private int speed;
    private Attack[] attacks = new Attack[4];

    /***
     * Constructor of the Monster class
     * @param name
     * @param health
     * @param defense
     * @param speed
     * @param attacks
     */
    public Monster(String name, int health, int defense, int speed, Attack[] attacks) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.attacks = attacks;
    }

    /**
     * Getter for the name of the monster
     *
     * @return the name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the health of the monster
     *
     * @return the health of the monster
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter for the defense of the monster
     *
     * @return the defense of the monster
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Getter for the speed of the monster
     *
     * @return the speed of the monster
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Getter for the attacks of the monster
     *
     * @return the attacks of the monster
     */
    public Attack[] getAttacks() {
        return attacks;
    }
}
