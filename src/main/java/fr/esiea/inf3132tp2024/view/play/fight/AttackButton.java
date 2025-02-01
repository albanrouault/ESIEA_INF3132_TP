package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.attack.processor.AttackProcessor;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackEffect;
import fr.esiea.inf3132tp2024.model.attack.special.SpecialAttackFactory;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseAttack.ChooseAttackView;

public class AttackButton extends TButton {
    private final FightView fightView;
    private final Player player;
    private final Player opponent;
    private final Terrain terrain;
    private final Monster monster;
    private final Monster opponentMonster;

    public AttackButton(FightView fightView, Fight fight, Player player, Player opponent, Monster monster, Monster opponentMonster) {
        super(player.getName() + "\nAttaquer");

        this.fightView = fightView;
        this.player = player;
        this.opponent = opponent;
        this.terrain = fight.getTerrain();
        this.monster = monster;
        this.opponentMonster = opponentMonster;
    }

    @Override
    public void execute() {
        ChooseAttackView chooseAttackView = new ChooseAttackView(player, opponent, monster, monster.getAttacks());

        Terminal.getInstance().show(chooseAttackView);

        if (chooseAttackView.isChoiceMade()) {
            Attack attack = monster.getCurrentAttack();

            AttackProcessor.processAttack(fightView.getFight().getRandom(), monster, attack, opponentMonster, terrain);

            // Effet spécial
            if (attack != null && attack.getType() != Types.NORMAL && attack.getType() == monster.getType()) {
                SpecialAttackEffect effect = SpecialAttackFactory.getSpecialAttackEffect(monster.getType());
                if (effect != null) {
                    effect.apply(fightView.getFight().getRandom(), terrain, monster, opponentMonster);
                }
            }

            fightView.removeButtons(player);
        }
    }
}
