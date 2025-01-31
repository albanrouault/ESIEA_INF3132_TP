package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;

public abstract class SpecialAttack {
    private final Types type;
    private final String name;
    private final String description;

    protected SpecialAttack(Types type, String name, String description) {
        this.type = type;
        this.name = name;
        this.description = description;
    }

    public Types getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
