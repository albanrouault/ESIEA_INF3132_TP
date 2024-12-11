package fr.esiea.inf3132tp2024.models.object.potion;

public class StrengthPotion extends Potion {
    public StrengthPotion(String name) {
        super(name);
    }

    @Override
    public void use() {
        System.out.println("Potion utilisée.");
    }
}
