package fr.esiea.inf3132tp2024.game;

import fr.esiea.inf3132tp2024.entity.Entity;

public class EntityDeadException extends Exception {
    private final Entity entity;

    public EntityDeadException(Entity entity, String message) {
        super(message);

        this.entity = entity;
    }

    public Entity getEntity() {
        return entity;
    }
}
