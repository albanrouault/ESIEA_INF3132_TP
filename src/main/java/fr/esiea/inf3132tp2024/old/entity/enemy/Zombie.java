package fr.esiea.inf3132tp2024.old.entity.enemy;

import fr.esiea.inf3132tp2024.old.App;

import java.util.Random;

public class Zombie extends Enemy {
    private static final int MIN_HEALTH = 20;
    private static final int MAX_HEALTH = 40;
    private static final int MIN_STRENGTH = 5;
    private static final int MAX_STRENGTH = 11;
    private static final int MIN_ACCURACY = 8;
    private static final int MAX_ACCURACY = 12;
    private static final int MIN_SPEED = 5;
    private static final int MAX_SPEED = 10;

    /**
     * Constructeur du Zombie pour faire une entité avec des stats aléatoire.
     *
     * @param app    L'application
     * @param random Le random permettant de générer l'aléatoire
     */
    public Zombie(App app, Random random) {
        super(app, "Zombie",
                random.nextInt(MIN_HEALTH, MAX_HEALTH),
                random.nextInt(MIN_STRENGTH, MAX_STRENGTH),
                random.nextInt(MIN_ACCURACY, MAX_ACCURACY),
                random.nextInt(MIN_SPEED, MAX_SPEED));
    }

    /**
     * Constructeur du Zombie pour le générer de façon personnalisée
     *
     * @param app      L'application
     * @param name     Le nom
     * @param health   La vie
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public Zombie(App app, String name, int health, int strength, int accuracy, int speed) {
        super(app, name, health, strength, accuracy, speed);
    }
}
