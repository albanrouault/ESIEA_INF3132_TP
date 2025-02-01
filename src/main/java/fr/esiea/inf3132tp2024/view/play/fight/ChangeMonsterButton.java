package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseMonster.ChooseMonsterView;

public class ChangeMonsterButton extends TButton {
    private final FightView fightView;
    private final Player player;

    public ChangeMonsterButton(FightView fightView, Fight fight, Player player) {
        super(player.getName() + "\nChanger de monstre");

        this.fightView = fightView;
        this.player = player;
    }

    @Override
    public void execute() {
        ChooseMonsterView chooseMonsterView = new ChooseMonsterView(player, true);

        Terminal.getInstance().show(chooseMonsterView);

        if (chooseMonsterView.isChoiceMade()) {
            fightView.removeButtons(player);
        }
    }
}
