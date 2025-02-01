package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import java.util.ArrayList;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.Monster.ChooseMonstersView;

public class ChooseMonstersButtonType extends TButton {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private DisplayableComponent previousView;
    private Types typeMonster;
    public ChooseMonstersButtonType(ArrayList<MonsterTemplate> selectedMonsters, DisplayableComponent previousView, Types typeMonster) {
        super("Choisir un monstre");
        this.selectedMonsters = selectedMonsters;
        this.previousView = previousView;
        this.typeMonster = typeMonster;
    }

    @Override
    public void execute() {
        // Aller sur la vue de choix de monstre pour le joueur 2
        Terminal.getInstance().show(new ChooseMonstersView(previousView, selectedMonsters, typeMonster));
    }
}
