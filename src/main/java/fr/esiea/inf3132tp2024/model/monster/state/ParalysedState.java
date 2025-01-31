package fr.esiea.inf3132tp2024.model.monster.state;

public class ParalysedState extends MonsterState {
    /**
     * Constructor of the ParalysedState class
     *
     * @param turnsLeft the number of turns left for the state
     */
    public ParalysedState(int turnsLeft) {
        super("Paralysé", turnsLeft);
    }

    /**
     * Constructor of the ParalysedState class
     */
    public ParalysedState() {
        super("Paralysé");
    }
}
