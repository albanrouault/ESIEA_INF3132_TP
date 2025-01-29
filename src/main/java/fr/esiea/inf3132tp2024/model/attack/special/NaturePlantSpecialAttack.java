package fr.esiea.inf3132tp2024.model.attack.special;

import fr.esiea.inf3132tp2024.model.Types;

public class NaturePlantSpecialAttack extends SpecialAttack {
    public NaturePlantSpecialAttack() {
        super(Types.NATURE_PLANT, "Racine", "Une racine se prend en vous\nPeut soigner votre monstre et supprimer les effets négatifs");
    }
}
