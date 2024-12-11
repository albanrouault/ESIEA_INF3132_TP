package fr.esiea.inf3132tp2024.old.entity.enemy;

import fr.esiea.inf3132tp2024.old.App;

import java.util.Random;

public class HeadlessKnight extends Enemy {
    private static final int MIN_HEALTH = 20;
    private static final int MAX_HEALTH = 50;
    private static final int MIN_STRENGTH = 10;
    private static final int MAX_STRENGTH = 15;
    private static final int MIN_ACCURACY = 10;
    private static final int MAX_ACCURACY = 20;
    private static final int MIN_SPEED = 10;
    private static final int MAX_SPEED = 25;

    /**
     * Constructeur du Chevalier sans tête pour faire une entité avec des stats aléatoire.
     *
     * @param app    L'application
     * @param random Le random permettant de générer l'aléatoire
     */
    public HeadlessKnight(App app, Random random) {
        super(app, "Chevalier sans tête",
                random.nextInt(MIN_HEALTH, MAX_HEALTH),
                random.nextInt(MIN_STRENGTH, MAX_STRENGTH),
                random.nextInt(MIN_ACCURACY, MAX_ACCURACY),
                random.nextInt(MIN_SPEED, MAX_SPEED));
    }

    /**
     * Constructeur du Chevalier sans tête pour le générer de façon personnalisée
     *
     * @param app      L'application
     * @param name     Le nom
     * @param health   La vie
     * @param strength La force
     * @param accuracy La précision
     * @param speed    La rapidité
     */
    public HeadlessKnight(App app, String name, int health, int strength, int accuracy, int speed) {
        super(app, name, health, strength, accuracy, speed);
    }
}
