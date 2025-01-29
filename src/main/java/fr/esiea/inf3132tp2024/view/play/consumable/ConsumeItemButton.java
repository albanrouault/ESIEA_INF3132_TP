package fr.esiea.inf3132tp2024.view.play.consumable;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ConsumeItemButton extends TButton {
    private final ConsumableItemMenu consumableItemMenu;
    private final Player player;
    private final Consumable consumable;
    private final Monster monster;

    public ConsumeItemButton(ConsumableItemMenu consumableItemMenu, Player player, Consumable consumable, Monster monster) {
        super(monster.getName());

        this.consumableItemMenu = consumableItemMenu;
        this.player = player;
        this.consumable = consumable;
        this.monster = monster;
    }

    @Override
    public void execute() {
        consumable.consume(monster);
        consumableItemMenu.stopLoopingMode();
    }
}
