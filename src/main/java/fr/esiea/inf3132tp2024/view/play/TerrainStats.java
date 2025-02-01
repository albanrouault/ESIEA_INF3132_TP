package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.terrain.Terrain;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class TerrainStats extends TPanel {
    private final Terrain terrain;
    private final TPanel head;
    private final TLabel name;
    private final TLabel stateLabel;

    public TerrainStats(Terrain terrain) {
        super(0, 0, Orientation.VERTICAL, false);

        this.terrain = terrain;

        // Nom et type
        this.name = new TLabel("Terrain");
        this.name.getColors().add(TColor.BOLD);

        // État
        StringBuilder state = new StringBuilder("Etat: ");
        if (terrain.hasEffect()) {
            state.append(terrain.getEffect().getName());
            if (terrain.getEffect().isPermanent()) {
                state.append("\n(permanent)");
            } else {
                state.append("\n(").append(terrain.getEffect().getTurnsLeft()).append(" tours)");
            }
        } else {
            state.append("Normal");
        }
        this.stateLabel = new TLabel("État: " + state);
        this.stateLabel.getColors().add(TColor.YELLOW);
        this.stateLabel.setHeight(2);

        // Assemblage
        this.head = new TPanel(0, 0, Orientation.VERTICAL, true);
        head.getComponents().add(name);
        head.getComponents().add(stateLabel);

        this.getComponents().add(head);
        head.autoResize();
        autoResize();
    }

    public void update() {
        // Mettre à jour les valeurs
        name.setText("Terrain");

        // État
        StringBuilder state = new StringBuilder("Etat: ");
        if (terrain.hasEffect()) {
            state.append(terrain.getEffect().getName());
            if (terrain.getEffect().isPermanent()) {
                state.append("\n(permanent)");
            } else {
                state.append("\n(").append(terrain.getEffect().getTurnsLeft()).append(" tours)");
            }
        } else {
            state.append("Normal");
        }
        stateLabel.setText(state.toString());
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

    public Terrain getTerrain() {
        return terrain;
    }
}
