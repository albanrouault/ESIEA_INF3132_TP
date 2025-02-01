package fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type;

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
import fr.esiea.inf3132tp2024.view.play.chooseMonsters.Type.ChooseMonstersButtonType;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;

public class ChooseMonstersTypeView extends TFrame implements DisplayableComponent {
    private ArrayList<MonsterTemplate> selectedMonsters;
    private TLabel monsterLabelOne;
    private TLabel monsterLabelTwo;
    private TLabel monsterLabelThree;
    private ChooseMonstersButtonValidate validateButton;
    private ChooseMonstersButtonCancel cancelButton;
    private DisplayableComponent previousView;
    private ChooseMonstersButtonType chooseMonstersButtonTypeElectric;
    private ChooseMonstersButtonType chooseMonstersButtonTypeEarth;
    private ChooseMonstersButtonType chooseMonstersButtonTypeFire;
    private ChooseMonstersButtonType chooseMonstersButtonTypeWater;
    private ChooseMonstersButtonType chooseMonstersButtonTypeNaturePlant;
    private ChooseMonstersButtonType chooseMonstersButtonTypeNatureInsect;
    private boolean display = true;

    public ChooseMonstersTypeView(DisplayableComponent previousView, ArrayList<MonsterTemplate> selectedMonsters) {
        super(0, 0, "Choisir un type de monstre");
        this.previousView = previousView;
        this.selectedMonsters = selectedMonsters;

        // Création des labels de monstre
        this.monsterLabelOne = new TLabel("Monstre 1\nNon Sélectionné");
        this.monsterLabelTwo = new TLabel("Monstre 2\nNon Sélectionné");
        this.monsterLabelThree = new TLabel("Monstre 3\nNon Sélectionné");

        // Création des boutons de validation, de retour et de choix de monstre
        this.cancelButton = new ChooseMonstersButtonCancel(selectedMonsters, previousView, this);

        // Création des boutons de choix de type de monstre
        this.chooseMonstersButtonTypeElectric = new ChooseMonstersButtonType(selectedMonsters, previousView,
                Types.ELECTRIC, this);
        this.chooseMonstersButtonTypeEarth = new ChooseMonstersButtonType(selectedMonsters, previousView, Types.EARTH, this);
        this.chooseMonstersButtonTypeFire = new ChooseMonstersButtonType(selectedMonsters, previousView, Types.FIRE, this);
        this.chooseMonstersButtonTypeWater = new ChooseMonstersButtonType(selectedMonsters, previousView, Types.WATER, this);
        this.chooseMonstersButtonTypeNaturePlant = new ChooseMonstersButtonType(selectedMonsters, previousView,
                Types.NATURE_PLANT, this);
        this.chooseMonstersButtonTypeNatureInsect = new ChooseMonstersButtonType(selectedMonsters, previousView,
                Types.NATURE_INSECT, this);

        // Pour chaque monstre dans la liste on change le label en fonction du type de
        // monstre
        // S'il y a un élément à la position 0, on change le label en fonction du type
        // de monstre
        if (selectedMonsters.size() > 0) {
            this.monsterLabelOne.setText(selectedMonsters.get(0).getName() + "\n" + selectedMonsters.get(0).getName());
        }
        // S'il y a un élément à la position 1, on change le label en fonction du type
        // de monstre
        if (selectedMonsters.size() > 1) {
            this.monsterLabelTwo.setText(selectedMonsters.get(1).getName() + "\n" + selectedMonsters.get(1).getName());
        }
        // S'il y a un élément à la position 2, on change le label en fonction du type
        // de monstre
        if (selectedMonsters.size() > 2) {
            this.monsterLabelThree
                    .setText(selectedMonsters.get(2).getName() + "\n" + selectedMonsters.get(2).getName());
        }
        // Bouton validation visible si tous les monstres sont sélectionnés
        if (selectedMonsters.size() == 3) {
            this.validateButton = new ChooseMonstersButtonValidate(previousView, this);
        }

        // On construit la page

        // On récup le panneau principal et on le met en ligne
        TPanel mainPanel = this.getContentPane();
        // Les textes des monstres
        TPanel textMonsters = new TPanel(100, 4);
        textMonsters.setHorizontalAlignment(HorizontalAlignment.CENTER);
        textMonsters.setRenderingOrientation(Orientation.HORIZONTAL);
        textMonsters.getComponents().add(monsterLabelOne);
        textMonsters.getComponents().add(monsterLabelTwo);
        textMonsters.getComponents().add(monsterLabelThree);
        mainPanel.getComponents().add(textMonsters);

        // Les choix de types
        TChoices choices = new TChoices(1);
        if (selectedMonsters.size() == 3) {
            choices.add(validateButton);
        }
        choices.add(cancelButton);
        if (selectedMonsters.size() != 3) {
            choices.getComponents().add(new TLabel(""));
            choices.add(chooseMonstersButtonTypeElectric);
            choices.add(chooseMonstersButtonTypeEarth);
            choices.add(chooseMonstersButtonTypeFire);
            choices.add(chooseMonstersButtonTypeWater);
            choices.add(chooseMonstersButtonTypeNaturePlant);
            choices.add(chooseMonstersButtonTypeNatureInsect);
        }

        mainPanel.getComponents().add(choices);

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
