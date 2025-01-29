package fr.esiea.inf3132tp2024.model.entity.monster;

/**
 * Cette classe représente le type de monstre Terre.
 */
public class EarthMonster extends Monster {

    /**
     * Constructeur de la classe EarthMonsterType
     */
    public EarthMonster() {
    }

    /**
     * Implémentation de l'effet du type Terre sur le monstre
     */
    @Override
    public void effect() {
        // Logique spécifique à l'effet Terre
        System.out.println("Effet Terre appliqué au monstre.");
    }
} 