package fr.esiea.inf3132tp2024.view.console.main.menu;

import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.component.TButton;
import fr.esiea.inf3132tp2024.view.console.play.start.PlayMenu;

public class PlayButton extends TButton {
    private final MainMenu mainMenu;

    public PlayButton(MainMenu mainMenu) {
        super("Jouer");

        this.mainMenu = mainMenu;
    }

    @Override
    public void execute() {
        Console.getInstance().show(new PlayMenu(mainMenu));
    }
}
