package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;

public class FightView extends TFrame implements DisplayableComponent {
    private final Fight fight;
    private boolean display = true;

    // Composants graphiques
    private final PlayerStats playerOneStats;
    private final PlayerStats playerTwoStats;
    private final TChoices gameActions;
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;

    public FightView(Fight fight) {
        super(0, 0);
        this.fight = fight;

        // Configuration du header
        TPanel header = new TPanel(0, 1);
        TLabel title = new TLabel("Round n°" + fight.getRound());
        header.getComponents().add(title);
        this.setHeader(header);

        // Configuration du contentPane
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);
        this.getContentPane().setRenderingMainPadding(true);

        // Panel gauche - Stats Joueur 1
        this.leftPanel = new TPanel(0, 0);
        this.playerOneStats = new PlayerStats(fight.getPlayerOne(), true);
        leftPanel.getComponents().add(playerOneStats);

        // Panel central - Actions du jeu
        this.centerPanel = new TPanel(0, 0);
        this.gameActions = new TChoices(Orientation.VERTICAL, 1);
        updateGameActions();
        centerPanel.getComponents().add(gameActions);

        // Panel droit - Stats Joueur 2
        this.rightPanel = new TPanel(0, 0);
        this.playerTwoStats = new PlayerStats(fight.getPlayerTwo(), true);
        rightPanel.getComponents().add(playerTwoStats);

        // Ajout des panels au contentPane
        this.getContentPane().getComponents().add(leftPanel);
        this.getContentPane().getComponents().add(centerPanel);
        this.getContentPane().getComponents().add(rightPanel);
    }

    private void updateGameActions() {
        gameActions.removeAll();
        gameActions.autoResize();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        super.onKeyPressed(event);
        gameActions.onKeyPressed(event);
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
        leftPanel.setLength(contentWidth / 3);
        centerPanel.setLength(contentWidth / 3);
        rightPanel.setLength(contentWidth / 3);
        gameActions.setLength(contentWidth / 3);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        int contentHeight = height - 2;
        leftPanel.setHeight(contentHeight);
        centerPanel.setHeight(contentHeight);
        rightPanel.setHeight(contentHeight);
    }

    public Fight getFight() {
        return fight;
    }

    public void attack() {

    }

    public void updateMenuButtons() {

    }
}
