package fr.esiea.inf3132tp2024.gui.play.escape;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.game.Game;
import fr.esiea.inf3132tp2024.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.component.CChoices;
import fr.esiea.inf3132tp2024.gui.component.CFrame;
import fr.esiea.inf3132tp2024.gui.component.CLabel;
import fr.esiea.inf3132tp2024.gui.component.CPanel;
import fr.esiea.inf3132tp2024.gui.main.menu.information.InfoButton;
import fr.esiea.inf3132tp2024.item.consumable.Consumable;

public class EscapeMenu extends CFrame implements DisplayableComponent {
    private boolean display = true;

    public EscapeMenu(App app, Game game) {
        super(0, 0, "Pause");

        CChoices choices = new CChoices(app, 1);
        choices.add(new QuitComponentButton(app, this, "Reprendre la partie"));
        if (game.getPlayer().hasItem() && game.getPlayer().getItem() instanceof Consumable) {
            choices.add(new UseItemButton(app, this, game.getPlayer()));
        }
        choices.add(new InfoButton(app));
        choices.add(new CheatButton(app, game, this));
        choices.add(new SettingsButton(app, game));
        choices.add(new QuitGameButton(app, this));

        this.getContentPane().getComponents().add(choices);

        CPanel footer = new CPanel(0, 1);
        CLabel seedLabel = new CLabel("Seed : " + game.getSeed());
        footer.getComponents().add(seedLabel);
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

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (event.getKey() == 27) {
            stopLoopingMode();
            return;
        }

        super.onKeyPressed(event);
    }

    public void stopLoopingMode() {
        display = false;
    }
}
