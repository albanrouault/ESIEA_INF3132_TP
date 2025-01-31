package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.model.consumable.medicine.Medicine;
import fr.esiea.inf3132tp2024.model.consumable.potion.Potion;
import fr.esiea.inf3132tp2024.model.consumable.potion.power.PowerPotion;
import fr.esiea.inf3132tp2024.model.consumable.potion.regen.RegenPotion;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class ConsumableStats extends TPanel {
    private final String title;
    private final Consumable consumable;

    public ConsumableStats(Consumable consumable, int length) {
        this(consumable, null, length);
    }

    public ConsumableStats(Consumable consumable, String title, int length) {
        super(HorizontalAlignment.CENTER, length, 0, Orientation.VERTICAL, 1);

        this.title = title;
        this.consumable = consumable;

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
        TLabel nameValue = new TLabel(consumable.getName());
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
        TLabel descriptionValue = new TLabel(consumable.getDescription(), this.getLength());
        descriptionValue.getColors().add(TColor.GREEN);
        descriptionPanel.getComponents().add(descriptionLabel);
        descriptionPanel.getComponents().add(descriptionValue);
        descriptionPanel.autoResize();
        if (descriptionPanel.getLength() > panelMaxLength) {
            panelMaxLength = descriptionPanel.getLength();
        }
        this.getComponents().add(descriptionPanel);

        // CATÉGORIE : Médicament
        if (consumable instanceof Medicine medicine) {

            // CATÉGORIE : Potion
        } else if (consumable instanceof Potion potion) {
            // POTION : Boost de puissance
            if (potion instanceof PowerPotion powerPotion) {
                TPanel strengthPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
                TLabel strengthLabel = new TLabel("Boost d'attaque");
                strengthLabel.getColors().add(TColor.BOLD);
                TLabel strengthValue = new TLabel(String.valueOf(powerPotion.getAttackBoost()));
                strengthValue.getColors().add(TColor.GREEN);
                strengthPanel.getComponents().add(strengthLabel);
                strengthPanel.getComponents().add(strengthValue);
                strengthPanel.autoResize();
                if (strengthPanel.getLength() > panelMaxLength) {
                    panelMaxLength = strengthPanel.getLength();
                }
                this.getComponents().add(strengthPanel);

                strengthPanel.setLength(panelMaxLength);
            } else if (consumable instanceof RegenPotion regenPotion) {
                // Soins
                TPanel healPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 0);
                TLabel healLabel = new TLabel("Régénération");
                healLabel.getColors().add(TColor.BOLD);
                TLabel healValue = new TLabel(String.valueOf(regenPotion.getRegenAmount()));
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
        }

        nameLabel.setLength(panelMaxLength);
        descriptionLabel.setLength(panelMaxLength);

        int length = this.getLength();
        this.autoResize();
        this.setLength(length);
    }
}
