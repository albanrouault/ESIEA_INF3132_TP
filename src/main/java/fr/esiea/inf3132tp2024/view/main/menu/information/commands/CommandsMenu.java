package fr.esiea.inf3132tp2024.view.main.menu.information.commands;

import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.direction.Orientation;

public class CommandsMenu extends TFrame implements DisplayableComponent {
    public CommandsMenu() {
        super(0, 0, "Les commandes");

        // variables pour redéfinir proprement l'ajustement du texte
        int labelLength = 0;
        int valueLength = 0;

        TPanel panel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Ajout des textes qui seront sur la partie gauche de l'écran
        TLabel upLabel = new TLabel(HorizontalAlignment.RIGHT, "Monter :");
        upLabel.getColors().add(TColor.GREEN);
        if (upLabel.getLength() > labelLength) {
            labelLength = upLabel.getLength();
        }

        TLabel downLabel = new TLabel(HorizontalAlignment.RIGHT, "Descendre :");
        downLabel.getColors().add(TColor.GREEN);
        if (downLabel.getLength() > labelLength) {
            labelLength = downLabel.getLength();
        }

        TLabel leftLabel = new TLabel(HorizontalAlignment.RIGHT, "Gauche :");
        leftLabel.getColors().add(TColor.GREEN);
        if (leftLabel.getLength() > labelLength) {
            labelLength = leftLabel.getLength();
        }

        TLabel rightLabel = new TLabel(HorizontalAlignment.RIGHT, "Droite :");
        rightLabel.getColors().add(TColor.GREEN);
        if (rightLabel.getLength() > labelLength) {
            labelLength = rightLabel.getLength();
        }

        // ajustement des textes à gauche
        upLabel.setLength(labelLength);
        downLabel.setLength(labelLength);
        leftLabel.setLength(labelLength);
        rightLabel.setLength(labelLength);

        // Ajout des textes qui seront sur la partie droite de l'écran
        // première commande (haut)
        TLabel upDescOne = new TLabel(HorizontalAlignment.LEFT, "Flèche haut");
        upDescOne.getColors().add(TColor.RED);

        TLabel upDescTwo = new TLabel(HorizontalAlignment.LEFT, "ou");
        upDescTwo.getColors().add(TColor.YELLOW);

        TLabel upDescThree = new TLabel(HorizontalAlignment.LEFT, "Z");
        upDescThree.getColors().add(TColor.RED);

        TPanel upDescription = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        upDescription.getComponents().add(upDescOne);
        upDescription.getComponents().add(upDescTwo);
        upDescription.getComponents().add(upDescThree);
        upDescription.autoResize();
        if (upDescription.getLength() > valueLength) {
            valueLength = upDescription.getLength();
        }

        TPanel upValue = new TPanel(HorizontalAlignment.LEFT, 0, 0, Orientation.HORIZONTAL, false);
        upValue.getComponents().add(upDescription);
        upValue.autoResize();

        // deuxième commande (bas)
        TLabel downDescOne = new TLabel(HorizontalAlignment.LEFT, "Flèche bas");
        downDescOne.getColors().add(TColor.RED);

        TLabel downDescTwo = new TLabel(HorizontalAlignment.LEFT, "ou");
        downDescTwo.getColors().add(TColor.YELLOW);

        TLabel downDescThree = new TLabel(HorizontalAlignment.LEFT, "S");
        downDescThree.getColors().add(TColor.RED);

        TPanel downDescription = new TPanel(HorizontalAlignment.LEFT, Orientation.HORIZONTAL, 1);
        downDescription.getComponents().add(downDescOne);
        downDescription.getComponents().add(downDescTwo);
        downDescription.getComponents().add(downDescThree);
        downDescription.autoResize();
        if (downDescription.getLength() > valueLength) {
            valueLength = downDescription.getLength();
        }

        TPanel downValue = new TPanel(HorizontalAlignment.LEFT, 0, 0, Orientation.HORIZONTAL, false);
        downValue.getComponents().add(downDescription);
        downValue.autoResize();

        // troisième commande (gauche)
        TLabel leftDescOne = new TLabel(HorizontalAlignment.LEFT, "Flèche gauche");
        leftDescOne.getColors().add(TColor.RED);

        TLabel leftDescTwo = new TLabel(HorizontalAlignment.LEFT, "ou");
        leftDescTwo.getColors().add(TColor.YELLOW);

        TLabel leftDescThree = new TLabel(HorizontalAlignment.LEFT, "Q");
        leftDescThree.getColors().add(TColor.RED);

        TPanel leftDescription = new TPanel(HorizontalAlignment.LEFT, Orientation.HORIZONTAL, 1);
        leftDescription.getComponents().add(leftDescOne);
        leftDescription.getComponents().add(leftDescTwo);
        leftDescription.getComponents().add(leftDescThree);
        leftDescription.autoResize();
        if (leftDescription.getLength() > valueLength) {
            valueLength = leftDescription.getLength();
        }

        TPanel leftValue = new TPanel(HorizontalAlignment.LEFT, 0, 0, Orientation.HORIZONTAL, false);
        leftValue.getComponents().add(leftDescription);
        leftValue.autoResize();

        // quatrième commande (droite)
        TLabel rightDescOne = new TLabel(HorizontalAlignment.LEFT, "Flèche droite");
        rightDescOne.getColors().add(TColor.RED);

        TLabel rightDescTwo = new TLabel(HorizontalAlignment.LEFT, "ou");
        rightDescTwo.getColors().add(TColor.YELLOW);

        TLabel rightDescThree = new TLabel(HorizontalAlignment.LEFT, "D");
        rightDescThree.getColors().add(TColor.RED);

        TPanel rightDescription = new TPanel(HorizontalAlignment.LEFT, Orientation.HORIZONTAL, 1);
        rightDescription.getComponents().add(rightDescOne);
        rightDescription.getComponents().add(rightDescTwo);
        rightDescription.getComponents().add(rightDescThree);
        rightDescription.autoResize();
        if (rightDescription.getLength() > valueLength) {
            valueLength = rightDescription.getLength();
        }

        TPanel rightValue = new TPanel(HorizontalAlignment.LEFT, 0, 0, Orientation.HORIZONTAL, false);
        rightValue.getComponents().add(rightDescription);
        rightValue.autoResize();

        // ajustement des textes à droite
        upValue.setLength(valueLength);
        downValue.setLength(valueLength);
        leftValue.setLength(valueLength);
        rightValue.setLength(valueLength);

        TPanel upPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        upPanel.getComponents().add(upLabel);
        upPanel.getComponents().add(upValue);
        upPanel.autoResize();

        TPanel downPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        downPanel.getComponents().add(downLabel);
        downPanel.getComponents().add(downValue);
        downPanel.autoResize();

        TPanel leftPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        leftPanel.getComponents().add(leftLabel);
        leftPanel.getComponents().add(leftValue);
        leftPanel.autoResize();

        TPanel rightPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        rightPanel.getComponents().add(rightLabel);
        rightPanel.getComponents().add(rightValue);
        rightPanel.autoResize();

        // ajout de tous les textes au panel + ajustement
        panel.getComponents().add(upPanel);
        panel.getComponents().add(downPanel);
        panel.getComponents().add(leftPanel);
        panel.getComponents().add(rightPanel);
        panel.autoResize();

        this.getContentPane().getComponents().add(new TLabel(HorizontalAlignment.CENTER, "Les commandes:"));
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