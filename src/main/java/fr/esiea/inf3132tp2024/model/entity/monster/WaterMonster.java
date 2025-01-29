package fr.esiea.inf3132tp2024.model.entity.monster;

/**
 * Cette classe représente le type de monstre Eau.
 */
public class WaterMonster extends Monster {
    /**
     * Constructeur de la classe WaterMonsterType
     */
    public WaterMonster() {
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