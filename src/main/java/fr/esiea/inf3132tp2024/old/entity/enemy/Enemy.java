package fr.esiea.inf3132tp2024.old.entity.enemy;

import fr.esiea.inf3132tp2024.old.entity.Entity;

/**
 * Classe d'un ennemi
 */
public abstract class Enemy extends Entity {
    /**
     * Constructeur
     *
     * @param name     Le nom
     * @param health   La santé
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public Enemy(String name, int health, int strength, int accuracy, int speed) {
        super(name, health, strength, accuracy, speed);
    }

    /**
     * Constructeur
     *
     * @param name Le nom de l'ennemi
     */
    public Enemy(String name) {
        super(name);
    }
}
