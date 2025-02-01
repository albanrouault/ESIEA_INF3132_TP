package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.state.MonsterState;

/**
 * This class represents a monster in the game.
 */
public abstract class Monster {
    private final Types type;
    private final String name;
    private final int maxHealth;
    private final Attack[] attacks;

    private MonsterState state;
    private Attack currentAttack;
    private int health;
    private int attack;
    private int speed;
    private int defense;

    /***
     * Constructor of the Monster class
     *
     * @param type
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param attacks
     */
    protected Monster(Types type, String name, int health, int attack, int speed, int defense, Attack... attacks) throws MonsterTooManyAttacks {
        this.type = type;
        this.name = name;
        this.health = health;
        this.maxHealth = health;
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
     * Getter for the type of the monster
     *
     * @return the type of the monster
     */
    public Types getType() {
        return type;
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
     * Getter for the max health of the monster
     *
     * @return the max health of the monster
     */
    public int getMaxHealth() {
        return maxHealth;
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
    public void setState(MonsterState state) throws MonsterHasAlreadyAState {
        if (state != null && this.state != null && this.state.getTurnsLeft() > 0) {
            throw new MonsterHasAlreadyAState("Le monstre a déjà un état");
        }
        this.state = state;
    }

    /**
     * Check if the monster is alive
     *
     * @return true if the monster is alive, false otherwise
     */
    public boolean isAlive() {
        return health > 0;
    }

    /**
     * Heal the monster
     *
     * @param health the amount of health to heal
     */
    public void heal(int health) {
        this.health = Math.min(this.health + health, maxHealth);
    }

    /**
     * Damage the monster
     *
     * @param damage the amount of damage to deal
     */
    public void damage(int damage) {
        health = Math.max(health - damage, 0);
    }

    /**
     * Strengthen the monster
     *
     * @param attack the amount of attack to strengthen
     */
    public void strengthen(int attack) {
        this.attack += attack;
    }

    public void setCurrentAttack(Attack attack) {
        this.currentAttack = attack;
    }

    public Attack getCurrentAttack() {
        return currentAttack;
    }


}
