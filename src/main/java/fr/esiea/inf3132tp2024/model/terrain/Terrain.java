package fr.esiea.inf3132tp2024.model.terrain;

import fr.esiea.inf3132tp2024.model.terrain.effect.TerrainEffect;

public class Terrain {
    private TerrainEffect effect;

    /**
     * Vérifie si le terrain a un effet actif
     *
     * @return true si un effet est actif, false sinon
     */
    public boolean hasEffect() {
        return effect != null;
    }

    /**
     * Récupère l'effet actuel du terrain
     *
     * @return l'effet appliqué au terrain
     */
    public TerrainEffect getEffect() {
        return effect;
    }

    /**
     * Applique un effet au terrain
     *
     * @param effect L'effet à appliquer
     * @throws TerrainHasAlreadyAnEffect si un effet est déjà actif
     */
    public void setEffect(TerrainEffect effect) throws TerrainHasAlreadyAnEffect {
        if (effect != null && this.effect.getTurnsLeft() > 0) {
            throw new TerrainHasAlreadyAnEffect("Le terrain a déjà un effet actif");
        }
        this.effect = effect;
    }
}
