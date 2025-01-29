package fr.esiea.inf3132tp2024.model.consumable.potion;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public class RegenPotion extends Potion {
    private final int regenAmount;

    /**
     * Constructeur de la potion de régénération
     *
     * @param regenAmount La quantité de points de vie régénérés par tour
     */
    public RegenPotion(int regenAmount) {
        super("Potion de régénération", "Régénère " + regenAmount + " points de vie");

        this.regenAmount = regenAmount;
    }

    /**
     * Récupère la quantité de points de vie régénérés par tour
     */
    public int getRegenAmount() {
        return regenAmount;
    }

    @Override
    public boolean consume(Terrain terrain, Monster monster) {
        if (!super.isConsumed()) {
            monster.heal(regenAmount);
            super.setConsumed();
            return true;
        }
        return false;
    }
}