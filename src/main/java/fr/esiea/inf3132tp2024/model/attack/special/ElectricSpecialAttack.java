package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;

public class ElectricSpecialAttack extends SpecialAttack {
    public ElectricSpecialAttack() {
        super(Types.ELECTRIC, "Éclair", "Un éclair s'abat sur l'ennemi\nPeut paralyser l'ennemi pendant un certain nombre de tours");
    }
}
