package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TProgressBar;

public class MonsterStats extends TPanel {
    private Orientation renderOrientation;
    private final Monster monster;
    private final TPanel head;
    private final TLabel name;
    private final TProgressBar hpBar;
    private TPanel item;
    private TLabel itemName;

    public MonsterStats(Monster monster, Orientation orientation) {
        super(0, 0, Orientation.VERTICAL, false);

        this.renderOrientation = orientation;
        this.monster = monster;

        int emptySpace = 0;

        // Nom de l'entité
        this.name = new TLabel(monster.getName());
        this.name.getColors().add(TColor.BOLD);

        // Barre de vie
        this.hpBar = new TProgressBar(0, 1, monster.getMaxHealth(), monster.getMaxHealth(), "%VALUE%/%MAX_VALUE% pv");
        hpBar.getProgressedColors().add(TColor.RED);
        hpBar.getUnProgressedColors().add(TColor.BRIGHT_BLACK);

        // Head (nom + barre de vie)
        this.head = new TPanel(0, 2, Orientation.VERTICAL, false);
        head.getComponents().add(name);
        head.getComponents().add(hpBar);
        this.getComponents().add(head);

        int objectMaxLength = 0;

        emptySpace++;

        if (orientation == Orientation.HORIZONTAL) {
            if (itemName != null && itemName.getLength() < objectMaxLength) {
                itemName.setLength(objectMaxLength);
            }
        }

        if (orientation == Orientation.VERTICAL) {
            for (int i = 0; i < emptySpace; i++) {
                this.getComponents().add(new TLabel(" \n "));
            }
        }

        int height = -1;
        for (TComponent component : this.getComponents()) {
            height += component.getHeight();
            height++;
        }
        this.setHeight(height);
    }

    public void update() {
        name.setText(monster.getName());
        name.setLength(name.getText().length());

        hpBar.setValue(monster.getMaxHealth());
        hpBar.setMaxValue(monster.getMaxHealth());

        int objectMaxLength = 0;

        if (itemName != null) {
            itemName.setText("Aucun");
            itemName.setLength(itemName.getText().length());
            if (itemName.getLength() > objectMaxLength) {
                objectMaxLength = itemName.getLength();
            }
        }

        if (itemName != null && renderOrientation == Orientation.HORIZONTAL && itemName.getLength() < objectMaxLength) {
            itemName.setLength(objectMaxLength);
        }

        if (item != null) {
            item.autoResize();
        }
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
        hpBar.setLength(length - 2);
        if (item != null) {
            item.autoResize();
        }
    }

    @Override
    public Orientation getRenderingOrientation() {
        return renderOrientation;
    }

    @Override
    public void setRenderingOrientation(Orientation renderOrientation) {
        this.renderOrientation = renderOrientation;
    }
}
