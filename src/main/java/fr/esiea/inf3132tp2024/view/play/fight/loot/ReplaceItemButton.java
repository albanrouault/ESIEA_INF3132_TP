package fr.esiea.inf3132tp2024.view.play.fight.loot;

import fr.esiea.inf3132tp2024.model.entity.Entity;
import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.Item;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TComponent;

import java.util.LinkedList;
import java.util.List;

public class ReplaceItemButton extends TButton {
    private final LootMenu lootMenu;
    private final Player player;
    private final Entity enemy;

    public ReplaceItemButton(LootMenu lootMenu, Player player, Entity enemy) {
        super("Échanger les objets");

        this.lootMenu = lootMenu;
        this.player = player;
        this.enemy = enemy;
    }

    @Override
    public void execute() {
        Item playerItem = player.getConsumable();
        player.setConsumable(enemy.getItem());
        enemy.setItem(playerItem);

        // Si l'item du joueur est consommable
        if (player.hasItem() && player.getConsumable() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);

            // Si un bouton utiliser l'item est déjà présent, on le remplace par un nouveau bouton
            for (TComponent component : lootMenu.getButtons().getComponents()) {
                if (component instanceof UseItemButton useItemButton) {
                    UseItemButton newUseItemButton = new UseItemButton(lootMenu, consumable, entities);
                    lootMenu.getButtons().replace(useItemButton, newUseItemButton);
                    return;
                }
            }

            // Sinon, on ajoute un bouton utiliser l'item
            UseItemButton useItemButton = new UseItemButton(lootMenu, consumable, entities);
            lootMenu.getButtons().addAfter(this, useItemButton);

            // Sinon l'item du joueur n'est pas consommable, on supprime le bouton consommer l'item
        } else {
            for (TComponent component : lootMenu.getButtons().getComponents()) {
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
