package fr.esiea.inf3132tp2024.view.play.start;

import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.ChooseMonstersView;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import java.util.ArrayList;

public class PlayerTwoMonsterButton extends TButton {
    private ArrayList<MonsterTemplate> listMonstrePlayerTwo;
    private DisplayableComponent previousView;

    public PlayerTwoMonsterButton(ArrayList<MonsterTemplate> listMonstrePlayerTwo, DisplayableComponent previousView) {
        super("Choisir un monstre pour le joueur 2\n(aléatoire si aucun monstre sélectionné)");
        this.listMonstrePlayerTwo = listMonstrePlayerTwo;
        this.previousView = previousView;
    }

    @Override
    public void execute() {
        // Aller sur la vue de choix de monstre pour le joueur 2
        Terminal.getInstance().show(new ChooseMonstersView(previousView, listMonstrePlayerTwo));
    }
}