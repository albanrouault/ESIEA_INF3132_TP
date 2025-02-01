package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.consumable.Consumable;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class ConsumableStats extends TPanel {
    private final Consumable consumable;
    private final TPanel head;
    private final TLabel name;
    private final TLabel descriptionLabel;

    public ConsumableStats(Consumable consumable) {
        super(0, 0, Orientation.VERTICAL, false);
        this.consumable = consumable;

        // Nom de l'objet en gras
        this.name = new TLabel(consumable.getName());
        name.getColors().add(TColor.BOLD);

        // Description de l'objet
        this.descriptionLabel = new TLabel(consumable.getDescription());
        descriptionLabel.getColors().add(TColor.BRIGHT_BLACK);

        // Assemblage des composants
        this.head = new TPanel(0, 0, Orientation.VERTICAL, true);
        head.getComponents().add(name);
        head.getComponents().add(descriptionLabel);

        this.getComponents().add(head);
        head.autoResize();
        autoResize();
    }

    /**
     * Met à jour les informations affichées
     */
    public void update() {
        name.setText(consumable.getName());
        descriptionLabel.setText(consumable.getDescription());
    }

    @Override
    public String[] render() {
        update();
        return super.render();
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        head.setLength(length);
    }

    /**
     * @return le consommable associé à ces statistiques
     */
    public Consumable getConsumable() {
        return consumable;
    }
}
