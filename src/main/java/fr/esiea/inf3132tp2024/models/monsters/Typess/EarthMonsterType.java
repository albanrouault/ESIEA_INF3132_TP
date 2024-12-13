package fr.esiea.inf3132tp2024.models.monsters.types;

/**
 * Cette classe représente le type de monstre Terre.
 */
public class EarthMonsterType extends MonsterType {

    /**
     * Constructeur de la classe EarthMonsterType
     */
    public EarthMonsterType() {
        super(MonsterTypeEnum.EARTH);
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