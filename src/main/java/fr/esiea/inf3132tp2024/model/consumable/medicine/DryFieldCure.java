package fr.esiea.inf3132tp2024.model.consumable.medicine;

public class DryFieldCure extends Medicine {
    /**
     * Constructeur du remède contre l'assèchement
     *
     * @param effectiveness L'efficacité du remède
     */
    public DryFieldCure(int effectiveness) {
        super("Cure Assèchement", "Restaure l'humidité du terrain", effectiveness);
    }
}
