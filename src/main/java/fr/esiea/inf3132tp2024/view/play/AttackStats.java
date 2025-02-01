package fr.esiea.inf3132tp2024.view.play;

import fr.esiea.inf3132tp2024.model.attack.Attack;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;

public class AttackStats extends TPanel {
    private final Attack attack;
    private final TPanel head;
    private final TLabel name;
    private final TLabel typeLabel;
    private final TLabel damageLabel;
    private final TLabel accuracyLabel;
    private final TLabel usesLabel;

    public AttackStats(Attack attack) {
        super(0, 0, Orientation.VERTICAL, false);
        this.attack = attack;

        // Nom de l'attaque en gras
        this.name = new TLabel(attack.getName());
        name.getColors().add(TColor.BOLD);

        // Type de l'attaque
        this.typeLabel = new TLabel("Type: " + attack.getType().getName());
        typeLabel.getColors().add(TColor.BRIGHT_BLACK);

        // Dégâts
        this.damageLabel = new TLabel("Dégâts: " + attack.getDamage());
        damageLabel.getColors().add(TColor.RED);

        // Précision formatée en pourcentage
        float precision = attack.getChanceOfSuccess() * 100;
        this.accuracyLabel = new TLabel(String.format("Précision: %.1f%%", precision));
        accuracyLabel.getColors().add(TColor.GREEN);

        // Utilisations restantes
        this.usesLabel = new TLabel("Utilisations: " + attack.getNbUses());
        usesLabel.getColors().add(TColor.BLUE);

        // Assemblage des composants
        this.head = new TPanel(0, 0, Orientation.VERTICAL, true);
        head.getComponents().add(name);
        head.getComponents().add(typeLabel);
        head.getComponents().add(damageLabel);
        head.getComponents().add(accuracyLabel);
        head.getComponents().add(usesLabel);

        this.getComponents().add(head);
        head.autoResize();
        autoResize();
    }

    /**
     * Met à jour les informations affichées
     */
    public void update() {
        name.setText(attack.getName());
        typeLabel.setText("Type: " + attack.getType().getName());
        damageLabel.setText("Dégâts: " + attack.getDamage());
        float precision = attack.getChanceOfSuccess() * 100;
        accuracyLabel.setText(String.format("Précision: %.1f%%", precision));
        usesLabel.setText("Utilisations: " + attack.getNbUses());
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
     * @return l'attaque associée à ces statistiques
     */
    public Attack getAttack() {
        return attack;
    }
}
