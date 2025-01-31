package fr.esiea.inf3132tp2024.view.play.chooseAttack;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;

public class ChooseAttackView extends TFrame implements DisplayableComponent {
    private final TPanel attackPanel;
    private final DisplayableComponent previousView;
    private boolean display = true;

    /**
     * Constructeur de la vue de sélection d'attaque.
     *
     * @param previousView la vue précédente à laquelle revenir
     * @param attacks la liste des attaques disponibles
     */
    public ChooseAttackView(DisplayableComponent previousView, Attack[] attacks) {
        super(0, 0, "Choisir une attaque");
        this.previousView = previousView;

        // Initialisation du panneau pour les boutons d'attaque
        attackPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Création d'un bouton pour chaque attaque
        for (Attack attack : attacks) {
            AttackButton btn = new AttackButton(attack);
            attackPanel.getComponents().add(btn);
        }

        // Ajout du bouton de retour
        ReturnButton returnBtn = new ReturnButton();
        attackPanel.getComponents().add(returnBtn);

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
        private final Attack attack;

        public AttackButton(Attack attack) {
            // Le texte du bouton affiche le nom de l'attaque
            super(attack.getName());
            this.attack = attack;
        }

        @Override
        public void execute() {
            // Ici, vous pouvez ajouter la logique nécessaire pour lancer l'attaque
            // Pour l'exemple, on affiche simplement un message dans la console
            System.out.println("Attaque choisie: " + attack.getName());
            // On arrête le mode looping après la sélection
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
            // Lors du retour, on affiche la vue précédente
            Terminal.getInstance().show(previousView);
            stopLoopingMode();
        }
    }
} 