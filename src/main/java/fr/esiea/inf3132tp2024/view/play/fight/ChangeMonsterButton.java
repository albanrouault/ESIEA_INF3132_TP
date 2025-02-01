package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseMonster.ChooseMonsterView;

public class ChangeMonsterButton extends TButton {
    private final FightView fightView;
    private final Player player;
    private final Player opponent;

    public ChangeMonsterButton(FightView fightView, Player player, Player opponent) {
        super(player.getName() + "\nChanger de monstre");

        this.fightView = fightView;
        this.player = player;
        this.opponent = opponent;
    }

    @Override
    public void execute() {
        ChooseMonsterView chooseMonsterView = new ChooseMonsterView(player, opponent, true);

        Terminal.getInstance().show(chooseMonsterView);

        if (chooseMonsterView.isChoiceMade()) {
            fightView.removeButtons(player);
        }
    }
}
