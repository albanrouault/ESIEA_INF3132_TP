package fr.esiea.inf3132tp2024.model.attack.special.earth;

import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttack;

public class EarthSpecialAttack extends SpecialAttack {
    public EarthSpecialAttack() {
        super(Types.EARTH, "Drill baby drill", "Mode marteau-piqueur activé\nPermet de se cacher sous terre pendant un certain nombre de tours");
    }
}
