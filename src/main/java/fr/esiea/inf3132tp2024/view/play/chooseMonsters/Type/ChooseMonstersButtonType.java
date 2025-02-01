package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type;

import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.model.Types;
import fr.esiea.inf3132tp2024.model.monster.file.MonsterTemplate;
import java.util.ArrayList;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.Monster.ChooseMonstersView;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;

public class ChooseMonstersButtonType extends TButton {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private DisplayableComponent previousView;
    private Types typeMonster;
    private DisplayableComponent currentView;
    public ChooseMonstersButtonType(ArrayList<MonsterTemplate> selectedMonsters, DisplayableComponent previousView, Types typeMonster, DisplayableComponent currentView) {
        super(typeMonster.getName());
        this.selectedMonsters = selectedMonsters;
        this.previousView = previousView;
        this.typeMonster = typeMonster;
        this.currentView = currentView;

        switch (typeMonster) {
            case FIRE:
                this.getColors().add(TColor.RED);
                break;
            case WATER:
                this.getColors().add(TColor.BLUE);
                break;
            case EARTH:
                this.getColors().add(TColor.YELLOW);
                break;
            case ELECTRIC:
                this.getColors().add(TColor.BRIGHT_CYAN);
                break;
            case NATURE_PLANT:
                this.getColors().add(TColor.GREEN);
                break;
            case NATURE_INSECT:
                this.getColors().add(TColor.BRIGHT_MAGENTA);
                break;
        }
    }

    @Override
    public void execute() {
        // Aller sur la vue de choix de monstre pour le joueur 2
        this.currentView.stopLoopingMode();
        Terminal.getInstance().show(new ChooseMonstersView(previousView, selectedMonsters, typeMonster));
    }
}
