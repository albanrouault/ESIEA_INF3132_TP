package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Monster;

import java.util.ArrayList;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.model.Types;
import java.util.LinkedList;
import fr.esiea.inf3132tp2024.controller.MonstreManager;

public class ChooseMonstersView extends TFrame implements DisplayableComponent {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private LinkedList<MonsterTemplate> monsters;
    private Types typeMonster;
    private TLabel monsterLabelOne;
    private TLabel monsterLabelTwo;
    private TLabel monsterLabelThree;
    private TLabel monsterLabelFour;
    private ChooseMonstersButtonCancel cancelButton;
    private LinkedList<ChooseMonsterButton> monsterButtons;
    private DisplayableComponent previousView;
    private boolean display = true;

    public ChooseMonstersView(DisplayableComponent previousView, ArrayList<MonsterTemplate> selectedMonsters, Types typeMonster) {
        super(0, 0, "Choisir un monstre");
        this.previousView = previousView;
        this.selectedMonsters = selectedMonsters;

        // Création des labels de monstre
        this.monsterLabelOne = new TLabel("Monstre 1\nNon Sélectionné");
        this.monsterLabelTwo = new TLabel("Monstre 2\nNon Sélectionné");
        this.monsterLabelThree = new TLabel("Monstre 3\nNon Sélectionné");
        this.monsterLabelFour = new TLabel("Monstre 4\nNon Sélectionné");

        // Pour chaque monstre dans la liste on change le label en fonction du type de monstre
        // S'il y a un élément à la position 0, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 0) {
            this.monsterLabelOne.setText(selectedMonsters.get(0).getName() + "\n" + selectedMonsters.get(0).getName());
        }
        // S'il y a un élément à la position 1, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 1) {
            this.monsterLabelTwo.setText(selectedMonsters.get(1).getName() + "\n" + selectedMonsters.get(1).getName());
        }
        // S'il y a un élément à la position 2, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 2) {
            this.monsterLabelThree.setText(selectedMonsters.get(2).getName() + "\n" + selectedMonsters.get(2).getName());
        }
        // S'il y a un élément à la position 3, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 3) {
            this.monsterLabelFour.setText(selectedMonsters.get(3).getName() + "\n" + selectedMonsters.get(3).getName());
        }

        // Création des boutons de validation, de retour et de choix de monstre
        this.cancelButton = new ChooseMonstersButtonCancel(selectedMonsters, previousView);

        // On récupère la liste des templates de monstres et on la trie par type de monstre que l'on a choisi puis on la met dans la liste monsters
        this.monsters = new LinkedList<>(MonstreManager.getInstance().getMonstresModels());
        this.monsters.removeIf(monster -> monster.getType() != typeMonster);
        this.monsters.sort((a, b) -> a.getName().compareTo(b.getName()));

        // On crée un bouton pour chaque monstre dans la liste monsters
        for (MonsterTemplate monster : monsters) {
            this.monsterButtons.add(new ChooseMonsterButton(this, selectedMonsters, monster));
        }

        // On construit la page
    }

    public void addMonster(MonsterTemplate monster) {
        this.selectedMonsters.add(monster);
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public void stopLoopingMode() {
        display = false;
    }
}
