package fr.esiea.inf3132tp2024.model.consumable.medicine;

public class BurnHeal extends Medicine {
    /**
     * Constructeur du soin brûlure
     *
     * @param effectiveness L'efficacité du soin
     */
    public BurnHeal(int effectiveness) {
        super("Soin brûlure", "Guérit un monstre de son état de brûlure", effectiveness);
    }
}