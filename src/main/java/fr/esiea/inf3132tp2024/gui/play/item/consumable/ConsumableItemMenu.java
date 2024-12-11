package fr.esiea.inf3132tp2024.gui.play.item.consumable;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.entity.Entity;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CChoices;
import fr.esiea.inf3132tp2024.gui.component.CFrame;
import fr.esiea.inf3132tp2024.gui.component.CLabel;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.item.Item;
import fr.esiea.inf3132tp2024.item.consumable.Consumable;

import java.util.List;

public class ConsumableItemMenu extends CFrame implements DisplayableComponent {
    private boolean display = true;

    public ConsumableItemMenu(App app, Consumable consumable, List<Entity> entities) {
        super(0, 0, "Utiliser " + ((Item) consumable).getName());

        Item item = (Item) consumable;

        CLabel label = new CLabel("Sur quelle entité voulez-vous utiliser " + item.getName() + " ?");
        this.getContentPane().getComponents().add(label);

        CChoices choices = new CChoices(app, 1);
        for (Entity entity : entities) {
            choices.add(new ConsumeItemButton(app, this, item, entity));
        }

        choices.add(new QuitComponentButton(app, this, "Retour"));

        this.getContentPane().getComponents().add(choices);
    }

    @Override
    public boolean isInLoopingMode() {
        return display;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    public void stopLoopingMode() {
        display = false;
    }
}
