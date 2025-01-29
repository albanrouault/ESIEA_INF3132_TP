package fr.esiea.inf3132tp2024.model.consumable;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public abstract class Consumable {
    private String name;
    private String description;
    private boolean isConsumed = false;

    /**
     * Constructeur
     *
     * @param name        Nom de l'objet
     * @param description Description de l'objet
     */
    protected Consumable(String name, String description) {
        this.name = name;
        this.description = description;
    }

    /**
     * Getter permettant de récupérer le nom de l'objet.
     *
     * @return Le nom de l'objet (String)
     */
    public String getName() {
        return name;
    }

    /**
     * Setter permettant de définir le nom de l'objet.
     *
     * @param name Nom de l'objet à attribuer (String)
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter permettant de récupérer la description de l'objet.
     *
     * @return La description de l'objet (String)
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter permettant de définir la description de l'objet.
     *
     * @param description La description de l'objet à attribuer (String)
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Méthode permettant de savoir si l'objet a été consommé.
     *
     * @return true si l'objet a été consommé, false sinon
     */
    public boolean isConsumed() {
        return isConsumed;
    }

    /**
     * Méthode permettant de consommer l'objet.
     */
    protected void setConsumed() {
        isConsumed = true;
    }

    /**
     * Méthode abstraite permettant de consommer l'objet.
     *
     * @param terrain Terrain sur lequel se trouve le monstre
     * @param monster Monstre qui consomme l'objet
     * @return true si l'objet a été consommé, false sinon
     */
    public abstract boolean consume(Terrain terrain, Monster monster);
}
