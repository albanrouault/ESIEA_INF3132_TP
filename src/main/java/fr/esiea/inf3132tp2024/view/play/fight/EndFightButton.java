package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class EndFightButton extends TButton {
    private final FightView fightView;

    public EndFightButton(FightView fightView) {
        super("Fin du round");

        this.fightView = fightView;
    }

    @Override
    public void execute() {
        fightView.stopLoopingMode();
    }
}
