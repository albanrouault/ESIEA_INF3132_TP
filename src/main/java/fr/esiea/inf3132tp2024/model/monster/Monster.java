package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.state.MonsterState;

/**
 * This class represents a monster in the game.
 */
public abstract class Monster {
    private final String name;
    private final int health;
    private final int attack;
    private final int speed;
    private final int defense;
    private final Attack[] attacks;

    private MonsterState state;

    /***
     * Constructor of the Monster class
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    protected Monster(String name, int health, int attack, int speed, int defense, Attack... attacks) throws MonsterTooManyAttacks {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        this.defense = defense;
        this.attacks = attacks;
        // Limit the number of attacks to 4
        if (attacks.length > 4) {
            throw new MonsterTooManyAttacks("Un monstre ne peut pas avoir plus de 4 attaques");
        }
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
        // Return a copy of the array to prevent modification
        return attacks.clone();
    }

    /**
     * Check if the monster has a state
     *
     * @return true if the monster has a state, false otherwise
     */
    public boolean hasState() {
        return state != null;
    }

    /**
     * Getter for the state of the monster
     *
     * @return the state of the monster
     */
    public MonsterState getState() {
        return state;
    }

    /**
     * Setter for the state of the monster
     *
     * @param state the state of the monster
     */
    public void setState(MonsterState state) {
        this.state = state;
    }
}
