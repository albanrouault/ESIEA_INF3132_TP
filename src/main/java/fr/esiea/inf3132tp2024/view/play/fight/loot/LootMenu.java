package fr.esiea.inf3132tp2024.view.play.fight.loot;

import fr.esiea.inf3132tp2024.model.entity.Entity;
import fr.esiea.inf3132tp2024.model.entity.Player;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.SelectableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.play.ItemStats;

import java.util.LinkedList;
import java.util.List;

public class LootMenu extends TFrame implements DisplayableComponent {
    private final Player player;
    private final Entity entity;
    private final TPanel leftPanel;
    private final TPanel centerPanel;
    private final TPanel rightPanel;
    private final TChoices buttons;
    private final TQuitComponentButton leaveButton;

    private boolean display = true;

    public LootMenu(Player player, Entity enemy) {
        super(0, 0, "Butin de " + enemy.getName());

        this.player = player;
        this.entity = enemy;

        // Contenu de la fenêtre
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);
        this.getContentPane().setRenderingMainPadding(false);

        // Panneaux de gauche à droite
        this.leftPanel = new TPanel(0, 0);
        this.centerPanel = new TPanel(0, 0);
        this.rightPanel = new TPanel(0, 0);
        this.getContentPane().getComponents().add(this.leftPanel);
        this.getContentPane().getComponents().add(this.centerPanel);
        this.getContentPane().getComponents().add(this.rightPanel);

        // Panneau du centre
        // Boutons
        this.buttons = new TChoices(1);
        // Bouton weapon
        if (enemy.hasWeapon()) {
            if (player.hasWeapon()) {
                buttons.add(new ReplaceWeaponButton(player, enemy));
            } else {
                buttons.add(new TakeWeaponButton(player, enemy, this));
            }
        }
        // Bouton item
        if (enemy.hasItem()) {
            if (player.hasItem()) {
                buttons.add(new ReplaceItemButton(this, player, enemy));
            } else {
                buttons.add(new TakeItemButton(player, enemy, this));
            }
        }
        // Bouton utiliser item
        if (player.hasItem() && player.getConsumable() instanceof Consumable consumable) {
            List<Entity> entities = new LinkedList<>();
            entities.add(player);
            buttons.add(new UseItemButton(this, consumable, entities));
        }
        // Bouton quitter
        this.leaveButton = new TQuitComponentButton(this, "Quitter");
        buttons.add(leaveButton);

        centerPanel.getComponents().add(buttons);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public String[] render() {
        update();

        return super.render();
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        this.centerPanel.setLength(20);
        int statsLength = this.getContentPane().getLength() - this.centerPanel.getLength() - 2;
        this.leftPanel.setLength(statsLength / 2);
        this.rightPanel.setLength(statsLength / 2);
        for (TComponent component : this.leftPanel.getComponents()) {
            component.setLength(statsLength / 2);
            if (component instanceof ItemStats itemStats) {
                itemStats.update();
            }
        }
        for (TComponent component : this.rightPanel.getComponents()) {
            component.setLength(statsLength / 2);
            if (component instanceof ItemStats itemStats) {
                itemStats.update();
            }
        }
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        this.leftPanel.setHeight(this.getContentPane().getHeight());
        this.centerPanel.setHeight(this.getContentPane().getHeight());
        this.rightPanel.setHeight(this.getContentPane().getHeight());
    }

    @SuppressWarnings("ConstantConditions")
    private void update() {
        // On retire tous les composants des panneaux de gauche et de droite
        this.leftPanel.getComponents().clear();
        this.rightPanel.getComponents().clear();

        SelectableComponent selectableComponent = buttons.getSelectedComponent();
        // Si on a sélectionné un bouton de prise ou remplacement d'item
        if (!(selectableComponent instanceof ReplaceWeaponButton
                || selectableComponent instanceof TakeWeaponButton
                || selectableComponent instanceof ReplaceItemButton
                || selectableComponent instanceof TakeItemButton)) {
            return;
        }

        // On ajoute les bonnes stats en fonction du bouton sélectionné
        TComponent selectedComponent = (TComponent) selectableComponent;
        // 24 = 20 (boutons) + 2 (Cadre frame) + 2 (Séparateur entre menu stats)
        int statsLength = this.getContentPane().getLength() - this.buttons.getLength() - 2;
        if (selectedComponent instanceof ReplaceWeaponButton replaceWeaponButton) {
            Player player = replaceWeaponButton.getPlayer();
            ItemStats playerWeaponStats = new ItemStats(player.getWeapon(), player.getName() + " (Vous)", statsLength / 2);
            this.leftPanel.getComponents().add(playerWeaponStats);

            Entity enemy = replaceWeaponButton.getEnemy();
            ItemStats enemyWeaponStats = new ItemStats(enemy.getWeapon(), enemy.getName(), statsLength / 2);
            this.rightPanel.getComponents().add(enemyWeaponStats);
        } else if (selectedComponent instanceof TakeWeaponButton takeWeaponButton) {
            Entity enemy = takeWeaponButton.getEnemy();
            ItemStats enemyWeaponStats = new ItemStats(enemy.getWeapon(), enemy.getName(), statsLength / 2);
            this.rightPanel.getComponents().add(enemyWeaponStats);
        } else if (selectedComponent instanceof ReplaceItemButton replaceItemButton) {
            Player player = replaceItemButton.getPlayer();
            ItemStats playerItemStats = new ItemStats(player.getConsumable(), player.getName() + " (Vous)", statsLength / 2);
            this.leftPanel.getComponents().add(playerItemStats);

            Entity enemy = replaceItemButton.getEnemy();
            ItemStats enemyItemStats = new ItemStats(enemy.getItem(), enemy.getName(), statsLength / 2);
            this.rightPanel.getComponents().add(enemyItemStats);
        } else if (selectedComponent instanceof TakeItemButton takeItemButton) {
            Entity enemy = takeItemButton.getEnemy();
            ItemStats enemyItemStats = new ItemStats(enemy.getItem(), enemy.getName(), statsLength / 2);
            this.rightPanel.getComponents().add(enemyItemStats);
        }
    }

    public void stopLoopingMode() {
        display = false;
    }

    public TChoices getButtons() {
        return buttons;
    }

    public TQuitComponentButton getLeaveButton() {
        return leaveButton;
    }

    public Player getPlayer() {
        return player;
    }

    public Entity getEntity() {
        return entity;
    }
}
