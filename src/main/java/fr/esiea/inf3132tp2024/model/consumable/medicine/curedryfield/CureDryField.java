package fr.esiea.inf3132tp2024.model.consumable.medicine.curedryfield;

import fr.esiea.inf3132tp2024.model.consumable.medicine.Medicine;

public class CureDryField extends Medicine {
    /**
     * Constructeur du remède contre l'assèchement
     *
     * @param effectiveness L'efficacité du remède
     */
    public CureDryField(int effectiveness) {
        super("Cure Assèchement", "Restaure l'humidité du terrain", effectiveness);
    }
}
