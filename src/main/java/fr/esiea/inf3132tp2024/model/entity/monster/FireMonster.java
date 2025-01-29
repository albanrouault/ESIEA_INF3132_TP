package fr.esiea.inf3132tp2024.model.entity.monster;

/**
 * Cette classe représente le type de monstre Feu.
 */
public class FireMonster extends Monster {

    /**
     * Constructeur de la classe FireMonsterType
     */
    public FireMonster() {
    }

    /**
     * Implémentation de l'effet du type Feu sur le monstre
     */
    @Override
    public void effect() {
        // Logique spécifique à l'effet Feu
        System.out.println("Effet Feu appliqué au monstre.");
    }
} 