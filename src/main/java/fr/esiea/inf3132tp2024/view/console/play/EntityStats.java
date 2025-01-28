package fr.esiea.inf3132tp2024.view.console.play;

import fr.esiea.inf3132tp2024.old.entity.Entity;
import fr.esiea.inf3132tp2024.old.entity.Player;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.console.TColor;
import fr.esiea.inf3132tp2024.view.console.api.component.*;

public class EntityStats extends TPanel {
    private Orientation renderOrientation;
    private final Entity entity;
    private final TPanel head;
    private final TLabel name;
    private final TProgressBar hpBar;
    private TPanel weapon;
    private TLabel weaponName;
    private TPanel item;
    private TLabel itemName;

    public EntityStats(Entity entity, Orientation orientation) {
        super(0, 0, Orientation.VERTICAL, false);

        this.renderOrientation = orientation;
        this.entity = entity;

        int emptySpace = 0;

        // Nom de l'entité
        if (entity instanceof Player) {
            this.name = new TLabel(entity.getName() + " (Vous)");
            this.name.getColors().add(TColor.BRIGHT_BLUE);
        } else {
            this.name = new TLabel(entity.getName());
        }
        this.name.getColors().add(TColor.BOLD);

        // Barre de vie
        this.hpBar = new TProgressBar(0, 1, entity.getHealth(), entity.getMaxHealth(), "%VALUE%/%MAX_VALUE% pv");
        hpBar.getProgressedColors().add(TColor.RED);
        hpBar.getUnProgressedColors().add(TColor.BRIGHT_BLACK);

        // Head (nom + barre de vie)
        this.head = new TPanel(0, 2, Orientation.VERTICAL, false);
        head.getComponents().add(name);
        head.getComponents().add(hpBar);
        this.getComponents().add(head);

        int objectMaxLength = 0;

        // Arme
        TLabel weaponLabel = new TLabel(HorizontalAlignment.RIGHT, "Arme");
        weaponLabel.getColors().add(TColor.BOLD);
        if (orientation == Orientation.HORIZONTAL) {
            weaponLabel.setLength(5);
        }

        // Nom de l'arme
        if (entity.hasWeapon()) {
            this.weaponName = new TLabel(HorizontalAlignment.LEFT, entity.getWeapon().getName());
        } else {
            this.weaponName = new TLabel(HorizontalAlignment.LEFT, "Poings");
        }
        this.weaponName.getColors().add(TColor.YELLOW);

        if (weaponName.getLength() > objectMaxLength) {
            objectMaxLength = weaponName.getLength();
        }

        // Panel de l'arme
        if (orientation == Orientation.VERTICAL) {
            this.weapon = new TPanel(0, 2, Orientation.VERTICAL, false);
        } else {
            this.weapon = new TPanel(HorizontalAlignment.CENTER, 0, 1, Orientation.HORIZONTAL, 1);
        }
        weapon.getComponents().add(weaponLabel);
        weapon.getComponents().add(weaponName);
        this.getComponents().add(weapon);

        if (entity instanceof Player) {
            // Objet
            TLabel itemLabel = new TLabel(HorizontalAlignment.RIGHT, "Objet");
            itemLabel.getColors().add(TColor.BOLD);
            if (orientation == Orientation.HORIZONTAL) {
                itemLabel.setLength(5);
            }

            // Nom de l'objet
            if (entity.hasItem()) {
                this.itemName = new TLabel(HorizontalAlignment.LEFT, entity.getItem().getName());
            } else {
                this.itemName = new TLabel(HorizontalAlignment.LEFT, "Aucun");
            }
            itemName.getColors().add(TColor.GREEN);

            if (itemName.getLength() > objectMaxLength) {
                objectMaxLength = itemName.getLength();
            }

            // Panel de l'objet
            if (orientation == Orientation.VERTICAL) {
                this.item = new TPanel(0, 2, Orientation.VERTICAL, false);
            } else {
                this.item = new TPanel(HorizontalAlignment.CENTER, 0, 1, Orientation.HORIZONTAL, 1);
            }
            item.getComponents().add(itemLabel);
            item.getComponents().add(itemName);
            this.getComponents().add(item);
        } else {
            emptySpace++;
        }

        if (orientation == Orientation.HORIZONTAL) {
            if (weaponName != null && weaponName.getLength() < objectMaxLength) {
                weaponName.setLength(objectMaxLength);
            }

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
        if (!(entity instanceof Player)) {
            name.setText(entity.getName());
            name.setLength(name.getText().length());
        }

        hpBar.setValue(entity.getHealth());
        hpBar.setMaxValue(entity.getMaxHealth());

        int objectMaxLength = 0;

        if (weaponName != null) {
            if (entity.hasWeapon()) {
                weaponName.setText(entity.getWeapon().getName());
            } else {
                weaponName.setText("Poings");
            }
            weaponName.setLength(weaponName.getText().length());
            if (weaponName.getLength() > objectMaxLength) {
                objectMaxLength = weaponName.getLength();
            }
        }

        if (itemName != null) {
            if (entity.hasItem()) {
                itemName.setText(entity.getItem().getName());
            } else {
                itemName.setText("Aucun");
            }
            itemName.setLength(itemName.getText().length());
            if (itemName.getLength() > objectMaxLength) {
                objectMaxLength = itemName.getLength();
            }
        }

        if (weaponName != null && renderOrientation == Orientation.HORIZONTAL && weaponName.getLength() < objectMaxLength) {
            weaponName.setLength(objectMaxLength);
        }

        if (itemName != null && renderOrientation == Orientation.HORIZONTAL && itemName.getLength() < objectMaxLength) {
            itemName.setLength(objectMaxLength);
        }

        if (weapon != null) {
            weapon.autoResize();
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
        if (weapon != null) {
            weapon.autoResize();
        }
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
