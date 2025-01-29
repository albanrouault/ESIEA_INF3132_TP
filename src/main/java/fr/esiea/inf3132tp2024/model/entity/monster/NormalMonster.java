package fr.esiea.inf3132tp2024.model.entity.monster;

public abstract class NormalMonster extends Monster {
    public NormalMonster() {
    }

    @Override
    public void effect() {
        System.out.println("Régénération du monstre.");
    }
}
