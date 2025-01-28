package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;

public class AttackButton extends TButton {
    private final Fight fight;

    public AttackButton(Fight fight) {
        super("Attaquer");

        this.fight = fight;
    }

    @Override
    public void execute() {
        fight.attack();
    }
}
