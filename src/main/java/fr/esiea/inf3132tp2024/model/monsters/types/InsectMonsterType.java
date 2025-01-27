package fr.esiea.inf3132tp2024.model.monsters.types;

public class InsectMonsterType extends NormalMonsterType {
    
    public InsectMonsterType() {
        super(MonsterTypeEnum.INSECT);
    }

    @Override
    public void effect() {
        System.out.println("Effet Insect appliqué au monstre.");
    }
}


