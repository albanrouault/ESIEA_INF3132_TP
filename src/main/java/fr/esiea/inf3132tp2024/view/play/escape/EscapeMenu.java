package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.model.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.controller.game.Game;
import fr.esiea.inf3132tp2024.olddeprecatedtodelete.item.consumable.Consumable;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.main.menu.information.InfoButton;

public class EscapeMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public EscapeMenu(Game game) {
        super(0, 0, "Pause");

        TChoices choices = new TChoices(1);
        choices.add(new TQuitComponentButton(this, "Reprendre la partie"));
        if (game.getPlayer().hasItem() && game.getPlayer().getConsumable() instanceof Consumable) {
            choices.add(new UseItemButton(this, game.getPlayer()));
        }
        choices.add(new InfoButton());
        choices.add(new CheatButton(game, this));
        choices.add(new SettingsButton(game));
        choices.add(new QuitGameButton(this));

        this.getContentPane().getComponents().add(choices);

        TPanel footer = new TPanel(0, 1);
        TLabel seedLabel = new TLabel("Seed : " + game.getSeed());
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
