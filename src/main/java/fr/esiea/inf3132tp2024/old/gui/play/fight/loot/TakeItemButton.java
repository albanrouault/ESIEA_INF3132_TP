package fr.esiea.inf3132tp2024.old.gui.play.fight.loot;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

import java.util.LinkedList;
import java.util.List;

public class TakeItemButton extends CButton {
    private final App app;
    private final Player player;
    private final Entity enemy;
    private final LootMenu lootMenu;

    public TakeItemButton(App app, Player player, Entity enemy, LootMenu lootMenu) {
        super(app, "Prendre l'objet");

        this.app = app;
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
            UseItemButton useItemButton = new UseItemButton(app, lootMenu, consumable, entities);
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
