package fr.esiea.inf3132tp2024.item.consumable;

import fr.esiea.inf3132tp2024.entity.Entity;

public interface Consumable {
    // Méthode permettant de faire consommer un objet.
    void consume(Entity entity);
}
