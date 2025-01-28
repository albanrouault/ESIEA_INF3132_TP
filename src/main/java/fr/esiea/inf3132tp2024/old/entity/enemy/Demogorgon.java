package fr.esiea.inf3132tp2024.old.entity.enemy;

import java.util.Random;

public class Demogorgon extends Enemy {
    private static final int MIN_HEALTH = 30;
    private static final int MAX_HEALTH = 60;
    private static final int MIN_STRENGTH = 10;
    private static final int MAX_STRENGTH = 15;
    private static final int MIN_ACCURACY = 10;
    private static final int MAX_ACCURACY = 20;
    private static final int MIN_SPEED = 2;
    private static final int MAX_SPEED = 5;

    /**
     * Constructeur du Demogorgon pour faire une entité avec des stats aléatoire.
     *
     * @param random Le random permettant de générer l'aléatoire
     */
    public Demogorgon(Random random) {
        super("Demogorgon",
                random.nextInt(MIN_HEALTH, MAX_HEALTH),
                random.nextInt(MIN_STRENGTH, MAX_STRENGTH),
                random.nextInt(MIN_ACCURACY, MAX_ACCURACY),
                random.nextInt(MIN_SPEED, MAX_SPEED));
    }

    /**
     * Constructeur du Demogorgon pour le générer de façon personnalisée
     *
     * @param name     Le nom
     * @param health   La vie
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public Demogorgon(String name, int health, int strength, int accuracy, int speed) {
        super(name, health, strength, accuracy, speed);
    }
}
