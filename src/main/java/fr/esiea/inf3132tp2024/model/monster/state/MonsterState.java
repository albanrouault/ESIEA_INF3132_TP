package fr.esiea.inf3132tp2024.model.monster.state;

public abstract class MonsterState {
    private int turnsLeft;

    protected MonsterState(int turnsLeft) {
        this.turnsLeft = turnsLeft;
    }

    /**
     * Get the number of turns left for the state
     *
     * @return the number of turns left
     */
    public int getTurnsLeft() {
        return turnsLeft;
    }

    /**
     * Decrement the number of turns left for the state
     */
    public void decrementTurnsLeft() {
        turnsLeft--;
    }
}
