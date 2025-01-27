package fr.esiea.inf3132tp2024.view.console.main;

import fr.esiea.inf3132tp2024.view.console.CColor;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.api.component.CFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.CLabel;

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
