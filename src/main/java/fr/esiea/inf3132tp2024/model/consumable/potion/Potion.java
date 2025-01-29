package fr.esiea.inf3132tp2024.model.consumable.potion;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;

public abstract class Potion extends Consumable {
    /**
     * Constructeur
     *
     * @param name        Nom de la potion
     * @param description Description de la potion
     */
    protected Potion(String name, String description) {
        super(name, description);
    }
}
