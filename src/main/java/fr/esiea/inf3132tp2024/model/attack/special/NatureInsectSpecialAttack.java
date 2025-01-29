package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;

public class NatureInsectSpecialAttack extends SpecialAttack {
    public NatureInsectSpecialAttack() {
        super(Types.NATURE_INSECT, "Pollen", "L'ennemi est empoisonné\nPeut empoisonner l'ennemi pendant un certain nombre de tours");
    }
}
