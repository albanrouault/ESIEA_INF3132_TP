package fr.esiea.inf3132tp2024.old.gui.dialog;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.old.gui.CColor;
import fr.esiea.inf3132tp2024.old.gui.DisplayableComponent;
import fr.esiea.inf3132tp2024.gui.component.*;
import fr.esiea.inf3132tp2024.old.gui.component.CFrame;
import fr.esiea.inf3132tp2024.old.gui.component.CLabel;
import fr.esiea.inf3132tp2024.old.gui.component.CPanel;
import fr.esiea.inf3132tp2024.old.gui.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.old.utils.StringUtils;

public class ErrorDialog extends CFrame implements DisplayableComponent {
    public ErrorDialog(DialogType type, String text) {
        this(type, StringUtils.convertStringToStringArray(text));
    }

    public ErrorDialog(DialogType type, String[] text) {
        super(AppSettings.CONSOLE_MIN_LENGTH, AppSettings.CONSOLE_MIN_HEIGHT);

        CLabel title = new CLabel("Erreur");
        title.getColors().add(CColor.BOLD);
        title.getColors().add(CColor.RED);
        CPanel header = new CPanel(0, title.getHeight());
        header.getComponents().add(title);
        this.setHeader(header);

        CLabel introMessage = new CLabel(type.getTitle(), this.getLength() - 2);
        introMessage.getColors().add(CColor.BOLD);
        introMessage.getColors().add(CColor.BLINKING);
        introMessage.getColors().add(CColor.RED);
        this.getContentPane().getComponents().add(introMessage);

        CLabel errorMessage = new CLabel(text, this.getLength() - 2);
        if (type.equals(DialogType.EXCEPTION)) {
            errorMessage.setHorizontalAlignment(HorizontalAlignment.LEFT);
        }
        errorMessage.getColors().add(CColor.RED);
        this.getContentPane().getComponents().add(errorMessage);

        CLabel exitMessage = new CLabel(type.getFooter(), this.getLength() - 2);
        exitMessage.getColors().add(CColor.BLINKING);
        this.getContentPane().getComponents().add(exitMessage);
    }

    @Override
    public boolean isInFullScreenMode() {
        return false;
    }

    @Override
    public boolean isInLoopingMode() {
        return false;
    }

    @Override
    public void stopLoopingMode() {
    }
}
