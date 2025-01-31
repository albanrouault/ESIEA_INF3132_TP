package fr.esiea.inf3132tp2024.model.monster.state;

public class BurntState extends MonsterState {
    /**
     * Constructor of the BurntState class
     *
     * @param turnsLeft the number of turns left for the state
     */
    public BurntState(int turnsLeft) {
        super("Brûlé", turnsLeft);
    }

    /**
     * Constructor of the BurntState class
     */
    public BurntState() {
        super("Brûlé");
    }
}
