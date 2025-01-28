package fr.esiea.inf3132tp2024.view.console.play.fight;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.play.item.consumable.ConsumableItemMenu;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

import java.util.List;

public class UseItemButton extends TButton {
    private final App app;
    private final Fight fight;
    private final Consumable item;
    private final List<Entity> entities;

    public UseItemButton(App app, Fight fight, Consumable item, List<Entity> fightEntities) {
        super(app, "Utiliser\n" + ((Item)item).getName());

        this.app = app;
        this.fight = fight;
        this.item = item;
        this.entities = fightEntities;
    }

    @Override
    public void execute() {
        app.getConsole().show(new ConsumableItemMenu(app, item, entities));
        fight.updateMenuButtons();
    }
}
