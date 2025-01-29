package fr.esiea.inf3132tp2024.model.entity.monster;

public class ElectricMonster extends Monster {

    public ElectricMonster() {
    }

    @Override
    public void effect() {
        System.out.println("Effet Electric appliqué au monstre.");
    }
}
