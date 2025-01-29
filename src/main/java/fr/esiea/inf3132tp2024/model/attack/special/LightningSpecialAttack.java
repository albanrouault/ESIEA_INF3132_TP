package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;

public class LightningSpecialAttack extends SpecialAttack {
    public LightningSpecialAttack() {
        super(Types.LIGHTNING, "Eclair", "Un éclair s'abat sur l'ennemi\nPeut paralyser l'ennemi pendant un certain nombre de tours");
    }
}
