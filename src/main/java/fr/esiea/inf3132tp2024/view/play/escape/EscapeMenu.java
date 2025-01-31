package fr.esiea.inf3132tp2024.view.play.escape;

import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TChoices;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.terminal.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.view.main.menu.information.InfoButton;
import fr.esiea.inf3132tp2024.view.play.game.GameView;

public class EscapeMenu extends TFrame implements DisplayableComponent {
    private boolean display = true;

    public EscapeMenu(GameView gameView) {
        super(0, 0, "Pause");

        TChoices choices = new TChoices(1);
        choices.add(new TQuitComponentButton(this, "Reprendre la partie"));
        choices.add(new InfoButton());
        choices.add(new CheatButton(gameView, this));
        choices.add(new QuitGameButton(this, gameView));

        this.getContentPane().getComponents().add(choices);

        TPanel footer = new TPanel(0, 1);
        TLabel seedLabel = new TLabel("Seed : " + gameView.getGame().getSeed());
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
