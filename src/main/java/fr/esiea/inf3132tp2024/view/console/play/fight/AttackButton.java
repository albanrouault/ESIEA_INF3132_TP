package fr.esiea.inf3132tp2024.view.console.play.fight;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;

public class AttackButton extends TButton {
    private final Fight fight;

    public AttackButton(App app, Fight fight) {
        super(app, "Attaquer");

        this.fight = fight;
    }

    @Override
    public void execute() {
        fight.attack();
    }
}
