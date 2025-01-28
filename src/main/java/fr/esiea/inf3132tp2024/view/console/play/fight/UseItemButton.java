package fr.esiea.inf3132tp2024.view.console.play.fight;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.play.item.consumable.ConsumableItemMenu;

import java.util.List;

public class UseItemButton extends TButton {
    private final Fight fight;
    private final Consumable item;
    private final List<Entity> entities;

    public UseItemButton(Fight fight, Consumable item, List<Entity> fightEntities) {
        super("Utiliser\n" + ((Item) item).getName());

        this.fight = fight;
        this.item = item;
        this.entities = fightEntities;
    }

    @Override
    public void execute() {
        Console.getInstance().show(new ConsumableItemMenu(item, entities));
        fight.updateMenuButtons();
    }
}
