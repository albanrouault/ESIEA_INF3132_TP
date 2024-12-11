package fr.esiea.inf3132tp2024.models.monsters.Types;

public enum MonsterTypeEnum {
    FIRE ("Fire"),
    WATER ("Water"),
    EARTH ("Earth"),
    ELECTRIC ("Electric"),
    NORMAL ("Normal"),
    INSECT ("Insect"),
    PLANT ("Plant");

    private String name;

    MonsterTypeEnum(String name) {
        this.name = name;
    }
}
