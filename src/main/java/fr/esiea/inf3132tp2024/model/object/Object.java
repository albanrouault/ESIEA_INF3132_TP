package fr.esiea.inf3132tp2024.model.object;

public abstract class Object {
    private String name;;

    public Object(String name) {
        this.name = name;
    }

    abstract public void use();
}

