package fr.esiea.inf3132tp2024.view.play.fight;

import fr.esiea.inf3132tp2024.model.audio.Music;
import fr.esiea.inf3132tp2024.model.fight.Fight;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.play.MonsterStats;

import java.util.LinkedList;
import java.util.List;

public class FightView extends TFrame implements DisplayableComponent {
    private final Fight fight;
    private boolean display = true;
    private boolean over = false;

    // Éléments graphiques
    private final TPanel leftPanel;
    private final MonsterStats playerStats;
    private final TPanel centerPanel;
    private final TChoices menu;
    private final TPanel rightPanel;
    private final MonsterStats enemyStats;
    private final TLabel logs;

    public FightView(Fight fight) {
        super(0, 0, "Combat");

        this.fight = fight;

        this.getContentPane().setRenderingMainPadding(false);
        this.getContentPane().setRenderingOrientation(Orientation.HORIZONTAL);

        this.leftPanel = new TPanel(0, 0);

        this.playerStats = new MonsterStats(fight.getMonsterPlayerOne());
        leftPanel.getComponents().add(playerStats);

        this.getContentPane().getComponents().add(leftPanel);

        this.centerPanel = new TPanel(20, 0);

        this.menu = new TChoices(1);
        updateMenuButtons();

        centerPanel.getComponents().add(menu);
        this.getContentPane().getComponents().add(centerPanel);

        this.rightPanel = new TPanel(0, 0);
        this.enemyStats = new MonsterStats(fight.getMonsterPlayerTwo());
        rightPanel.getComponents().add(enemyStats);
        this.getContentPane().getComponents().add(rightPanel);

        TPanel footer = new TPanel(0, 0, Orientation.HORIZONTAL, false);

        this.logs = new TLabel("");
        logs.setHeight(0);
        footer.getComponents().add(logs);

        this.setFooter(footer);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    public boolean isOver() {
        return over;
    }

    @Override
    public void stopLoopingMode() {
        display = false;
    }

    public void updateMenuButtons() {
        menu.removeAll();
        menu.add(new AttackButton(this));
        menu.setLength(20);
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);
        int statsLength = this.getContentPane().getLength() - this.menu.getLength() - 2;
        this.leftPanel.setLength(statsLength / 2);
        this.playerStats.setLength(statsLength / 2);
        this.rightPanel.setLength(statsLength / 2);
        this.enemyStats.setLength(statsLength / 2);
        this.logs.setLength(this.getContentPane().getLength());
    }

    @Override
    public void setHeight(int height) {
        this.getFooter().setHeight(this.logs.getHeight());
        super.setHeight(height);
        this.leftPanel.setHeight(this.getContentPane().getHeight());
        this.centerPanel.setHeight(this.getContentPane().getHeight());
        this.rightPanel.setHeight(this.getContentPane().getHeight());
    }

    public void attack() {
        List<String> logs = new LinkedList<>();

        // On affiche les logs du combat
        this.logs.setHeight(logs.size());
        StringBuilder text = new StringBuilder();
        for (String log : logs) {
            text.append("\n").append(log);
        }
        this.logs.setText(text.toString().replaceFirst("\n", ""));
        this.setHeight(this.getHeight());

        // On actualise les stats
        playerStats.update();
        enemyStats.update();
    }
}
