package fr.esiea.inf3132tp2024.view.console.play.fight.loot;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

import java.util.LinkedList;
import java.util.List;

public class TakeItemButton extends TButton {
    private final Player player;
    private final Entity enemy;
    private final LootMenu lootMenu;

    public TakeItemButton(Player player, Entity enemy, LootMenu lootMenu) {
        super("Prendre l'objet");

        this.player = player;
        this.enemy = enemy;
        this.lootMenu = lootMenu;
    }

    @Override
    public void execute() {
        player.setItem(enemy.getItem());
        enemy.setItem(null);
        if (player.hasItem() && player.getItem() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);
            UseItemButton useItemButton = new UseItemButton(lootMenu, consumable, entities);
            useItemButton.setSelected(true);
            lootMenu.getButtons().replace(this, useItemButton);
        } else {
            lootMenu.getButtons().remove(this);
            lootMenu.getLeaveButton().setSelected(true);
        }
    }

    public Entity getEnemy() {
        return enemy;
    }
}
