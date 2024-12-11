package fr.esiea.inf3132tp2024.models.monsters.types;

/**
 * Cette classe représente le type de monstre Feu.
 */
public class FireMonsterType extends MonsterType {

    /**
     * Constructeur de la classe FireMonsterType
     */
    public FireMonsterType() {
        super(MonsterTypeEnum.FIRE);
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