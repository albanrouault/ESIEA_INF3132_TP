package fr.esiea.inf3132tp2024.model.consumable.medicine;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.monster.MonsterHasAlreadyAState;
import fr.esiea.inf3132tp2024.model.monster.state.BurntState;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;

public class BurnHeal extends Medicine {
    /**
     * Constructeur du soin brûlure
     *
     * @param effectiveness L'efficacité du soin
     */
    public BurnHeal(int effectiveness) {
        super("Soin brûlure", "Guérit un monstre de son état de brûlure", effectiveness);
    }

    @Override
    public boolean consume(Terrain terrain, Monster monster) {
        // Si le monstre est brûlé
        if (!super.isConsumed() && monster.getState() instanceof BurntState) {
            try {
                monster.setState(null);
                super.setConsumed();
                return true;
            } catch (MonsterHasAlreadyAState ignored) {
            }
        }
        return false;
    }
}