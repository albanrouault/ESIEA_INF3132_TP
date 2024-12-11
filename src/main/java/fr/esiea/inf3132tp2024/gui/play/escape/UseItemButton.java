package fr.esiea.inf3132tp2024.gui.play.escape;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.entity.Entity;
import fr.esiea.inf3132tp2024.entity.Player;
import fr.esiea.inf3132tp2024.gui.component.CButton;
import fr.esiea.inf3132tp2024.gui.play.item.consumable.ConsumableItemMenu;
import fr.esiea.inf3132tp2024.item.consumable.Consumable;

import java.util.LinkedList;
import java.util.List;

public class UseItemButton extends CButton {
    private final App app;
    private final EscapeMenu escapeMenu;
    private final Player player;

    public UseItemButton(App app, EscapeMenu escapeMenu, Player player) {
        super(app, "Utiliser\n" + player.getItem().getName());

        this.app = app;
        this.escapeMenu = escapeMenu;
        this.player = player;
    }

    @Override
    public void execute() {
        if (player.getItem() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);
            app.getConsole().show(new ConsumableItemMenu(app, consumable, entities));
            escapeMenu.stopLoopingMode();
        }
    }
}
