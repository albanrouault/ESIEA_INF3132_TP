package fr.esiea.inf3132tp2024.models.monsters.types;

/**
 * Cette classe représente le type de monstre Eau.
 */
public class WaterMonsterType extends MonsterType {

    /**
     * Constructeur de la classe WaterMonsterType
     */
    public WaterMonsterType() {
        super(MonsterTypeEnum.WATER);
    }

    /**
     * Implémentation de l'effet du type Eau sur le monstre
     */
    @Override
    public void effect() {
        // Logique spécifique à l'effet Eau
        System.out.println("Effet Eau appliqué au terrain.");
    }
} 