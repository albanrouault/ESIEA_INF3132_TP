package fr.esiea.inf3132tp2024.model.entity.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;

/**
 * This class represents a monster in the game.
 */
public abstract class Monster {
    private String name;
    private int health;
    private int attack;
    private int speed;
    private int defense;
    private Attack[] attacks = new Attack[4];

    /***
     * Constructor of the Monster class
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    protected Monster(String name, int health, int attack, int speed, int defense, Attack[] attacks) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.defense = defense;
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
     * Getter for the attack of the monster
     *
     * @return the attack of the monster
     */
    public int getAttack() {
        return attack;
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
     * Getter for the defense of the monster
     *
     * @return the defense of the monster
     */
    public int getDefense() {
        return defense;
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
