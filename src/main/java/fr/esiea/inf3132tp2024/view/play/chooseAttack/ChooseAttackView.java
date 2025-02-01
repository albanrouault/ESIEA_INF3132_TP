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
import fr.esiea.inf3132tp2024.view.play.AttackStats;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;

import java.util.LinkedList;
import java.util.List;

public class ChooseAttackView extends TFrame implements DisplayableComponent {
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;
    private final PlayerStats playerStats;
    private final PlayerStats opponentStats;
    private final TChoices attackChoices;
    private final List<AttackStats> attacksStats = new LinkedList<>();
    private final Attack[] attacks;
    private boolean display = true;
    private boolean choiceMade = false;

    /**
     * Constructeur de la vue de sélection d'attaque.
     *
     * @param attacks la liste des attaques disponibles
     */
    public ChooseAttackView(Player player, Player opponent, Monster monster, Attack[] attacks) {
        super(0, 0, player.getName() + " - " + monster.getName() + " - Choisir une attaque");

        this.attacks = attacks;

        // Configuration du contentPane
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);
        this.getContentPane().setRenderingMainPadding(true);

        leftPanel = new TPanel(0, 0);
        centerPanel = new TPanel(0, 0);
        this.rightPanel = new TPanel(0, 0);

        // Panel de gauche - Stats du joueur x Choix d'attaque
        playerStats = new PlayerStats(player, true);
        leftPanel.getComponents().add(playerStats);

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

        // Ajout du panneau de choix d'attaque
        leftPanel.getComponents().add(attackChoices);

        leftPanel.autoResize();

        // Panel central - Stats des attaques
        refreshMonsters();

        // Panel de droite - Stats de l'adversaire
        opponentStats = new PlayerStats(opponent, true);
        rightPanel.getComponents().add(opponentStats);
        rightPanel.autoResize();

        // Ajout du panneau au content pane
        this.getContentPane().getComponents().add(leftPanel);
        this.getContentPane().getComponents().add(centerPanel);
        this.getContentPane().getComponents().add(rightPanel);
    }

    private void refreshMonsters() {
        // Nettoyer l'ancien contenu
        centerPanel.getComponents().clear();
        attacksStats.clear();

        // Créer les composants pour chaque attaque
        for (Attack attack : attacks) {
            AttackStats stats = new AttackStats(attack);
            attacksStats.add(stats);
            centerPanel.getComponents().add(stats);
        }

        centerPanel.autoResize();
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

    @Override
    public void setLength(int length) {
        super.setLength(length);
        int contentWidth = length - 2;
        leftPanel.setLength((int) (contentWidth * 0.4));
        centerPanel.setLength((int) (contentWidth * 0.2));
        rightPanel.setLength((int) (contentWidth * 0.4));
        playerStats.setLength((int) (contentWidth * 0.4));
        opponentStats.setLength((int) (contentWidth * 0.4));
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        int contentHeight = height - 4;
        leftPanel.setHeight(contentHeight);
        centerPanel.setHeight(contentHeight);
        rightPanel.setHeight(contentHeight);
    }

    public boolean isChoiceMade() {
        return choiceMade;
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
            this.monster.setCurrentAttack(this.attack);
            choiceMade = true;
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