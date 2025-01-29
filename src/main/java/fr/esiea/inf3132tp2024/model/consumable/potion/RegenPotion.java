package fr.esiea.inf3132tp2024.model.consumable.potion;

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
}