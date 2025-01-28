package fr.esiea.inf3132tp2024.view.console.main.menu.information.entities;

import fr.esiea.inf3132tp2024.utils.direction.Orientation;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.TColor;
import fr.esiea.inf3132tp2024.view.console.api.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TLabel;
import fr.esiea.inf3132tp2024.view.console.api.component.TPanel;

public class EntitiesMenu extends TFrame implements DisplayableComponent {
    public EntitiesMenu() {
        super(0, 0, "Les entités");

        // variables pour redéfinir proprement l'ajustement du texte
        int labelLength = 0;
        int valueLength = 0;

        TPanel panel = new TPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Ajout des textes qui seront sur la partie gauche de l'écran
        TLabel demogorgonLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "D");
        demogorgonLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (demogorgonLetterLabel.getLength() > labelLength) {
            labelLength = demogorgonLetterLabel.getLength();
        }

        TLabel harpyLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "H");
        harpyLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (harpyLetterLabel.getLength() > labelLength) {
            labelLength = harpyLetterLabel.getLength();
        }

        TLabel headlessKnightLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "K");
        headlessKnightLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (headlessKnightLetterLabel.getLength() > labelLength) {
            labelLength = headlessKnightLetterLabel.getLength();
        }

        TLabel morbolLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "M");
        morbolLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (morbolLetterLabel.getLength() > labelLength) {
            labelLength = morbolLetterLabel.getLength();
        }

        TLabel spiderLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "S");
        spiderLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (spiderLetterLabel.getLength() > labelLength) {
            labelLength = spiderLetterLabel.getLength();
        }

        TLabel werewolfLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "W");
        werewolfLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (werewolfLetterLabel.getLength() > labelLength) {
            labelLength = werewolfLetterLabel.getLength();
        }

        TLabel zombieLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "Z");
        zombieLetterLabel.getColors().add(TColor.BRIGHT_RED);
        if (zombieLetterLabel.getLength() > labelLength) {
            labelLength = zombieLetterLabel.getLength();
        }

        TLabel petLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "P");
        petLetterLabel.getColors().add(TColor.BRIGHT_BLUE);
        if (petLetterLabel.getLength() > labelLength) {
            labelLength = petLetterLabel.getLength();
        }

        TLabel sageLetterLabel = new TLabel(HorizontalAlignment.RIGHT, "S");
        sageLetterLabel.getColors().add(TColor.RED);
        if (sageLetterLabel.getLength() > labelLength) {
            labelLength = sageLetterLabel.getLength();
        }

        // ajustement des textes à gauche
        demogorgonLetterLabel.setLength(labelLength);
        harpyLetterLabel.setLength(labelLength);
        headlessKnightLetterLabel.setLength(labelLength);
        morbolLetterLabel.setLength(labelLength);
        spiderLetterLabel.setLength(labelLength);
        werewolfLetterLabel.setLength(labelLength);
        zombieLetterLabel.setLength(labelLength);
        petLetterLabel.setLength(labelLength);
        sageLetterLabel.setLength(labelLength);

        // Ajout des textes qui seront sur la partie droite de l'écran
        TLabel demogorgonDescLabel = new TLabel(HorizontalAlignment.LEFT, "Demogorgon");
        demogorgonDescLabel.getColors().add(TColor.YELLOW);
        if (demogorgonDescLabel.getLength() > valueLength) {
            valueLength = demogorgonDescLabel.getLength();
        }

        TLabel harpyDescLabel = new TLabel(HorizontalAlignment.LEFT, "Harpie");
        harpyDescLabel.getColors().add(TColor.YELLOW);
        if (harpyDescLabel.getLength() > valueLength) {
            valueLength = harpyDescLabel.getLength();
        }

        TLabel headlessKnightDescLabel = new TLabel(HorizontalAlignment.LEFT, "Cavalier sans tête");
        headlessKnightDescLabel.getColors().add(TColor.YELLOW);
        if (headlessKnightDescLabel.getLength() > valueLength) {
            valueLength = headlessKnightDescLabel.getLength();
        }

        TLabel morbolDescLabel = new TLabel(HorizontalAlignment.LEFT, "Morbol");
        morbolDescLabel.getColors().add(TColor.YELLOW);
        if (morbolDescLabel.getLength() > valueLength) {
            valueLength = morbolDescLabel.getLength();
        }

        TLabel spiderDescLabel = new TLabel(HorizontalAlignment.LEFT, "Araignée");
        spiderDescLabel.getColors().add(TColor.YELLOW);
        if (spiderDescLabel.getLength() > valueLength) {
            valueLength = spiderDescLabel.getLength();
        }

        TLabel werewolfDescLabel = new TLabel(HorizontalAlignment.LEFT, "Loup-Garou");
        werewolfDescLabel.getColors().add(TColor.YELLOW);
        if (werewolfDescLabel.getLength() > valueLength) {
            valueLength = werewolfDescLabel.getLength();
        }

        TLabel zombieDescLabel = new TLabel(HorizontalAlignment.LEFT, "Zombie");
        zombieDescLabel.getColors().add(TColor.YELLOW);
        if (zombieDescLabel.getLength() > valueLength) {
            valueLength = zombieDescLabel.getLength();
        }

        TLabel petDescLabel = new TLabel(HorizontalAlignment.LEFT, "Familier");
        petDescLabel.getColors().add(TColor.YELLOW);
        if (petDescLabel.getLength() > valueLength) {
            valueLength = petDescLabel.getLength();
        }

        TLabel sageDescLabel = new TLabel(HorizontalAlignment.LEFT, "Sage bloquant un passage");
        sageDescLabel.getColors().add(TColor.YELLOW);
        if (sageDescLabel.getLength() > valueLength) {
            valueLength = sageDescLabel.getLength();
        }

        // ajustement des textes à droite
        demogorgonDescLabel.setLength(valueLength);
        harpyDescLabel.setLength(valueLength);
        headlessKnightDescLabel.setLength(valueLength);
        morbolDescLabel.setLength(valueLength);
        spiderDescLabel.setLength(valueLength);
        werewolfDescLabel.setLength(valueLength);
        zombieDescLabel.setLength(valueLength);
        petDescLabel.setLength(valueLength);
        sageDescLabel.setLength(valueLength);

        TLabel separatorLabel = new TLabel(HorizontalAlignment.LEFT, "-");

        TPanel demogorgonPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        demogorgonPanel.getComponents().add(demogorgonLetterLabel);
        demogorgonPanel.getComponents().add(separatorLabel);
        demogorgonPanel.getComponents().add(demogorgonDescLabel);
        demogorgonPanel.autoResize();

        TPanel harpyPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        harpyPanel.getComponents().add(harpyLetterLabel);
        harpyPanel.getComponents().add(separatorLabel);
        harpyPanel.getComponents().add(harpyDescLabel);
        harpyPanel.autoResize();

        TPanel headlessKnightPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        headlessKnightPanel.getComponents().add(headlessKnightLetterLabel);
        headlessKnightPanel.getComponents().add(separatorLabel);
        headlessKnightPanel.getComponents().add(headlessKnightDescLabel);
        headlessKnightPanel.autoResize();

        TPanel morbolPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        morbolPanel.getComponents().add(morbolLetterLabel);
        morbolPanel.getComponents().add(separatorLabel);
        morbolPanel.getComponents().add(morbolDescLabel);
        morbolPanel.autoResize();

        TPanel spiderPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        spiderPanel.getComponents().add(spiderLetterLabel);
        spiderPanel.getComponents().add(separatorLabel);
        spiderPanel.getComponents().add(spiderDescLabel);
        spiderPanel.autoResize();

        TPanel werewolfPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        werewolfPanel.getComponents().add(werewolfLetterLabel);
        werewolfPanel.getComponents().add(separatorLabel);
        werewolfPanel.getComponents().add(werewolfDescLabel);
        werewolfPanel.autoResize();

        TPanel zombiePanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        zombiePanel.getComponents().add(zombieLetterLabel);
        zombiePanel.getComponents().add(separatorLabel);
        zombiePanel.getComponents().add(zombieDescLabel);
        zombiePanel.autoResize();

        TPanel petPanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        petPanel.getComponents().add(petLetterLabel);
        petPanel.getComponents().add(separatorLabel);
        petPanel.getComponents().add(petDescLabel);
        petPanel.autoResize();

        TPanel sagePanel = new TPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        sagePanel.getComponents().add(sageLetterLabel);
        sagePanel.getComponents().add(separatorLabel);
        sagePanel.getComponents().add(sageDescLabel);
        sagePanel.autoResize();

        // ajout de tous les textes au panel + ajustement
        panel.getComponents().add(demogorgonPanel);
        panel.getComponents().add(harpyPanel);
        panel.getComponents().add(headlessKnightPanel);
        panel.getComponents().add(morbolPanel);
        panel.getComponents().add(spiderPanel);
        panel.getComponents().add(werewolfPanel);
        panel.getComponents().add(zombiePanel);
        panel.getComponents().add(petPanel);
        panel.getComponents().add(sagePanel);
        panel.autoResize();

        this.getContentPane().getComponents().add(panel);
    }

    @Override
    public boolean isInLoopingMode() {
        return false;
    }

    @Override
    public boolean isInFullScreenMode() {
        return true;
    }

    @Override
    public void stopLoopingMode() {
    }
}
