package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Monster;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type.ChooseMonstersTypeView;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import java.util.ArrayList;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
public class ChooseMonsterButton extends TButton {
    private final DisplayableComponent previousView;
    private final DisplayableComponent currentView;
    private final ArrayList<MonsterTemplate> selectedMonsters;
    private final MonsterTemplate monster;

    public ChooseMonsterButton(DisplayableComponent previousView, ArrayList<MonsterTemplate> selectedMonsters, MonsterTemplate monster, DisplayableComponent currentView) {
        super(monster.getName());
        this.previousView = previousView;
        this.selectedMonsters = selectedMonsters;
        this.monster = monster;
        this.currentView = currentView;
    }

    @Override
    public void execute() {
        this.selectedMonsters.add(this.monster);
        this.currentView.stopLoopingMode();
        Terminal.getInstance().show(new ChooseMonstersTypeView(previousView, selectedMonsters));
    }
}
