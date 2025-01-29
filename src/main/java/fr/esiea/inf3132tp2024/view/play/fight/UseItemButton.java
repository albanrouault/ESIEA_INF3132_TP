package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.entity.Entity;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.Item;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.item.consumable.ConsumableItemMenu;

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
        Terminal.getInstance().show(new ConsumableItemMenu(item, entities));
        fight.updateMenuButtons();
    }
}
