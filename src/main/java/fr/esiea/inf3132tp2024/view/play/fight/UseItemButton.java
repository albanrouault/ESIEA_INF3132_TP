package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.consumable.ConsumableItemMenu;

public class UseItemButton extends TButton {
    private final Fight fight;
    private final Player player;
    private final Consumable consumable;
    private final Monster[] monsters;

    public UseItemButton(Fight fight, Player player, Consumable consumable, Monster[] monsters) {
        super("Utiliser\n" + consumable.getName());

        this.fight = fight;
        this.player = player;
        this.consumable = consumable;
        this.monsters = monsters;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new ConsumableItemMenu(player, consumable, monsters));
        fight.updateMenuButtons();
    }
}
