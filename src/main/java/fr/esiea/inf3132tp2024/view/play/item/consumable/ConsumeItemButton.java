package fr.esiea.inf3132tp2024.view.play.item.consumable;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ConsumeItemButton extends TButton {
    private final ConsumableItemMenu consumableItemMenu;
    private final Item item;
    private final Entity entity;

    public ConsumeItemButton(ConsumableItemMenu consumableItemMenu, Item item, Entity entity) {
        super(entity.getName() + ((entity == App.getInstance().getCurrentGame().getPlayer()) ? " (Vous)" : ""));

        this.consumableItemMenu = consumableItemMenu;
        this.item = item;
        this.entity = entity;
    }

    @Override
    public void execute() {
        ((Consumable) item).consume(entity);
        consumableItemMenu.stopLoopingMode();
        App.getInstance().getCurrentGame().getPlayer().setItem(null);
    }
}
