package fr.esiea.inf3132tp2024.view.play.consumable;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class ConsumeItemButton extends TButton {
    private final ConsumableItemMenu consumableItemMenu;
    private final Consumable consumable;
    private final Terrain terrain;
    private final Monster monster;

    public ConsumeItemButton(ConsumableItemMenu consumableItemMenu, Consumable consumable, Terrain terrain, Monster monster) {
        super(monster.getName());

        this.consumableItemMenu = consumableItemMenu;
        this.consumable = consumable;
        this.terrain = terrain;
        this.monster = monster;
    }

    @Override
    public void execute() {
        consumable.consume(terrain, monster);
        consumableItemMenu.stopLoopingMode();
    }
}
