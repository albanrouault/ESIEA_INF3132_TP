package fr.esiea.inf3132tp2024.old.utils;

/**
 * Classe utilitaire diverse et variée
 */
public class Utils {
    /**
     * Méthode permettant de générer un nombre aléatoirement entre min (inclus)
     * et max (inclus)
     *
     * @param min Nombre minimum
     * @param max Nombre maximum
     * @return Un nombre pseudo-aléatoire entre min (inclus) et max (inclus)
     * @author <a href="https://stackoverflow.com/a/363732">URL</a>
     */
    public static int generateRandomInt(int min, int max) {
        return min + (int) (Math.random() * (max - min + 1));
    }
}
