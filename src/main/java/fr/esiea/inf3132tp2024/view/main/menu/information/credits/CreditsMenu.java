package fr.esiea.inf3132tp2024.view.main.menu.information.credits;

import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class CreditsMenu extends TFrame implements DisplayableComponent {
    public CreditsMenu() {
        super(0, 0, "Crédits");

        // Variables pour redéfinir proprement l'ajustement du texte
        int labelLength = 0;
        int valueLength = 0;

        TPanel panel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Ajout des textes qui seront sur la partie gauche de l'écran
        TLabel creatorOneName = new TLabel(HorizontalAlignment.RIGHT, "VAIZAND Victor");
        creatorOneName.getColors().add(TColor.GREEN);
        if (creatorOneName.getLength() > labelLength) {
            labelLength = creatorOneName.getLength();
        }

        TLabel creatorTwoName = new TLabel(HorizontalAlignment.RIGHT, "ROUAULT Alban");
        creatorTwoName.getColors().add(TColor.GREEN);
        if (creatorTwoName.getLength() > labelLength) {
            labelLength = creatorTwoName.getLength();
        }

        // ajustement des textes à gauche
        creatorOneName.setLength(labelLength);
        creatorTwoName.setLength(labelLength);

        // Ajout des textes qui seront sur la partie droite de l'écran
        TLabel creatorOneRole = new TLabel(HorizontalAlignment.LEFT, "Expert en Attaque \"Roulade\"");
        creatorOneRole.getColors().add(TColor.YELLOW);
        if (creatorOneRole.getLength() > valueLength) {
            valueLength = creatorOneRole.getLength();
        }

        TLabel creatorTwoRole = new TLabel(HorizontalAlignment.LEFT, "Éleveur de Magicarpe !");
        creatorTwoRole.getColors().add(TColor.YELLOW);
        if (creatorTwoRole.getLength() > valueLength) {
            valueLength = creatorTwoRole.getLength();
        }

        // ajustement des textes à droite
        creatorOneRole.setLength(valueLength);
        creatorTwoRole.setLength(valueLength);

        TPanel creatorOne = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        creatorOne.getComponents().add(creatorOneName);
        creatorOne.getComponents().add(creatorOneRole);
        creatorOne.autoResize();

        TPanel creatorTwo = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        creatorTwo.getComponents().add(creatorTwoName);
        creatorTwo.getComponents().add(creatorTwoRole);
        creatorTwo.autoResize();

        // ajout de tous les textes au panel + ajustement
        panel.getComponents().add(creatorOne);
        panel.getComponents().add(creatorTwo);
        panel.autoResize();

        this.getContentPane().getComponents().add(panel);
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
