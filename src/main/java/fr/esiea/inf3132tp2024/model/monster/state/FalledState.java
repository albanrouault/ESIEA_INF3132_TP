package fr.esiea.inf3132tp2024.model.monster.state;

public class FalledState extends MonsterState {
    /**
     * Constructor of the FalledState class
     *
     * @param turnsLeft the number of turns left for the state
     */
    public FalledState(int turnsLeft) {
        super("Par terre", turnsLeft);
    }

    /**
     * Constructor of the FalledState class
     */
    public FalledState() {
        super("Par terre");
    }
}
