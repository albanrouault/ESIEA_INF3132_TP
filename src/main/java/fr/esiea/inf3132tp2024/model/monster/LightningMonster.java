package fr.esiea.inf3132tp2024.model.monster;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public class LightningMonster extends Monster {
    private final float paralyzeChance;

    /***
     * Constructeur d'un monstre de type Foudre
     *
     * @param name
     * @param health
     * @param attack
     * @param speed
     * @param defense
     * @param paralyzeChance
     * @param specialAttack
     * @param specialCapacityChance
     * @param attacks
     */
    public LightningMonster(String name, int health, int attack, int speed, int defense, float paralyzeChance, SpecialAttack specialAttack, float specialCapacityChance, Attack[] attacks) throws MonsterTooManyAttacks {
        super(Types.LIGHTNING, name, health, attack, speed, defense, specialAttack, specialCapacityChance, attacks);

        this.paralyzeChance = paralyzeChance;
    }

    /**
     * Récupérer la chance de paralyser l'adversaire
     */
    public float getParalyzeChance() {
        return paralyzeChance;
    }
}
