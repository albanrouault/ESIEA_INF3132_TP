package fr.esiea.inf3132tp2024.model.consumable.potion;

public class PowerPotion extends Potion {
    private final int attackBoost;

    /**
     * Constructeur de la potion de puissance
     *
     * @param attackBoost La quantité d'attaque augmentée par la potion
     */
    public PowerPotion(int attackBoost) {
        super("Potion de puissance", "Augmente l'attaque de " + attackBoost + " points");

        this.attackBoost = attackBoost;
    }

    /**
     * Récupère la quantité d'attaque augmentée par la potion
     */
    public int getAttackBoost() {
        return attackBoost;
    }
}