package fr.esiea.inf3132tp2024.model.attack.special.water;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public class WaterSpecialAttack extends SpecialAttack {
    public WaterSpecialAttack() {
        super(Types.WATER, "Hydrocanon", "Un puissant jet d'eau s'abat sur le terrain\nPeut faire glisser l'ennemi durant son attaque pendant un certain nombre de tours");
    }
}
