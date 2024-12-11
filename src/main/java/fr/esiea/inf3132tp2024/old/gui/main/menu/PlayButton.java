package fr.esiea.inf3132tp2024.old.gui.main.menu;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.component.CButton;
import fr.esiea.inf3132tp2024.old.gui.play.start.PlayMenu;

public class PlayButton extends CButton {
    private final App app;
    private final MainMenu mainMenu;

    public PlayButton(App app, MainMenu mainMenu) {
        super(app, "Jouer");

        this.app = app;
        this.mainMenu = mainMenu;
    }

    @Override
    public void execute() {
        app.getConsole().show(new PlayMenu(app, mainMenu));
    }
}
