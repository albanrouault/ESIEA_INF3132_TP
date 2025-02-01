package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseConsumable.ChooseConsumableView;

public class UseItemButton extends TButton {
    private final FightView fightView;
    private final Player player;
    private final Terrain terrain;
    private final Monster monster;

    public UseItemButton(FightView fightView, Fight fight, Player player, Monster monster) {
        super(player.getName() + "\nUtiliser un objet");

        this.fightView = fightView;
        this.player = player;
        this.terrain = fight.getTerrain();
        this.monster = monster;
    }

    @Override
    public void execute() {
        ChooseConsumableView chooseConsumableView = new ChooseConsumableView(player, terrain, monster, player.getConsumables());

        Terminal.getInstance().show(chooseConsumableView);

        if (chooseConsumableView.isChoiceMade()) {
            fightView.removeButtons(player);
        }
    }
}
