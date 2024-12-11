package fr.esiea.inf3132tp2024.models.object.medicine;

import fr.esiea.inf3132tp2024.models.object.Object;

public abstract class Medecine extends Object {
    public Medecine(String name) {
        super(name);
    }

    @Override
    abstract public void use();
}
