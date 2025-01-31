package fr.esiea.inf3132tp2024.view.play.chooseAttack;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class ChooseAttackView extends TFrame implements DisplayableComponent {
    private final TPanel attackPanel;
    private final TChoices attackChoices;
    private boolean display = true;

    /**
     * Constructeur de la vue de sélection d'attaque.
     *
     * @param attacks la liste des attaques disponibles
     */
    public ChooseAttackView(Player player, Monster monster, Attack[] attacks) {
        super(0, 0, player.getName() + " - " + monster.getName() + " - Choisir une attaque");

        // Initialisation du panneau pour les boutons d'attaque
        attackPanel = new TPanel(0, 0);
        attackChoices = new TChoices(Orientation.VERTICAL, 1);

        // Création d'un bouton pour chaque attaque
        for (Attack attack : attacks) {
            AttackButton btn = new AttackButton(monster, attack);
            attackChoices.add(btn);
        }

        // Ajout du bouton de retour
        ReturnButton returnBtn = new ReturnButton();
        attackChoices.add(returnBtn);
        attackChoices.autoResize();

        // Ajout du panneau de choix d'attaque au panneau principal
        attackPanel.getComponents().add(attackChoices);
        attackPanel.autoResize();

        // Ajout du panneau au content pane
        this.getContentPane().getComponents().add(attackPanel);
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

    /**
     * Bouton interne représentant une attaque sélectionnable.
     */
    private class AttackButton extends TButton {
        private final Monster monster;
        private final Attack attack;

        public AttackButton(Monster monster, Attack attack) {
            // Le texte du bouton affiche le nom de l'attaque
            super(attack.getName());
            this.monster = monster;
            this.attack = attack;
        }

        @Override
        public void execute() {
            // Ici, vous pouvez ajouter la logique nécessaire pour lancer l'attaque
            // Pour l'exemple, on affiche simplement un message dans la console
            // On arrête le mode looping après la sélection
            this.monster.setCurrentAttack(this.attack);
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