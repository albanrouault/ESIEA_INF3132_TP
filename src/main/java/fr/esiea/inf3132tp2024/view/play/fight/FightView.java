package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.common.component.SelectableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;
import fr.esiea.inf3132tp2024.view.play.TerrainStats;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class FightView extends TFrame implements DisplayableComponent {
    private final Fight fight;
    private boolean display = true;

    // Composants graphiques
    private final PlayerStats playerOneStats;
    private final PlayerStats playerTwoStats;
    private final TerrainStats terrainStats;
    private final TChoices gameActions;
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;

    private final HashMap<Player, List<SelectableComponent>> playerButtons = new HashMap<>();

    public FightView(Fight fight) {
        super(0, 0);

        playerButtons.put(fight.getPlayerOne(), new LinkedList<>());
        playerButtons.put(fight.getPlayerTwo(), new LinkedList<>());

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

        // Panel central - Stats terrain x Actions du jeu
        this.centerPanel = new TPanel(0, 0);
        this.terrainStats = new TerrainStats(fight.getTerrain());
        centerPanel.getComponents().add(terrainStats);
        this.gameActions = new TChoices(Orientation.VERTICAL, 1);
        SelectableComponent attackButtonPlayerOne = new AttackButton(this, fight, fight.getPlayerOne(), fight.getPlayerOne().getCurrentMonster(), fight.getPlayerTwo().getCurrentMonster());
        gameActions.add(attackButtonPlayerOne);
        playerButtons.get(fight.getPlayerOne()).add(attackButtonPlayerOne);
        SelectableComponent attackButtonPlayerTwo = new AttackButton(this, fight, fight.getPlayerTwo(), fight.getPlayerTwo().getCurrentMonster(), fight.getPlayerOne().getCurrentMonster());
        gameActions.add(attackButtonPlayerTwo);
        playerButtons.get(fight.getPlayerTwo()).add(attackButtonPlayerTwo);
        SelectableComponent changeMonsterButtonPlayerOne = new ChangeMonsterButton(this, fight, fight.getPlayerOne());
        gameActions.add(changeMonsterButtonPlayerOne);
        playerButtons.get(fight.getPlayerOne()).add(changeMonsterButtonPlayerOne);
        SelectableComponent changeMonsterButtonPlayerTwo = new ChangeMonsterButton(this, fight, fight.getPlayerTwo());
        gameActions.add(changeMonsterButtonPlayerTwo);
        playerButtons.get(fight.getPlayerTwo()).add(changeMonsterButtonPlayerTwo);
        SelectableComponent useItemButtonPlayerOne = new UseItemButton(this, fight, fight.getPlayerOne(), fight.getPlayerOne().getCurrentMonster());
        gameActions.add(useItemButtonPlayerOne);
        playerButtons.get(fight.getPlayerOne()).add(useItemButtonPlayerOne);
        SelectableComponent useItemButtonPlayerTwo = new UseItemButton(this, fight, fight.getPlayerTwo(), fight.getPlayerTwo().getCurrentMonster());
        gameActions.add(useItemButtonPlayerTwo);
        playerButtons.get(fight.getPlayerTwo()).add(useItemButtonPlayerTwo);
        gameActions.add(new EndFightButton(this));
        //gameActions.autoResize();
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
        playerOneStats.setLength((int) (contentWidth * 0.4));
        centerPanel.setLength((int) (contentWidth * 0.2));
        gameActions.setLength((int) (contentWidth * 0.2));
        rightPanel.setLength((int) (contentWidth * 0.4));
        playerTwoStats.setLength((int) (contentWidth * 0.4));
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        int contentHeight = height - 4;
        leftPanel.setHeight(contentHeight);
        centerPanel.setHeight(contentHeight);
        rightPanel.setHeight(contentHeight);
    }

    public Fight getFight() {
        return fight;
    }

    public void removeButtons(Player player) {
        List<SelectableComponent> buttons = playerButtons.get(player);
        if (buttons != null) {
            for (SelectableComponent button : buttons) {
                gameActions.remove(button);
            }
        }
        gameActions.autoResize();
        setLength(getLength());
    }
}
