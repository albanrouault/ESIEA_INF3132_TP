package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TProgressBar;

public class MonsterStats extends TPanel {
    private final Monster monster;
    private final TPanel head;
    private final TLabel name;
    private final TLabel typeLabel;
    private final TLabel stateLabel;
    private final TProgressBar hpBar;
    private final TPanel statsPanel;

    public MonsterStats(Monster monster) {
        super(0, 0, Orientation.VERTICAL, false);

        this.monster = monster;

        // Nom et type
        this.name = new TLabel(monster.getName());
        this.name.getColors().add(TColor.BOLD);

        this.typeLabel = new TLabel("Type: " + monster.getType().getName());
        this.typeLabel.getColors().add(TColor.BRIGHT_BLACK);

        // État
        StringBuilder state = new StringBuilder("Etat: ");
        if (monster.hasState()) {
            state.append(monster.getState().getName());
            if (monster.getState().isPermanent()) {
                state.append(" (permanent)");
            } else {
                state.append(" (").append(monster.getState().getTurnsLeft()).append(" tours)");
            }
        } else {
            state.append("Normal");
        }
        this.stateLabel = new TLabel("État: " + state);
        this.stateLabel.getColors().add(TColor.YELLOW);

        // Barre de vie
        this.hpBar = new TProgressBar(0, 1, monster.getHealth(), monster.getMaxHealth(), "%VALUE%/%MAX_VALUE% PV");
        hpBar.getProgressedColors().add(TColor.RED);
        hpBar.getUnProgressedColors().add(TColor.BRIGHT_BLACK);

        // Stats (Attaque/Vitesse/Défense)
        this.statsPanel = new TPanel(0, 1, Orientation.HORIZONTAL, true);
        statsPanel.getComponents().add(createStatLabel("ATQ", monster.getAttack(), TColor.RED));
        statsPanel.getComponents().add(new TLabel("  "));
        statsPanel.getComponents().add(createStatLabel("VIT", monster.getSpeed(), TColor.GREEN));
        statsPanel.getComponents().add(new TLabel("  "));
        statsPanel.getComponents().add(createStatLabel("DEF", monster.getDefense(), TColor.BLUE));
        statsPanel.autoResize();

        // Assemblage
        this.head = new TPanel(0, 0, Orientation.VERTICAL, true);
        head.getComponents().add(name);
        head.getComponents().add(typeLabel);
        head.getComponents().add(hpBar);
        head.getComponents().add(stateLabel);
        head.getComponents().add(statsPanel);

        this.getComponents().add(head);
        head.autoResize();
        autoResize();
    }

    private TLabel createStatLabel(String title, int value, TColor color) {
        TLabel label = new TLabel(title + ": " + value);
        label.getColors().add(color);
        return label;
    }

    public void update() {
        // Mettre à jour les valeurs
        name.setText(monster.getName());
        typeLabel.setText("Type: " + monster.getType().getName());
        hpBar.setValue(monster.getHealth());
        hpBar.setMaxValue(monster.getMaxHealth());

        // État
        StringBuilder state = new StringBuilder("Etat: ");
        if (monster.hasState()) {
            state.append(monster.getState().getName());
            if (monster.getState().isPermanent()) {
                state.append(" (permanent)");
            } else {
                state.append(" (").append(monster.getState().getTurnsLeft()).append(" tours)");
            }
        } else {
            state.append("Normal");
        }
        stateLabel.setText(state.toString());

        // Stats
        ((TLabel) statsPanel.getComponents().get(0)).setText("ATQ: " + monster.getAttack());
        ((TLabel) statsPanel.getComponents().get(2)).setText("VIT: " + monster.getSpeed());
        ((TLabel) statsPanel.getComponents().get(4)).setText("DEF: " + monster.getDefense());
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
    }

    public Monster getMonster() {
        return monster;
    }
}
