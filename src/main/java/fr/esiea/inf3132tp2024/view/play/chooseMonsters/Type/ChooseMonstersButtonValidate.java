package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;

public class ChooseMonstersButtonValidate extends TButton {
    private DisplayableComponent previousView;
    private DisplayableComponent currentView;
    public ChooseMonstersButtonValidate(DisplayableComponent previousView, DisplayableComponent currentView ) {
        super("Valider");
        this.previousView = previousView;
        this.currentView = currentView;
    }

    @Override
    public void execute() {
        this.currentView.stopLoopingMode();
        Terminal.getInstance().show(previousView);
    }
}
