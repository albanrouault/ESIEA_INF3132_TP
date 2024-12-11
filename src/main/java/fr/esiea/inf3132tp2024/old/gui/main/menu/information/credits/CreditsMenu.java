package fr.esiea.inf3132tp2024.old.gui.main.menu.information.credits;

import fr.esiea.inf3132tp2024.old.gui.CColor;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CLabel;
import fr.esiea.inf3132tp2024.old.gui.component.CPanel;
import fr.esiea.inf3132tp2024.old.gui.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.old.utils.direction.Orientation;

public class CreditsMenu extends CFrame implements DisplayableComponent {
    public CreditsMenu() {
        super(0, 0, "Crédits");

        // Variables pour redéfinir proprement l'ajustement du texte
        int labelLength = 0;
        int valueLength = 0;

        CPanel panel = new CPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Ajout des textes qui seront sur la partie gauche de l'écran
        CLabel creatorOneName = new CLabel(HorizontalAlignment.RIGHT, "VAIZAND Victor");
        creatorOneName.getColors().add(CColor.GREEN);
        if (creatorOneName.getLength() > labelLength) {
            labelLength = creatorOneName.getLength();
        }

        CLabel creatorTwoName = new CLabel(HorizontalAlignment.RIGHT, "ROUAULT Alban");
        creatorTwoName.getColors().add(CColor.GREEN);
        if (creatorTwoName.getLength() > labelLength) {
            labelLength = creatorTwoName.getLength();
        }

        // ajustement des textes à gauche
        creatorOneName.setLength(labelLength);
        creatorTwoName.setLength(labelLength);

        // Ajout des textes qui seront sur la partie droite de l'écran
        CLabel creatorOneRole = new CLabel(HorizontalAlignment.LEFT, "Le développeur fou !");
        creatorOneRole.getColors().add(CColor.YELLOW);
        if (creatorOneRole.getLength() > valueLength) {
            valueLength = creatorOneRole.getLength();
        }

        CLabel creatorTwoRole = new CLabel(HorizontalAlignment.LEFT, "L'apprenti développeur !");
        creatorTwoRole.getColors().add(CColor.YELLOW);
        if (creatorTwoRole.getLength() > valueLength) {
            valueLength = creatorTwoRole.getLength();
        }

        // ajustement des textes à droite
        creatorOneRole.setLength(valueLength);
        creatorTwoRole.setLength(valueLength);

        CPanel creatorOne = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        creatorOne.getComponents().add(creatorOneName);
        creatorOne.getComponents().add(creatorOneRole);
        creatorOne.autoResize();

        CPanel creatorTwo = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
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
