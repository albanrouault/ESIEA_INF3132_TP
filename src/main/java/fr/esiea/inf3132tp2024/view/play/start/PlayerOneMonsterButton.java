package fr.esiea.inf3132tp2024.view.play.start;

import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type.ChooseMonstersTypeView;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import java.util.ArrayList;

public class PlayerOneMonsterButton extends TButton {
    private ArrayList<MonsterTemplate> listMonstrePlayerOne;
    private DisplayableComponent previousView;

    public PlayerOneMonsterButton(ArrayList<MonsterTemplate> listMonstrePlayerOne, DisplayableComponent previousView) {
        super("Choisir un monstre pour le joueur 1\n(aléatoire si aucun monstre sélectionné)");
        this.listMonstrePlayerOne = listMonstrePlayerOne;
        this.previousView = previousView;
    }

    @Override
    public void execute() {
        // Aller sur la vue de choix de monstre pour le joueur 1
        Terminal.getInstance().show(new ChooseMonstersTypeView(previousView, listMonstrePlayerOne));
    }
}