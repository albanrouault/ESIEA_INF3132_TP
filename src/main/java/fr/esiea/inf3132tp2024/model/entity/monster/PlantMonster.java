package fr.esiea.inf3132tp2024.model.entity.monster;

public class PlantMonster extends Monster {
    public PlantMonster() {
    }

    @Override
    public void effect() {
        System.out.println("Effet Plant appliqué au monstre.");
    }
}
