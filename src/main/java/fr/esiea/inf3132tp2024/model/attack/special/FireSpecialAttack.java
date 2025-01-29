package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;

public class FireSpecialAttack extends SpecialAttack {
    public FireSpecialAttack() {
        super(Types.FIRE, "Boule de feu", "Une boule de feu s'abat sur l'ennemi\nPeut brûler l'ennemi pendant un certain nombre de tours");
    }
}
