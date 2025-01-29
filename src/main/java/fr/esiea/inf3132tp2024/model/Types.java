package fr.esiea.inf3132tp2024.model;

public enum Types {
    EARTH("Terre"),
    LIGHTNING("Foudre"),
    WATER("Eau"),
    FIRE("Feu"),
    NATURE("Nature"),
    NATURE_PLANT(NATURE, "Plante"),
    NATURE_INSECT(NATURE, "Insecte"),
    ;

    private Types parent;
    private String name;

    Types(String name) {
        this(null, name);
    }

    Types(Types parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public Types getParent() {
        return parent;
    }

    public String getName() {
        return name;
    }


}
