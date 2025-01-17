package fr.esiea.inf3132tp2024.old.item.weapon;

import java.util.Random;

public class Massue extends Weapon {
    private static final int MIN_POWER = 5; // min inclus
    private static final int MAX_POWER = 16; // max exclus
    private static final int MIN_SPEED = 1; // min inclus
    private static final int MAX_SPEED = 11; // max exclus
    private static final int MIN_ACCURACY = 1; // min inclus
    private static final int MAX_ACCURACY = 11; // max exclus

    /**
     * Constructeur
     *
     * @param random objet Random permettant de gérer l'aléatoire de l'objet crée.
     */
    public Massue(Random random) {
        super("Massue", "", 0, 0, 0);

        this.setStrength(random.nextInt(MIN_POWER, MAX_POWER));
        this.setSpeed(random.nextInt(MIN_SPEED, MAX_SPEED));
        this.setAccuracy(random.nextInt(MIN_ACCURACY, MAX_ACCURACY));
        this.setDescription(generateDescription());
    }

    // Méthode permettant de gérer la description de l'arme en fonction de ses statistiques.
    private String generateDescription() {
        int total = super.getStrength() + super.getSpeed() + super.getAccuracy();
        int mediumWeapon = (MAX_POWER + MAX_SPEED + MAX_ACCURACY - 3) / 2;
        int greatWeapon = mediumWeapon + ((MAX_POWER + MAX_SPEED + MAX_ACCURACY - 3) / 4);
        if (total < mediumWeapon) {
            return "Massue de mauvaise qualité";
        } else if (total < greatWeapon) {
            return "Masse mediocre";
        } else {
            return "Superbe masse";
        }
    }
}
