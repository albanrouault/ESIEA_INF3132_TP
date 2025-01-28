package fr.esiea.inf3132tp2024.view.play.fight.loot;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TComponent;
import fr.esiea.inf3132tp2024.view.play.item.consumable.ConsumableItemMenu;

import java.util.List;

public class UseItemButton extends TButton {
    private final LootMenu lootMenu;
    private final Consumable item;
    private final List<Entity> entities;

    public UseItemButton(LootMenu lootMenu, Consumable item, List<Entity> fightEntities) {
        super("Utiliser\n" + ((Item) item).getName());

        this.lootMenu = lootMenu;
        this.item = item;
        this.entities = fightEntities;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new ConsumableItemMenu(item, entities));
        Player player = lootMenu.getPlayer();
        // Si le joueur à consommé l'item
        if (!player.hasItem()) {
            Entity enemy = lootMenu.getEntity();
            // Si l'ennemi à encore un item, on remplace le bouton "échanger les items" par un bouton "prendre l'item"
            for (TComponent component : lootMenu.getButtons().getComponents()) {
                if (component instanceof ReplaceItemButton replaceItemButton) {
                    TakeItemButton takeItemButton = new TakeItemButton(player, enemy, lootMenu);
                    lootMenu.getButtons().replace(replaceItemButton, takeItemButton);
                    break;
                }
            }
            // Si l'ennemi à un item consommable
            if (enemy.hasItem() && enemy.getItem() instanceof Consumable consumable) {
                UseItemButton useItemButton = new UseItemButton(lootMenu, consumable, entities);
                useItemButton.setSelected(true);
                lootMenu.getButtons().replace(this, useItemButton);
            } else {
                lootMenu.getButtons().remove(this);
                lootMenu.getLeaveButton().setSelected(true);
            }
        }
    }
}
