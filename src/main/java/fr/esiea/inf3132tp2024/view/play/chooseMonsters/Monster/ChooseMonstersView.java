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
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoiceScrollable;
import java.util.LinkedList;
import fr.esiea.inf3132tp2024.controller.MonstreManager;

public class ChooseMonstersView extends TFrame implements DisplayableComponent {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private LinkedList<MonsterTemplate> monsters;
    private Types typeMonster;
    private TLabel monsterLabelOne;
    private TLabel monsterLabelTwo;
    private TLabel monsterLabelThree;
    private ChooseMonstersButtonCancel cancelButton;
    private LinkedList<ChooseMonsterButton> monsterButtons = new LinkedList<>();
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

        // Pour chaque monstre dans la liste on change le label en fonction du type de monstre
        // S'il y a un élément à la position 0, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 0) {
            this.monsterLabelOne.setText("Monstre 1\n" + selectedMonsters.get(0).getName());
        }
        // S'il y a un élément à la position 1, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 1) {
            this.monsterLabelTwo.setText("Monstre 2\n" + selectedMonsters.get(1).getName());
        }
        // S'il y a un élément à la position 2, on change le label en fonction du type de monstre
        if (selectedMonsters.size() > 2) {
            this.monsterLabelThree.setText("Monstre 3\n" + selectedMonsters.get(2).getName());
        }

        // Création des boutons de validation, de retour et de choix de monstre
        this.cancelButton = new ChooseMonstersButtonCancel(selectedMonsters, previousView, this);

        // On récupère la liste des templates de monstres et on la trie par type de monstre que l'on a choisi puis on la met dans la liste monsters
        this.monsters = new LinkedList<>(MonstreManager.getInstance().getMonstresModels());
        this.monsters.removeIf(monster -> monster.getType() != typeMonster);
        this.monsters.sort((a, b) -> a.getName().compareTo(b.getName()));

        // On crée un bouton pour chaque monstre dans la liste monsters
        for (MonsterTemplate monster : monsters) {
            this.monsterButtons.add(new ChooseMonsterButton(previousView, selectedMonsters, monster, this));
        }

        // On construit la page
        // On récup le panneau principal et on le met en ligne
        TPanel mainPanel = this.getContentPane();
        // Les textes des monstres
        TPanel textMonsters = new TPanel(100,4);
        textMonsters.setHorizontalAlignment(HorizontalAlignment.CENTER);
        textMonsters.setRenderingOrientation(Orientation.HORIZONTAL);
        textMonsters.getComponents().add(monsterLabelOne);
        textMonsters.getComponents().add(monsterLabelTwo);
        textMonsters.getComponents().add(monsterLabelThree);
        mainPanel.getComponents().add(textMonsters);

        // Les choix de types
        TChoiceScrollable choices = new TChoiceScrollable(1);
        choices.add(cancelButton);
        choices.getComponents().add(new TLabel(""));
        mainPanel.getComponents().add(choices);
        for (ChooseMonsterButton monsterButton : monsterButtons) {
            choices.add(monsterButton);
        }
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
