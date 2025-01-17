package fr.esiea.inf3132tp2024.old.gui.main.menu.information.entities;

import fr.esiea.inf3132tp2024.old.App;
import fr.esiea.inf3132tp2024.old.gui.CColor;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.gui.component.*;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CLabel;
import fr.esiea.inf3132tp2024.old.gui.component.CPanel;
import fr.esiea.inf3132tp2024.old.gui.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.old.utils.direction.Orientation;

public class EntitiesMenu extends CFrame implements DisplayableComponent {
    public EntitiesMenu(App app) {
        super(0, 0, "Les entités");

        // variables pour redéfinir proprement l'ajustement du texte
        int labelLength = 0;
        int valueLength = 0;

        CPanel panel = new CPanel(HorizontalAlignment.CENTER, Orientation.VERTICAL, 1);

        // Ajout des textes qui seront sur la partie gauche de l'écran
        CLabel demogorgonLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "D");
        demogorgonLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (demogorgonLetterLabel.getLength() > labelLength) {
            labelLength = demogorgonLetterLabel.getLength();
        }

        CLabel harpyLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "H");
        harpyLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (harpyLetterLabel.getLength() > labelLength) {
            labelLength = harpyLetterLabel.getLength();
        }

        CLabel headlessKnightLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "K");
        headlessKnightLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (headlessKnightLetterLabel.getLength() > labelLength) {
            labelLength = headlessKnightLetterLabel.getLength();
        }

        CLabel morbolLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "M");
        morbolLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (morbolLetterLabel.getLength() > labelLength) {
            labelLength = morbolLetterLabel.getLength();
        }

        CLabel spiderLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "S");
        spiderLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (spiderLetterLabel.getLength() > labelLength) {
            labelLength = spiderLetterLabel.getLength();
        }

        CLabel werewolfLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "W");
        werewolfLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (werewolfLetterLabel.getLength() > labelLength) {
            labelLength = werewolfLetterLabel.getLength();
        }

        CLabel zombieLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "Z");
        zombieLetterLabel.getColors().add(CColor.BRIGHT_RED);
        if (zombieLetterLabel.getLength() > labelLength) {
            labelLength = zombieLetterLabel.getLength();
        }

        CLabel petLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "P");
        petLetterLabel.getColors().add(CColor.BRIGHT_BLUE);
        if (petLetterLabel.getLength() > labelLength) {
            labelLength = petLetterLabel.getLength();
        }

        CLabel sageLetterLabel = new CLabel(HorizontalAlignment.RIGHT, "S");
        sageLetterLabel.getColors().add(CColor.RED);
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
        CLabel demogorgonDescLabel = new CLabel(HorizontalAlignment.LEFT, "Demogorgon");
        demogorgonDescLabel.getColors().add(CColor.YELLOW);
        if (demogorgonDescLabel.getLength() > valueLength) {
            valueLength = demogorgonDescLabel.getLength();
        }

        CLabel harpyDescLabel = new CLabel(HorizontalAlignment.LEFT, "Harpie");
        harpyDescLabel.getColors().add(CColor.YELLOW);
        if (harpyDescLabel.getLength() > valueLength) {
            valueLength = harpyDescLabel.getLength();
        }

        CLabel headlessKnightDescLabel = new CLabel(HorizontalAlignment.LEFT, "Cavalier sans tête");
        headlessKnightDescLabel.getColors().add(CColor.YELLOW);
        if (headlessKnightDescLabel.getLength() > valueLength) {
            valueLength = headlessKnightDescLabel.getLength();
        }

        CLabel morbolDescLabel = new CLabel(HorizontalAlignment.LEFT, "Morbol");
        morbolDescLabel.getColors().add(CColor.YELLOW);
        if (morbolDescLabel.getLength() > valueLength) {
            valueLength = morbolDescLabel.getLength();
        }

        CLabel spiderDescLabel = new CLabel(HorizontalAlignment.LEFT, "Araignée");
        spiderDescLabel.getColors().add(CColor.YELLOW);
        if (spiderDescLabel.getLength() > valueLength) {
            valueLength = spiderDescLabel.getLength();
        }

        CLabel werewolfDescLabel = new CLabel(HorizontalAlignment.LEFT, "Loup-Garou");
        werewolfDescLabel.getColors().add(CColor.YELLOW);
        if (werewolfDescLabel.getLength() > valueLength) {
            valueLength = werewolfDescLabel.getLength();
        }

        CLabel zombieDescLabel = new CLabel(HorizontalAlignment.LEFT, "Zombie");
        zombieDescLabel.getColors().add(CColor.YELLOW);
        if (zombieDescLabel.getLength() > valueLength) {
            valueLength = zombieDescLabel.getLength();
        }

        CLabel petDescLabel = new CLabel(HorizontalAlignment.LEFT, "Familier");
        petDescLabel.getColors().add(CColor.YELLOW);
        if (petDescLabel.getLength() > valueLength) {
            valueLength = petDescLabel.getLength();
        }

        CLabel sageDescLabel = new CLabel(HorizontalAlignment.LEFT, "Sage bloquant un passage");
        sageDescLabel.getColors().add(CColor.YELLOW);
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

        CLabel separatorLabel = new CLabel(HorizontalAlignment.LEFT, "-");

        CPanel demogorgonPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        demogorgonPanel.getComponents().add(demogorgonLetterLabel);
        demogorgonPanel.getComponents().add(separatorLabel);
        demogorgonPanel.getComponents().add(demogorgonDescLabel);
        demogorgonPanel.autoResize();

        CPanel harpyPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        harpyPanel.getComponents().add(harpyLetterLabel);
        harpyPanel.getComponents().add(separatorLabel);
        harpyPanel.getComponents().add(harpyDescLabel);
        harpyPanel.autoResize();

        CPanel headlessKnightPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        headlessKnightPanel.getComponents().add(headlessKnightLetterLabel);
        headlessKnightPanel.getComponents().add(separatorLabel);
        headlessKnightPanel.getComponents().add(headlessKnightDescLabel);
        headlessKnightPanel.autoResize();

        CPanel morbolPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        morbolPanel.getComponents().add(morbolLetterLabel);
        morbolPanel.getComponents().add(separatorLabel);
        morbolPanel.getComponents().add(morbolDescLabel);
        morbolPanel.autoResize();

        CPanel spiderPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        spiderPanel.getComponents().add(spiderLetterLabel);
        spiderPanel.getComponents().add(separatorLabel);
        spiderPanel.getComponents().add(spiderDescLabel);
        spiderPanel.autoResize();

        CPanel werewolfPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        werewolfPanel.getComponents().add(werewolfLetterLabel);
        werewolfPanel.getComponents().add(separatorLabel);
        werewolfPanel.getComponents().add(werewolfDescLabel);
        werewolfPanel.autoResize();

        CPanel zombiePanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        zombiePanel.getComponents().add(zombieLetterLabel);
        zombiePanel.getComponents().add(separatorLabel);
        zombiePanel.getComponents().add(zombieDescLabel);
        zombiePanel.autoResize();

        CPanel petPanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
        petPanel.getComponents().add(petLetterLabel);
        petPanel.getComponents().add(separatorLabel);
        petPanel.getComponents().add(petDescLabel);
        petPanel.autoResize();

        CPanel sagePanel = new CPanel(HorizontalAlignment.CENTER, Orientation.HORIZONTAL, 1);
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
