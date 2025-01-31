package fr.esiea.inf3132tp2024.model.attack.special.fire;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public class FireSpecialAttack extends SpecialAttack {
    public FireSpecialAttack() {
        super(Types.FIRE, "Boule de feu", "Une boule de feu s'abat sur l'ennemi\nPeut brûler l'ennemi pendant un certain nombre de tours");
    }
}
