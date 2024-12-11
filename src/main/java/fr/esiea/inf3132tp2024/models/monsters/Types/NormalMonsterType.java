package fr.esiea.inf3132tp2024.models.monsters.types;

public abstract class NormalMonsterType extends MonsterType {

    public NormalMonsterType(MonsterTypeEnum type) {
        super(type);
    }

    public NormalMonsterType() {
        super(MonsterTypeEnum.NORMAL);
    }

    @Override
    public void effect() {
        System.out.println("Régénération du monstre.");
    }
}
