package fr.esiea.inf3132tp2024.entity;

import fr.esiea.inf3132tp2024.App;

/**
 * Classe d'un joueur
 */
public class Player extends Entity {
    /**
     * Constructeur
     *
     * @param app  L'application
     * @param name Le nom de l'entité
     */
    public Player(App app, String name) {
        super(app, name, 150, 20, 15, 15);
    }
}
