package fr.esiea.inf3132tp2024.utils.array;

/**
 * Exception levée lorsqu'un tableau est trop petit.
 */
public class ArrayTooSmallException extends Exception {
    /**
     * Constructeur
     *
     * @param message Message d'erreur
     */
    public ArrayTooSmallException(String message) {
        super(message);
    }
}
