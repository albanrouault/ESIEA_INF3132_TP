package fr.esiea.inf3132tp2024.models.monsters;

import fr.esiea.inf3132tp2024.models.monsters.Types.MonsterType;
/**
 * This class represents a monster in the game.
 */
public abstract class Monster {
    private String name;
    private int health;
    private int defense;
    private int speed;
    private Attack[] attacks = new Attack[4];
    private MonsterType type;

    /***
     * Constructor of the Monster class
     * @param name
     * @param health
     * @param defense
     * @param speed
     * @param attacks
     * @param type
     */
    public Monster(String name, int health, int defense, int speed, Attack[] attacks, MonsterType type) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.speed = speed;
        this.attacks = attacks;
        this.type = type;
    }

    /**
     * Getter for the name of the monster
     * @return the name of the monster
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for the health of the monster
     * @return the health of the monster
     */
    public int getHealth() {
        return health;
    }

    /**
     * Getter for the defense of the monster
     * @return the defense of the monster
     */
    public int getDefense() {
        return defense;
    }

    /**
     * Getter for the speed of the monster
     * @return the speed of the monster
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Getter for the attacks of the monster
     * @return the attacks of the monster
     */
    public Attack[] getAttacks() {
        return attacks;
    }

    /**
     * Getter for the type of the monster
     * @return the type of the monster
     */
    public MonsterType getType() {
        return type;
    }
}
