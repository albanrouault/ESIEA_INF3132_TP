package fr.esiea.inf3132tp2024.model.object.medicine;

public class BurnHeal extends Medecine {
    public BurnHeal(String name) {
        super(name);
    }

    @Override
    public void use() {
        System.out.println("Anti-brulure utilisé.");
    }    
}
