package fr.esiea.inf3132tp2024.models.monsters.Types;

public class ElectricMonsterType extends MonsterType {

    public ElectricMonsterType() {
        super(MonsterTypeEnum.ELECTRIC);
    }

    @Override
    public void effect() {
        System.out.println("Effet Electric appliqué au monstre.");
    }
}
