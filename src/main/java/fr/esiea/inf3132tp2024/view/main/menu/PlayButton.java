package fr.esiea.inf3132tp2024.view.main.menu;

import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TButton;
import fr.esiea.inf3132tp2024.view.play.start.PlayMenu;

public class PlayButton extends TButton {
    private final MainMenu mainMenu;

    public PlayButton(MainMenu mainMenu) {
        super("Jouer");

        this.mainMenu = mainMenu;
    }

    @Override
    public void execute() {
        Terminal.getInstance().show(new PlayMenu(mainMenu));
    }
}
