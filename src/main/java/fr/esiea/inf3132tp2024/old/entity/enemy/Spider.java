package fr.esiea.inf3132tp2024.old.entity.enemy;

import java.util.Random;

public class Spider extends Enemy {
    private static final int MIN_HEALTH = 20;
    private static final int MAX_HEALTH = 40;
    private static final int MIN_STRENGTH = 5;
    private static final int MAX_STRENGTH = 10;
    private static final int MIN_ACCURACY = 20;
    private static final int MAX_ACCURACY = 30;
    private static final int MIN_SPEED = 20;
    private static final int MAX_SPEED = 30;

    /**
     * Constructeur de l'araignée pour faire une entité avec des stats aléatoire.
     *
     * @param random Le random permettant de générer l'aléatoire
     */
    public Spider(Random random) {
        super("Araignée",
                random.nextInt(MIN_HEALTH, MAX_HEALTH),
                random.nextInt(MIN_STRENGTH, MAX_STRENGTH),
                random.nextInt(MIN_ACCURACY, MAX_ACCURACY),
                random.nextInt(MIN_SPEED, MAX_SPEED));
    }

    /**
     * Constructeur de l'araignée pour le générer de façon personnalisée
     *
     * @param name     Le nom
     * @param health   La vie
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public Spider(String name, int health, int strength, int accuracy, int speed) {
        super(name, health, strength, accuracy, speed);
    }
}
