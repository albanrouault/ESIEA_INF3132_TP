package fr.esiea.inf3132tp2024.model.object.potion;

public class LifePotion extends Potion {
    public LifePotion(String name) {
        super(name);
    }

    @Override
    public void use() {
        System.out.println("Potion utilisée.");
    }
}
