package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type;

import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import java.util.ArrayList;

public class ChooseMonstersButtonCancel extends TButton {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private DisplayableComponent previousView;
    private DisplayableComponent currentView;

    public ChooseMonstersButtonCancel(ArrayList<MonsterTemplate> selectedMonsters, DisplayableComponent previousView, DisplayableComponent currentView) {
        super("Abandonner");
        this.selectedMonsters = selectedMonsters;
        this.previousView = previousView;
        this.currentView = currentView;
    }

    @Override
    public void execute() {
        // On vide la liste de monstres et on revient sur la vue précédente
        this.currentView.stopLoopingMode();
        this.selectedMonsters.clear();
        Terminal.getInstance().show(previousView);
    }
}
