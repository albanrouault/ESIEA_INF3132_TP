package fr.esiea.inf3132tp2024.model.attack.special.nature.insect;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public class NatureInsectSpecialAttack extends SpecialAttack {
    public NatureInsectSpecialAttack() {
        super(Types.NATURE_INSECT, "Pollen", "L'ennemi est empoisonné\nPeut empoisonner l'ennemi pendant un certain nombre de tours");
    }
}
