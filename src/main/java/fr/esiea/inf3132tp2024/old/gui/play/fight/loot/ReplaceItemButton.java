package fr.esiea.inf3132tp2024.old.gui.play.fight.loot;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.component.CComponent;
import fr.esiea.inf3132tp2024.old.item.Item;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

import java.util.LinkedList;
import java.util.List;

public class ReplaceItemButton extends CButton {
    private final App app;
    private final LootMenu lootMenu;
    private final Player player;
    private final Entity enemy;

    public ReplaceItemButton(App app, LootMenu lootMenu, Player player, Entity enemy) {
        super(app, "Échanger les objets");

        this.app = app;
        this.lootMenu = lootMenu;
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void execute() {
        Item playerItem = player.getItem();
        player.setItem(enemy.getItem());
        enemy.setItem(playerItem);

        // Si l'item du joueur est consommable
        if (player.hasItem() && player.getItem() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);

            // Si un bouton utiliser l'item est déjà présent, on le remplace par un nouveau bouton
            for (CComponent component : lootMenu.getButtons().getComponents()) {
                if (component instanceof UseItemButton useItemButton) {
                    UseItemButton newUseItemButton = new UseItemButton(app, lootMenu, consumable, entities);
                    lootMenu.getButtons().replace(useItemButton, newUseItemButton);
                    return;
                }
            }

            // Sinon, on ajoute un bouton utiliser l'item
            UseItemButton useItemButton = new UseItemButton(app, lootMenu, consumable, entities);
            lootMenu.getButtons().addAfter(this, useItemButton);

            // Sinon l'item du joueur n'est pas consommable, on supprime le bouton consommer l'item
        } else {
            for (CComponent component : lootMenu.getButtons().getComponents()) {
                if (component instanceof UseItemButton useItemButton) {
                    lootMenu.getButtons().remove(useItemButton);
                    break;
                }
            }
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getEnemy() {
        return enemy;
    }
}
