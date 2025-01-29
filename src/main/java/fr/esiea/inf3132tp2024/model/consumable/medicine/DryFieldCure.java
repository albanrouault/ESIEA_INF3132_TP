package fr.esiea.inf3132tp2024.model.consumable.medicine;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.model.terrain.TerrainHasAlreadyAnEffect;
import fr.esiea.inf3132tp2024.model.terrain.effect.FloodTerrainEffect;

public class DryFieldCure extends Medicine {
    /**
     * Constructeur du remède contre l'assèchement
     *
     * @param effectiveness L'efficacité du remède
     */
    public DryFieldCure(int effectiveness) {
        super("Cure Assèchement", "Restaure l'humidité du terrain", effectiveness);
    }

    @Override
    public boolean consume(Terrain terrain, Monster monster) {
        // Si le terrain est asséché
        if (!super.isConsumed() && terrain.getEffect() instanceof FloodTerrainEffect) {
            try {
                terrain.setEffect(null);
                super.setConsumed();
                return true;
            } catch (TerrainHasAlreadyAnEffect ignored) {
            }
        }
        return false;
    }
}
