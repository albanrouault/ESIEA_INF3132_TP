package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;

public class ChooseMonstersButtonValidate extends TButton {
    private DisplayableComponent previousView;
    public ChooseMonstersButtonValidate(DisplayableComponent previousView) {
        super("Valider");
        this.previousView = previousView;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(previousView);
    }
}
