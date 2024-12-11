package fr.esiea.inf3132tp2024.models.monsters.Types;

/**
 * This class represents the type of a monster.
 */
public abstract class MonsterType {
    private MonsterTypeEnum name;

    /**
     * Constructor of the MonsterType class
     * @param name
     */
    public MonsterType(MonsterTypeEnum name) {
        this.name = name;
    }

    /**
     * Getter for the name of the monster type
     * @return the name of the monster type
     */
    public MonsterTypeEnum getName() {
        return name;
    }

    /**
     * This method represents the effect of the monster type on the monster
     * @param monster
     */
    abstract public void effect();
}

