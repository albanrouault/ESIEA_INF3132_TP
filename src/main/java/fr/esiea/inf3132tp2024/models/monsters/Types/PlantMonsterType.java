package fr.esiea.inf3132tp2024.models.monsters.types;

public class PlantMonsterType extends NormalMonsterType {
    
    public PlantMonsterType() {
        super(MonsterTypeEnum.PLANT);
    }

    @Override
    public void effect() {
        System.out.println("Effet Plant appliqué au monstre.");
    }
}
