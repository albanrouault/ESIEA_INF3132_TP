package fr.esiea.inf3132tp2024.model;

public enum Types {
    NORMAL("Normal"),
    EARTH("Terre"),
    ELECTRIC("Électrique"),
    WATER("Eau"),
    FIRE("Feu"),
    NATURE("Nature"),
    NATURE_PLANT(NATURE, "Plante"),
    NATURE_INSECT(NATURE, "Insecte"),
    ;

    static {
        // Terre
        EARTH.setStrongAgainst(ELECTRIC);
        EARTH.setWeakAgainst(NATURE);

        // Électrique
        ELECTRIC.setStrongAgainst(WATER);
        ELECTRIC.setWeakAgainst(EARTH);

        // Eau
        WATER.setStrongAgainst(FIRE);
        WATER.setWeakAgainst(ELECTRIC);

        // Feu
        FIRE.setStrongAgainst(NATURE);
        FIRE.setWeakAgainst(WATER);

        // Nature
        NATURE.setStrongAgainst(EARTH);
        NATURE.setWeakAgainst(FIRE);
    }

    private final Types parent;
    private final String name;
    private Types strongAgainst;
    private Types weakAgainst;

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

    public Types getMainType() {
        if (parent == null) {
            return this;
        }
        return parent.getMainType();
    }

    public String getName() {
        return name;
    }

    public Types getStrongAgainst() {
        if (strongAgainst == null) {
            return parent.getStrongAgainst();
        }
        return strongAgainst;
    }

    private void setStrongAgainst(Types strongAgainst) {
        this.strongAgainst = strongAgainst;
    }

    public Types getWeakAgainst() {
        if (weakAgainst == null) {
            return parent.getWeakAgainst();
        }
        return weakAgainst;
    }

    private void setWeakAgainst(Types weakAgainst) {
        this.weakAgainst = weakAgainst;
    }

    public boolean isStrongAgainst(Types type) {
        return type.getMainType() == getStrongAgainst().getMainType();
    }

    public boolean isWeakAgainst(Types type) {
        return type.getMainType() == getWeakAgainst().getMainType();
    }
}
