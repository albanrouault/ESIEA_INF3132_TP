package fr.esiea.inf3132tp2024.view.play.chooseConsumable;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffect;
import fr.esiea.inf3132tp2024.model.consumable.ConsumableEffectFactory;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class ChooseConsumableView extends TFrame implements DisplayableComponent {
    private final TPanel consumablePanel;
    private final TChoices consumableChoices;
    private boolean display = true;
    private boolean choiceMade = false;

    /**
     * Constructeur de la vue de sélection de consommable.
     *
     * @param consumables la liste des consommables à afficher
     */
    public ChooseConsumableView(Player player, Terrain terrain, Monster monster, Consumable[] consumables) {
        super(0, 0, player.getName() + " - " + monster.getName() + " - Choisir un objet");

        // Initialisation du panneau pour les boutons d'objets
        consumablePanel = new TPanel(0, 0);
        consumableChoices = new TChoices(Orientation.VERTICAL, 1);

        // Création d'un bouton pour chaque objet
        for (Consumable consumable : consumables) {
            ConsumableButton btn = new ConsumableButton(monster, terrain, consumable);
            consumableChoices.add(btn);
        }

        // Ajout du bouton de retour
        ReturnButton returnBtn = new ReturnButton();
        consumableChoices.add(returnBtn);
        consumableChoices.autoResize();

        // Ajout du panneau de choix d'attaque au panneau principal
        consumablePanel.getComponents().add(consumableChoices);
        consumablePanel.autoResize();

        // Ajout du panneau au content pane
        this.getContentPane().getComponents().add(consumablePanel);
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

    public boolean isChoiceMade() {
        return choiceMade;
    }

    /**
     * Bouton interne représentant une attaque sélectionnable.
     */
    private class ConsumableButton extends TButton {
        private final Monster monster;
        private final Terrain terrain;
        private final Consumable consumable;

        public ConsumableButton(Monster monster, Terrain terrain, Consumable consumable) {
            // Le texte du bouton affiche le nom de l'objet
            super(consumable.getName());
            this.monster = monster;
            this.terrain = terrain;
            this.consumable = consumable;
        }

        @Override
        public void execute() {
            if (!consumable.isConsumed()) {
                ConsumableEffect effect = ConsumableEffectFactory.createEffect(consumable);
                if (effect.apply(terrain, monster)) {
                    consumable.consume();
                    choiceMade = true;
                }
            }
            stopLoopingMode();
        }
    }

    /**
     * Bouton interne pour revenir à la vue précédente.
     */
    private class ReturnButton extends TButton {
        public ReturnButton() {
            super("Retour");
        }

        @Override
        public void execute() {
            stopLoopingMode();
        }
    }
} 