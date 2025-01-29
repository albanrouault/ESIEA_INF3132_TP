package fr.esiea.inf3132tp2024.model.entity.monster;

public class InsectMonster extends NormalMonster {
    public InsectMonster() {
    }

    @Override
    public void effect() {
        System.out.println("Effet Insect appliqué au monstre.");
    }
}


