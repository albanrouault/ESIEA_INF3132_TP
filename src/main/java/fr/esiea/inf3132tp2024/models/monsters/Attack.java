package fr.esiea.inf3132tp2024.models.monsters;

public class Attack {
    private String name;
    private int damage;
    private int accuracy;

    public Attack(String name, int damage, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAccuracy() {
        return accuracy;
    }
} 