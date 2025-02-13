package fr.esiea.inf3132tp2024.model.attack;

import fr.esiea.inf3132tp2024.model.Types;

public class Attack {
    private final Types type;
    private final String name;
    private final int damage;
    private final float chanceOfSuccess;

    private int nbUses;

    /***
     * Constructeur d'une attaque
     *
     * @param type
     * @param name
     * @param damage
     * @param chanceOfSuccess
     * @param nbUses
     */
    public Attack(Types type, String name, int damage, float chanceOfSuccess, int nbUses) {
        this.type = type;
        this.name = name;
        this.damage = damage;
        this.chanceOfSuccess = chanceOfSuccess;
        this.nbUses = nbUses;
    }

    /**
     * Récupérer le type de l'attaque
     */
    public Types getType() {
        return type;
    }

    /**
     * Récupérer le nom de l'attaque
     */
    public String getName() {
        return name;
    }

    /**
     * Récupérer les dégâts de l'attaque
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Récupérer la chance de succès de l'attaque
     */
    public float getChanceOfSuccess() {
        return chanceOfSuccess;
    }

    /**
     * Savoir si l'attaque est utilisable
     *
     * @return true si l'attaque est utilisable, false sinon
     */
    public boolean isUsable() {
        return nbUses > 0;
    }

    /**
     * Récupérer le nombre d'utilisations restantes de l'attaque
     */
    public int getNbUses() {
        return nbUses;
    }

    /**
     * Utiliser l'attaque
     */
    public void use() {
        nbUses--;
    }
} 