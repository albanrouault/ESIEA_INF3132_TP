package fr.esiea.inf3132tp2024.models.attack;

public class Attack {
    private String name;
    private int damage;
    private int accuracy;
    private AttackType attackType;

    public Attack(String name, int damage, int accuracy) {
        this.name = name;
        this.damage = damage;
        this.accuracy = accuracy;
        this.attackType = AttackType.PHYSICAL;
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