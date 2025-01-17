package fr.esiea.inf3132tp2024.old.gui.play.fight.loot;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.component.CComponent;
import fr.esiea.inf3132tp2024.old.gui.play.item.consumable.ConsumableItemMenu;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

import java.util.List;

public class UseItemButton extends CButton {
    private final App app;
    private final LootMenu lootMenu;
    private final Consumable item;
    private final List<Entity> entities;

    public UseItemButton(App app, LootMenu lootMenu, Consumable item, List<Entity> fightEntities) {
        super(app, "Utiliser\n" + ((Item) item).getName());

        this.app = app;
        this.lootMenu = lootMenu;
        this.item = item;
        this.entities = fightEntities;
    }

    @Override
    public void execute() {
        app.getConsole().show(new ConsumableItemMenu(app, item, entities));
        Player player = lootMenu.getPlayer();
        // Si le joueur à consommé l'item
        if (!player.hasItem()) {
            Entity enemy = lootMenu.getEntity();
            // Si l'ennemi à encore un item, on remplace le bouton "échanger les items" par un bouton "prendre l'item"
            for (CComponent component : lootMenu.getButtons().getComponents()) {
                if (component instanceof ReplaceItemButton replaceItemButton) {
                    TakeItemButton takeItemButton = new TakeItemButton(app, player, enemy, lootMenu);
                    lootMenu.getButtons().replace(replaceItemButton, takeItemButton);
                    break;
                }
            }
            // Si l'ennemi à un item consommable
            if (enemy.hasItem() && enemy.getItem() instanceof Consumable consumable) {
                UseItemButton useItemButton = new UseItemButton(app, lootMenu, consumable, entities);
                useItemButton.setSelected(true);
                lootMenu.getButtons().replace(this, useItemButton);
            } else {
                lootMenu.getButtons().remove(this);
                lootMenu.getLeaveButton().setSelected(true);
            }
        }
    }
}
