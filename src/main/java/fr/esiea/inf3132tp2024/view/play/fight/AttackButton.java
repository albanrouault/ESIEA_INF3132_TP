package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class AttackButton extends TButton {
    private final FightView fightView;

    public AttackButton(FightView fightView) {
        super("Attaquer");

        this.fightView = fightView;
    }

    @Override
    public void execute() {
        fightView.attack();
    }
}
