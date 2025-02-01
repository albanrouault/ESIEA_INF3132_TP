package fr.esiea.inf3132tp2024.view.play.chooseMonster;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.play.MonsterStats;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;

import java.util.LinkedList;
import java.util.List;

/**
 * Vue de sélection du monstre qui doit combattre.
 * Cette vue est accessible depuis la GameView via un bouton.
 */
public class ChooseMonsterView extends TFrame implements DisplayableComponent {
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;
    private final PlayerStats currentPlayerStats;
    private final PlayerStats opponentStats;
    private final TChoices monstersChoices;
    private final List<MonsterStats> otherMonstersStats = new LinkedList<>();
    private final Player currentPlayer;
    private final Player opponent;
    private boolean display = true;
    private boolean choiceMade = false;

    public ChooseMonsterView(Player currentPlayer, Player opponent, boolean back) {
        super(0, 0, currentPlayer.getName() + " - Choisir un monstre");
        this.currentPlayer = currentPlayer;
        this.opponent = opponent;

        // Configuration du contentPane
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);
        this.getContentPane().setRenderingMainPadding(true);

        leftPanel = new TPanel(0, 0);
        centerPanel = new TPanel(0, 0);
        rightPanel = new TPanel(0, 0);

        // Panel gauche - Stats joueur actuel + sélection
        currentPlayerStats = new PlayerStats(currentPlayer, true);
        leftPanel.getComponents().add(currentPlayerStats);

        // Choix des monstres
        monstersChoices = new TChoices(Orientation.VERTICAL, 1);
        populateMonsterChoices();
        if (back) {
            monstersChoices.add(new ReturnButton());
        }
        leftPanel.getComponents().add(monstersChoices);

        // Panel centre - Stats autres monstres non sélectionnés
        refreshOtherMonsters();

        // Panel droit - Stats adversaire
        opponentStats = new PlayerStats(opponent, false);
        rightPanel.getComponents().add(opponentStats);

        // Assemblage
        this.getContentPane().getComponents().add(leftPanel);
        this.getContentPane().getComponents().add(centerPanel);
        this.getContentPane().getComponents().add(rightPanel);
    }

    private void populateMonsterChoices() {
        for (Monster monster : currentPlayer.getMonsters()) {
            if (monster.isAlive() && monster != currentPlayer.getCurrentMonster()) {
                MonsterButton btn = new MonsterButton(monster);
                monstersChoices.add(btn);
            }
        }
        monstersChoices.autoResize();
    }

    private void refreshOtherMonsters() {
        centerPanel.getComponents().clear();
        otherMonstersStats.clear();

        for (Monster monster : currentPlayer.getMonsters()) {
            if (monster != currentPlayer.getCurrentMonster() && monster.isAlive()) {
                MonsterStats stats = new MonsterStats(monster);
                otherMonstersStats.add(stats);
                centerPanel.getComponents().add(stats);
            }
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
        leftPanel.setLength((int) (contentWidth * 0.3));
        centerPanel.setLength((int) (contentWidth * 0.4));
        rightPanel.setLength((int) (contentWidth * 0.3));
        currentPlayerStats.setLength((int) (contentWidth * 0.3));
        opponentStats.setLength((int) (contentWidth * 0.3));
        for (MonsterStats stats : otherMonstersStats) {
            stats.setLength((int) (contentWidth * 0.4));
        }
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

    private class MonsterButton extends TButton {
        private final Monster monster;

        public MonsterButton(Monster monster) {
            super(monster.getName());
            this.monster = monster;
        }

        @Override
        public void execute() {
            currentPlayer.setCurrentMonster(monster);
            choiceMade = true;
            refreshOtherMonsters();
            stopLoopingMode();
        }
    }

    private class ReturnButton extends TButton {
        public ReturnButton() {
            super("Retour");
            this.getColors().add(TColor.RED);
        }

        @Override
        public void execute() {
            stopLoopingMode();
        }
    }
}
