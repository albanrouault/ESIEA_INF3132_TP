package fr.esiea.inf3132tp2024.model.consumable.medicine.curedryfield;

import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.model.terrain.TerrainHasAlreadyAnEffect;
import fr.esiea.inf3132tp2024.model.terrain.effect.FloodTerrainEffect;

public class DryTerrainEffect implements ConsumableEffect {
    @Override
    public boolean apply(Terrain terrain, Monster monster) {
        if (terrain.getEffect() instanceof FloodTerrainEffect) {
            try {
                terrain.setEffect(null);
            } catch (TerrainHasAlreadyAnEffect e) {
                throw new RuntimeException(e);
            }
            return true;
        }
        return false;
    }
}
