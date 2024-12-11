package fr.esiea.inf3132tp2024.models.object.potion;

import fr.esiea.inf3132tp2024.models.object.Object;

public abstract class Potion extends Object {
    public Potion(String name) {
        super(name);
    }

    @Override
    abstract public void use();
}
