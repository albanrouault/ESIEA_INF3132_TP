package fr.esiea.inf3132tp2024.view.console.play.escape;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.view.console.api.component.CButton;
import fr.esiea.inf3132tp2024.view.console.play.item.consumable.ConsumableItemMenu;
import fr.esiea.inf3132tp2024.old.item.consumable.Consumable;

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
