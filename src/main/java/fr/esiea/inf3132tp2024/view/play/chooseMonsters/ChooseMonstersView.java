package fr.esiea.inf3132tp2024.view.play.chooseMonsters;

import java.util.ArrayList;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;

public class ChooseMonstersView extends TFrame implements DisplayableComponent {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private TLabel monsterLabelOne;
    private TLabel monsterLabelTwo;
    private TLabel monsterLabelThree;
    private TLabel monsterLabelFour;
    private ChooseMonstersButtonValidate validateButton;
    private ChooseMonstersButtonCancel cancelButton;
    private ChooseMonstersButtonMonster monsterButton;
    private DisplayableComponent previousView;
    private boolean display = true;

    public ChooseMonstersView(DisplayableComponent previousView, ArrayList<MonsterTemplate> selectedMonsters) {
        super(0, 0, "Choisir les monstres");
        this.previousView = previousView;
        this.selectedMonsters = selectedMonsters;
        this.monsterLabelOne = new TLabel("Monstre 1\nNon Sélectionné");
        this.monsterLabelTwo = new TLabel("Monstre 2\nNon Sélectionné");
        this.monsterLabelThree = new TLabel("Monstre 3\nNon Sélectionné");
        this.monsterLabelFour = new TLabel("Monstre 4\nNon Sélectionné");
        this.validateButton = new ChooseMonstersButtonValidate();
        this.cancelButton = new ChooseMonstersButtonCancel();
        this.monsterButton = new ChooseMonstersButtonMonster();
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
