package fr.esiea.inf3132tp2024.model.entity;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;

/**
 * Classe d'un joueur
 */
public class Player {
    private final String name;
    private Consumable consumable;

    /**
     * Constructeur
     *
     * @param name Le nom de l'entité
     */
    public Player(String name) {
        this.name = name;
    }

    public boolean hasItem() {
        return this.getConsumable() != null;
    }

    /**
     * Méthode permettant de récupérer l'item que possède l'entité.
     *
     * @return un Item
     */
    public Consumable getConsumable() {
        return consumable;
    }

    /**
     * Méthode qui permet de définir l'item porté par l'entité
     *
     * @param consumable un Item
     */
    public void setConsumable(Consumable consumable) {
        this.consumable = consumable;
    }
}
