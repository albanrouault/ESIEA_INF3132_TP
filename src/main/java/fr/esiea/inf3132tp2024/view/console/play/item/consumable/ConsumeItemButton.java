package fr.esiea.inf3132tp2024.view.console.play.item.consumable;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

public class ConsumeItemButton extends TButton {
    private final App app;
    private final ConsumableItemMenu consumableItemMenu;
    private final Item item;
    private final Entity entity;

    public ConsumeItemButton(App app, ConsumableItemMenu consumableItemMenu, Item item, Entity entity) {
        super(app, entity.getName() + ((entity == app.getCurrentGame().getPlayer()) ? " (Vous)" : ""));

        this.app = app;
        this.consumableItemMenu = consumableItemMenu;
        this.item = item;
        this.entity = entity;
    }

    @Override
    public void execute() {
        ((Consumable) item).consume(entity);
        consumableItemMenu.stopLoopingMode();
        app.getCurrentGame().getPlayer().setItem(null);
    }
}
