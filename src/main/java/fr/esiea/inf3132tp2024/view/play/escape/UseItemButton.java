package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.model.entity.Entity;
import fr.esiea.inf3132tp2024.model.entity.Player;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.item.consumable.ConsumableItemMenu;

import java.util.LinkedList;
import java.util.List;

public class UseItemButton extends TButton {
    private final EscapeMenu escapeMenu;
    private final Player player;

    public UseItemButton(EscapeMenu escapeMenu, Player player) {
        super("Utiliser\n" + player.getConsumable().getName());

        this.escapeMenu = escapeMenu;
        this.player = player;
    }

    @Override
    public void execute() {
        if (player.getConsumable() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);
            Terminal.getInstance().show(new ConsumableItemMenu(consumable, entities));
            escapeMenu.stopLoopingMode();
        }
    }
}
