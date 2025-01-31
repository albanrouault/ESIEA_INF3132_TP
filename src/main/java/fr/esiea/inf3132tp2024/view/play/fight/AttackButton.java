package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.attack.processor.AttackProcessor;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class AttackButton extends TButton {
    private final FightView fightView;
    private final Player player;
    private final Terrain terrain;
    private final Monster monster;
    private final Monster opponentMonster;

    public AttackButton(FightView fightView, Fight fight, Player player, Monster monster, Monster opponentMonster) {
        super(player.getName() + " attaque");

        this.fightView = fightView;
        this.player = player;
        this.terrain = fight.getTerrain();
        this.monster = monster;
        this.opponentMonster = opponentMonster;
    }

    @Override
    public void execute() {
        // TODO : Ajouter le traitement de l'attaque en passant l'attaque
        AttackProcessor.processAttack(fightView.getFight().getRandom(), monster, null, opponentMonster, terrain);

        fightView.removeButtons(player);
    }
}
