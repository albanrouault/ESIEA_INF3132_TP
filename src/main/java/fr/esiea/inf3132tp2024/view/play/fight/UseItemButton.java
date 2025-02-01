package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffectFactory;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class UseItemButton extends TButton {
    private final FightView fightView;
    private final Player player;
    private final Terrain terrain;
    private final Consumable consumable;
    private final Monster monster;

    public UseItemButton(FightView fightView, Fight fight, Player player, Consumable consumable, Monster monster) {
        super(player.getName() + " utilise\n" + consumable.getName());

        this.fightView = fightView;
        this.player = player;
        this.terrain = fight.getTerrain();
        this.consumable = consumable;
        this.monster = monster;
    }

    @Override
    public void execute() {
        if (!consumable.isConsumed()) {
            ConsumableEffect effect = ConsumableEffectFactory.createEffect(consumable);
            if (effect.apply(terrain, monster)) {
                consumable.consume();
            }
        }
        fightView.removeButtons(player);
    }
}
