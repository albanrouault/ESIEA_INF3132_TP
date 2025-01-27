package fr.esiea.inf3132tp2024.model.object.potion;

import fr.esiea.inf3132tp2024.model.object.Object;

public abstract class Potion extends Object {
    public Potion(String name) {
        super(name);
    }

    @Override
    abstract public void use();
}
