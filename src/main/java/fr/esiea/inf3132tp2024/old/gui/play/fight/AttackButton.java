package fr.esiea.inf3132tp2024.old.gui.play.fight;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;

public class AttackButton extends CButton {
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
