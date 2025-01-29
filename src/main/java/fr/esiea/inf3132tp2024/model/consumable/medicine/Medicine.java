package fr.esiea.inf3132tp2024.model.consumable.medicine;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;

public abstract class Medicine extends Consumable {
    private final int effectiveness;

    /**
     * Constructeur du médicament
     *
     * @param effectiveness L'efficacité du médicament
     */
    protected Medicine(String name, String description, int effectiveness) {
        super(name, description);

        this.effectiveness = effectiveness;
    }

    /**
     * Récupère l'efficacité du médicament
     */
    public int getEffectiveness() {
        return effectiveness;
    }
}
