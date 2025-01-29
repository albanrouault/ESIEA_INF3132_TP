package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.Item;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.AttackPotion;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.HealPotion;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.weapon.Weapon;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.wearable.Wearable;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class ItemStats extends TPanel {
    private final String title;
    private final Item item;

    public ItemStats(Item item, int length) {
        this(item, null, length);
    }

    public ItemStats(Item item, String title, int length) {
        super(HorizontalAlignment.CENTER, length, 0, Orientation.VERTICAL, 1);

        this.title = title;
        this.item = item;

        update();
    }

    public void update() {
        this.getComponents().clear();

        int panelMaxLength = 0;

        // Titre
        if (title != null) {
            TLabel titleLabel = new TLabel(title);
            if (title.contains("(Vous)")) {
                titleLabel.getColors().add(TColor.BRIGHT_BLUE);
            }
            titleLabel.getColors().add(TColor.BOLD);
            this.getComponents().add(titleLabel);
            panelMaxLength = titleLabel.getLength();
        }

        // Nom
        TPanel namePanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
        TLabel nameLabel = new TLabel("Nom");
        nameLabel.getColors().add(TColor.BOLD);
        TLabel nameValue = new TLabel(item.getName());
        nameValue.getColors().add(TColor.GREEN);
        namePanel.getComponents().add(nameLabel);
        namePanel.getComponents().add(nameValue);
        namePanel.autoResize();
        if (namePanel.getLength() > panelMaxLength) {
            panelMaxLength = namePanel.getLength();
        }
        this.getComponents().add(namePanel);

        // Description
        TPanel descriptionPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
        TLabel descriptionLabel = new TLabel("Description");
        descriptionLabel.getColors().add(TColor.BOLD);
        TLabel descriptionValue = new TLabel(item.getDescription(), this.getLength());
        descriptionValue.getColors().add(TColor.GREEN);
        descriptionPanel.getComponents().add(descriptionLabel);
        descriptionPanel.getComponents().add(descriptionValue);
        descriptionPanel.autoResize();
        if (descriptionPanel.getLength() > panelMaxLength) {
            panelMaxLength = descriptionPanel.getLength();
        }
        this.getComponents().add(descriptionPanel);

        if (item instanceof Weapon weapon) {
            // Force
            TPanel strengthPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel strengthLabel = new TLabel("Force");
            strengthLabel.getColors().add(TColor.BOLD);
            TLabel strengthValue = new TLabel(String.valueOf(weapon.getStrength()));
            strengthValue.getColors().add(TColor.GREEN);
            strengthPanel.getComponents().add(strengthLabel);
            strengthPanel.getComponents().add(strengthValue);
            strengthPanel.autoResize();
            if (strengthPanel.getLength() > panelMaxLength) {
                panelMaxLength = strengthPanel.getLength();
            }
            this.getComponents().add(strengthPanel);

            // Précision
            TPanel accuracyPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel accuracyLabel = new TLabel("Précision");
            accuracyLabel.getColors().add(TColor.BOLD);
            TLabel accuracyValue = new TLabel(String.valueOf(weapon.getAccuracy()));
            accuracyValue.getColors().add(TColor.GREEN);
            accuracyPanel.getComponents().add(accuracyLabel);
            accuracyPanel.getComponents().add(accuracyValue);
            accuracyPanel.autoResize();
            if (accuracyPanel.getLength() > panelMaxLength) {
                panelMaxLength = accuracyPanel.getLength();
            }
            this.getComponents().add(accuracyPanel);

            // Rapidité
            TPanel speedPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel speedLabel = new TLabel("Rapidité");
            speedLabel.getColors().add(TColor.BOLD);
            TLabel speedValue = new TLabel(String.valueOf(weapon.getSpeed()));
            speedValue.getColors().add(TColor.GREEN);
            speedPanel.getComponents().add(speedLabel);
            speedPanel.getComponents().add(speedValue);
            speedPanel.autoResize();
            if (speedPanel.getLength() > panelMaxLength) {
                panelMaxLength = speedPanel.getLength();
            }
            this.getComponents().add(speedPanel);

            strengthPanel.setLength(panelMaxLength);
            accuracyPanel.setLength(panelMaxLength);
            speedPanel.setLength(panelMaxLength);
        } else if (item instanceof Wearable wearable) {
            // Force
            TPanel strengthPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel strengthLabel = new TLabel("Force");
            strengthLabel.getColors().add(TColor.BOLD);
            TLabel strengthValue = new TLabel(String.valueOf(wearable.getStrength()));
            strengthValue.getColors().add(TColor.GREEN);
            strengthPanel.getComponents().add(strengthLabel);
            strengthPanel.getComponents().add(strengthValue);
            strengthPanel.autoResize();
            if (strengthPanel.getLength() > panelMaxLength) {
                panelMaxLength = strengthPanel.getLength();
            }
            this.getComponents().add(strengthPanel);

            // Précision
            TPanel accuracyPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel accuracyLabel = new TLabel("Précision");
            accuracyLabel.getColors().add(TColor.BOLD);
            TLabel accuracyValue = new TLabel(String.valueOf(wearable.getAccuracy()));
            accuracyValue.getColors().add(TColor.GREEN);
            accuracyPanel.getComponents().add(accuracyLabel);
            accuracyPanel.getComponents().add(accuracyValue);
            accuracyPanel.autoResize();
            if (accuracyPanel.getLength() > panelMaxLength) {
                panelMaxLength = accuracyPanel.getLength();
            }
            this.getComponents().add(accuracyPanel);

            // Rapidité
            TPanel speedPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel speedLabel = new TLabel("Rapidité");
            speedLabel.getColors().add(TColor.BOLD);
            TLabel speedValue = new TLabel(String.valueOf(wearable.getSpeed()));
            speedValue.getColors().add(TColor.GREEN);
            speedPanel.getComponents().add(speedLabel);
            speedPanel.getComponents().add(speedValue);
            speedPanel.autoResize();
            if (speedPanel.getLength() > panelMaxLength) {
                panelMaxLength = speedPanel.getLength();
            }
            this.getComponents().add(speedPanel);

            strengthPanel.setLength(panelMaxLength);
            accuracyPanel.setLength(panelMaxLength);
            speedPanel.setLength(panelMaxLength);
        } else if (item instanceof AttackPotion attackPotion) {
            // Dégâts
            TPanel damagePanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel damageLabel = new TLabel("Dégâts");
            damageLabel.getColors().add(TColor.BOLD);
            TLabel damageValue = new TLabel(String.valueOf(attackPotion.getDamage()));
            damageValue.getColors().add(TColor.GREEN);
            damagePanel.getComponents().add(damageLabel);
            damagePanel.getComponents().add(damageValue);
            damagePanel.autoResize();
            if (damagePanel.getLength() > panelMaxLength) {
                panelMaxLength = damagePanel.getLength();
            }
            this.getComponents().add(damagePanel);

            damagePanel.setLength(panelMaxLength);
        } else if (item instanceof HealPotion healPotion) {
            // Soins
            TPanel healPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
            TLabel healLabel = new TLabel("Soins");
            healLabel.getColors().add(TColor.BOLD);
            TLabel healValue = new TLabel(String.valueOf(healPotion.getHeal()));
            healValue.getColors().add(TColor.GREEN);
            healPanel.getComponents().add(healLabel);
            healPanel.getComponents().add(healValue);
            healPanel.autoResize();
            if (healPanel.getLength() > panelMaxLength) {
                panelMaxLength = healPanel.getLength();
            }
            this.getComponents().add(healPanel);

            healPanel.setLength(panelMaxLength);
        }

        nameLabel.setLength(panelMaxLength);
        descriptionLabel.setLength(panelMaxLength);

        int length = this.getLength();
        this.autoResize();
        this.setLength(length);
    }
}
