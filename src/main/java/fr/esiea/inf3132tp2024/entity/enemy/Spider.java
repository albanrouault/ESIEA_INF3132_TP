package fr.esiea.inf3132tp2024.entity.enemy;

import fr.esiea.inf3132tp2024.App;

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
     * @param app    L'application
     * @param random Le random permettant de générer l'aléatoire
     */
    public Spider(App app, Random random) {
        super(app, "Araignée",
                random.nextInt(MIN_HEALTH, MAX_HEALTH),
                random.nextInt(MIN_STRENGTH, MAX_STRENGTH),
                random.nextInt(MIN_ACCURACY, MAX_ACCURACY),
                random.nextInt(MIN_SPEED, MAX_SPEED));
    }

    /**
     * Constructeur de l'araignée pour le générer de façon personnalisée
     *
     * @param app      L'application
     * @param name     Le nom
     * @param health   La vie
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public Spider(App app, String name, int health, int strength, int accuracy, int speed) {
        super(app, name, health, strength, accuracy, speed);
    }
}
