package fr.esiea.inf3132tp2024.view.main;

import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;

public class SplashScreen extends TFrame implements DisplayableComponent {
    public SplashScreen() {
        super(0, 0);

        TLabel label = new TLabel("" +
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
        label.getColors().add(TColor.YELLOW);

        TLabel startLabel = new TLabel("Appuyez sur une touche pour démarrer...");
        startLabel.getColors().add(TColor.BLINKING);

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
