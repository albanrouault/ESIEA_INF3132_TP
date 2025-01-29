package fr.esiea.inf3132tp2024.model;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.monster.Monster;

/**
 * Classe d'un joueur
 */
public class Player {
    private final String name;
    // 3 monstres max
    private final Monster[] monsters;
    // 5 objets max
    private final Consumable[] consumable;

    /**
     * Constructeur
     *
     * @param name Le nom de l'entité
     */
    public Player(String name, Monster[] monsters, Consumable[] consumable) {
        this.name = name;

        // 3 monstres max
        if (monsters.length > 3) {
            throw new IllegalArgumentException("Un joueur ne peut pas avoir plus de 3 monstres");
        }
        this.monsters = monsters;

        // 5 objets max
        if (consumable.length > 5) {
            throw new IllegalArgumentException("Un joueur ne peut pas avoir plus de 5 objets");
        }
        this.consumable = consumable;
    }

    /**
     * Méthode permettant de récupérer le nom de l'entité
     *
     * @return le nom de l'entité
     */
    public String getName() {
        return name;
    }

    /**
     * Méthode permettant de récupérer les monstres du joueur
     *
     * @return les monstres du joueur
     */
    public Monster[] getMonsters() {
        // Return copy of the array to avoid modification
        return monsters.clone();
    }

    /**
     * Méthode permettant de récupérer les objets du joueur
     *
     * @return les objets du joueur
     */
    public Consumable[] getConsumable() {
        // Return copy of the array to avoid modification
        return consumable.clone();
    }

    /**
     * Méthode permettant de savoir si le joueur à perdu
     *
     * @return true si le joueur à perdu, false sinon
     */
    public boolean hasLost() {
        for (Monster monster : monsters) {
            if (monster.isAlive()) {
                return false;
            }
        }
        return true;
    }
}
