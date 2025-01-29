package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;

public abstract class SpecialAttack extends Attack {
    private String description;

    protected SpecialAttack(Types type, String name, String description) {
        super(type, name);

        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
