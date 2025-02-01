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
import fr.esiea.inf3132tp2024.view.play.ConsumableStats;
import fr.esiea.inf3132tp2024.view.play.PlayerStats;

import java.util.LinkedList;
import java.util.List;

public class ChooseConsumableView extends TFrame implements DisplayableComponent {
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;
    private final PlayerStats playerStats;
    private final TChoices consumableChoices;
    private final List<ConsumableStats> consumablesStats = new LinkedList<>();
    private final Consumable[] consumables;
    private boolean display = true;
    private boolean choiceMade = false;

    public ChooseConsumableView(Player player, Terrain terrain, Monster monster, Consumable[] consumables) {
        super(0, 0, player.getName() + " - " + monster.getName() + " - Choisir un objet");
        this.consumables = consumables;

        // Configuration du contentPane
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);
        this.getContentPane().setRenderingMainPadding(true);

        leftPanel = new TPanel(0, 0);
        centerPanel = new TPanel(0, 0);
        rightPanel = new TPanel(0, 0);

        // Panel de gauche - Stats du joueur
        playerStats = new PlayerStats(player, true);
        leftPanel.getComponents().add(playerStats);

        // Panel central - Choix des consommables
        consumableChoices = new TChoices(Orientation.VERTICAL, 1);
        for (Consumable consumable : consumables) {
            ConsumableButton btn = new ConsumableButton(monster, terrain, consumable);
            consumableChoices.add(btn);
        }
        ReturnButton returnBtn = new ReturnButton();
        consumableChoices.add(returnBtn);
        consumableChoices.autoResize();
        centerPanel.getComponents().add(consumableChoices);

        // Panel de droite - Stats des consommables
        refreshConsumables();

        // Assemblage
        this.getContentPane().getComponents().add(leftPanel);
        this.getContentPane().getComponents().add(centerPanel);
        this.getContentPane().getComponents().add(rightPanel);
    }

    private void refreshConsumables() {
        rightPanel.getComponents().clear();
        consumablesStats.clear();

        for (Consumable consumable : consumables) {
            ConsumableStats stats = new ConsumableStats(consumable);
            consumablesStats.add(stats);
            rightPanel.getComponents().add(stats);
        }

        rightPanel.autoResize();
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

    private class ConsumableButton extends TButton {
        private final Monster monster;
        private final Terrain terrain;
        private final Consumable consumable;

        public ConsumableButton(Monster monster, Terrain terrain, Consumable consumable) {
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
