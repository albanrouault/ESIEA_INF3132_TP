package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.play.item.consumable.ConsumableItemMenu;

import java.util.LinkedList;
import java.util.List;

public class UseItemButton extends TButton {
    private final EscapeMenu escapeMenu;
    private final Player player;

    public UseItemButton(EscapeMenu escapeMenu, Player player) {
        super("Utiliser\n" + player.getItem().getName());

        this.escapeMenu = escapeMenu;
        this.player = player;
    }

    @Override
    public void execute() {
        if (player.getItem() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);
            Console.getInstance().show(new ConsumableItemMenu(consumable, entities));
            escapeMenu.stopLoopingMode();
        }
    }
}
