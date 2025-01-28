package fr.esiea.inf3132tp2024.view.console.api.dialog;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.TColor;
import fr.esiea.inf3132tp2024.view.console.DisplayableComponent;
import fr.esiea.inf3132tp2024.view.console.api.component.TFrame;
import fr.esiea.inf3132tp2024.view.console.api.component.TLabel;
import fr.esiea.inf3132tp2024.view.console.api.component.TPanel;
import fr.esiea.inf3132tp2024.view.console.api.component.HorizontalAlignment;
import fr.esiea.inf3132tp2024.utils.StringUtils;

public class ErrorDialog extends TFrame implements DisplayableComponent {
    public ErrorDialog(DialogType type, String text) {
        this(type, StringUtils.convertStringToStringArray(text));
    }

    public ErrorDialog(DialogType type, String[] text) {
        super(AppSettings.CONSOLE_MIN_LENGTH, AppSettings.CONSOLE_MIN_HEIGHT);

        TLabel title = new TLabel("Erreur");
        title.getColors().add(TColor.BOLD);
        title.getColors().add(TColor.RED);
        TPanel header = new TPanel(0, title.getHeight());
        header.getComponents().add(title);
        this.setHeader(header);

        TLabel introMessage = new TLabel(type.getTitle(), this.getLength() - 2);
        introMessage.getColors().add(TColor.BOLD);
        introMessage.getColors().add(TColor.BLINKING);
        introMessage.getColors().add(TColor.RED);
        this.getContentPane().getComponents().add(introMessage);

        TLabel errorMessage = new TLabel(text, this.getLength() - 2);
        if (type.equals(DialogType.EXCEPTION)) {
            errorMessage.setHorizontalAlignment(HorizontalAlignment.LEFT);
        }
        errorMessage.getColors().add(TColor.RED);
        this.getContentPane().getComponents().add(errorMessage);

        TLabel exitMessage = new TLabel(type.getFooter(), this.getLength() - 2);
        exitMessage.getColors().add(TColor.BLINKING);
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
