package fr.esiea.inf3132tp2024.old.gui.main;

import fr.esiea.inf3132tp2024.old.gui.CColor;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CLabel;

public class SplashScreen extends CFrame implements DisplayableComponent {
    public SplashScreen() {
        super(0, 0);

        CLabel label = new CLabel("" +
                " ███████╗███████╗ ██████╗███╗   ██╗ █████╗ ███╗   ███╗\n" +
                " ██╔════╝██╔════╝██╔════╝████╗  ██║██╔══██╗████╗ ████║\n" +
                " █████╗  ███████╗██║     ██╔██╗ ██║███████║██╔████╔██║\n" +
                " ██╔══╝  ╚════██║██║     ██║╚██╗██║██╔══██║██║╚██╔╝██║\n" +
                " ███████╗███████║╚██████╗██║ ╚████║██║  ██║██║ ╚═╝ ██║\n" +
                " ╚══════╝╚══════╝ ╚═════╝╚═╝  ╚═══╝╚═╝  ╚═╝╚═╝     ╚═╝\n" +
                "                                                     \n" +
                "          ██████╗  █████╗ ███╗   ███╗███████╗         \n" +
                "         ██╔════╝ ██╔══██╗████╗ ████║██╔════╝         \n" +
                "         ██║  ███╗███████║██╔████╔██║█████╗           \n" +
                "         ██║   ██║██╔══██║██║╚██╔╝██║██╔══╝           \n" +
                "         ╚██████╔╝██║  ██║██║ ╚═╝ ██║███████╗         \n" +
                "          ╚═════╝ ╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝         ");
        label.getColors().add(CColor.YELLOW);

        CLabel startLabel = new CLabel("Appuyez sur une touche pour démarrer...");
        startLabel.getColors().add(CColor.BLINKING);

        this.getContentPane().getComponents().add(label);
        this.getContentPane().getComponents().add(startLabel);
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public boolean isInLoopingMode() {
        return false;
    }

    @Override
    public void stopLoopingMode() {
    }
}
