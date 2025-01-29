package fr.esiea.inf3132tp2024.model.monster;

public class MonsterDeadException extends Exception {
    private final Monster monster;

    public MonsterDeadException(Monster monster, String message) {
        super(message);

        this.monster = monster;
    }

    public Monster getMonster() {
        return monster;
    }
}
