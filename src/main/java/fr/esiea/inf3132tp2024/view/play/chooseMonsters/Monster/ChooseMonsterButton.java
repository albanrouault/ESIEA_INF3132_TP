package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Monster;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type.ChooseMonstersTypeView;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import java.util.ArrayList;

public class ChooseMonsterButton extends TButton {
    private final ChooseMonstersView previousView;
    private final ArrayList<MonsterTemplate> selectedMonsters;
    private final MonsterTemplate monster;

    public ChooseMonsterButton(ChooseMonstersView previousView, ArrayList<MonsterTemplate> selectedMonsters, MonsterTemplate monster) {
        super("Choisir un monstre");
        this.previousView = previousView;
        this.selectedMonsters = selectedMonsters;
        this.monster = monster;
    }

    @Override
    public void execute() {
        this.previousView.addMonster(this.monster);
        Terminal.getInstance().show(new ChooseMonstersTypeView(previousView, selectedMonsters));
    }
}
