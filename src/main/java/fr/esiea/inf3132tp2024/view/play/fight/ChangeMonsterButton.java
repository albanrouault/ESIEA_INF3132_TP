package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffectFactory;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseMonster.ChooseMonsterView;

public class ChangeMonsterButton extends TButton {
    private final FightView fightView;
    private final Player player;
    private final Terrain terrain;
    private final Consumable consumable;
    private final Monster monster;
    private final Monster opponentMonster;

    public ChangeMonsterButton(FightView fightView, Fight fight, Player player, Consumable consumable, Monster monster, Monster opponentMonster) {
        super(player.getName() + "\nchanger de monstre");

        this.fightView = fightView;
        this.player = player;
        this.terrain = fight.getTerrain();
        this.consumable = consumable;
        this.monster = monster;
        this.opponentMonster = opponentMonster;
    }

    @Override
    public void execute() {
        ChooseMonsterView chooseMonsterView = new ChooseMonsterView(fightView, player);

        Terminal.getInstance().show(chooseMonsterView);

        fightView.removeButtons(player);
    }
}
