package fr.esiea.inf3132tp2024.model.consumable.medicine.healburn;

import fr.esiea.inf3132tp2024.model.consumable.medicine.Medicine;

public class HealBurn extends Medicine {
    /**
     * Constructeur du soin brûlure
     *
     * @param effectiveness L'efficacité du soin
     */
    public HealBurn(int effectiveness) {
        super("Soin brûlure", "Guérit un monstre de son état de brûlure", effectiveness);
    }
}