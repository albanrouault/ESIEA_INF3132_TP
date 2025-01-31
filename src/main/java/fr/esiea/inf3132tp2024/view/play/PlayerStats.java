package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.Player;
import fr.esiea.inf3132tp2024.model.monster.Monster;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

import java.util.*;

public class PlayerStats extends TPanel {
    private final Player player;
    private final TPanel header;
    private final TLabel name;
    private final TPanel monstersPanel;
    private final List<MonsterStats> monsterStats = new LinkedList<>();

    public PlayerStats(Player player) {
        super(HorizontalAlignment.CENTER, Orientation.VERTICAL, 2);
        this.player = player;

        // Header avec nom du joueur
        this.name = new TLabel(player.getName());
        this.name.getColors().addAll(List.of(TColor.BRIGHT_BLUE, TColor.BOLD));

        this.header = new TPanel(0, 1);
        header.getComponents().add(name);

        // Panel pour les monstres
        this.monstersPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);
        refreshMonsters();

        // Assemblage global
        this.getComponents().add(header);
        this.getComponents().add(monstersPanel);

        autoResize();
    }

    private void refreshMonsters() {
        // Nettoyer l'ancien contenu
        monstersPanel.getComponents().clear();
        monsterStats.clear();

        // Créer les composants pour chaque monstre
        List<Monster> orderedMonsters = getOrderedMonsters();
        for (Monster monster : orderedMonsters) {
            MonsterStats stats = new MonsterStats(monster);
            monsterStats.add(stats);
            monstersPanel.getComponents().add(stats);
        }

        // Cas aucun monstre valide
        if (orderedMonsters.isEmpty()) {
            TLabel emptyLabel = new TLabel("Aucun monstre valide !");
            emptyLabel.getColors().add(TColor.RED);
            monstersPanel.getComponents().add(emptyLabel);
        }

        monstersPanel.autoResize();
    }

    private List<Monster> getOrderedMonsters() {
        List<Monster> monsters = new ArrayList<>(Arrays.asList(player.getMonsters()));

        // Trier avec le monstre actif en premier
        monsters.sort(Comparator.comparingInt(m ->
                m == player.getCurrentMonster() ? 0 : 1
        ));

        return monsters;
    }

    public void update() {
        // Mettre à jour tous les MonsterStats
        monsterStats.forEach(MonsterStats::update);

        // Re-ordonner si nécessaire
        List<Monster> currentOrder = getOrderedMonsters();
        boolean needsRefresh = false;

        for (int i = 0; i < currentOrder.size(); i++) {
            if (monsterStats.get(i).getMonster() != currentOrder.get(i)) {
                needsRefresh = true;
                break;
            }
        }

        if (needsRefresh) {
            refreshMonsters();
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

        header.setLength(length);
        monstersPanel.setLength(length);
        for (MonsterStats stats : monsterStats) {
            stats.setLength(length);
        }
    }
}
