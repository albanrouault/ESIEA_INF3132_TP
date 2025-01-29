package fr.esiea.inf3132tp2024.view.api.terminal.dialog;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.TColor;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TFrame;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TLabel;
import fr.esiea.inf3132tp2024.view.api.terminal.component.TPanel;
import fr.esiea.inf3132tp2024.view.api.common.component.DisplayableComponent;
import fr.esiea.inf3132tp2024.utils.StringUtils;

public class TInfoDialog extends TFrame implements DisplayableComponent {
    public TInfoDialog(DialogType type, String text) {
        this(type, StringUtils.convertStringToStringArray(text));
    }

    public TInfoDialog(DialogType type, String[] text) {
        super(AppSettings.CONSOLE_MIN_LENGTH, AppSettings.CONSOLE_MIN_HEIGHT);

        TLabel title = new TLabel("Message");
        title.getColors().add(TColor.BOLD);
        title.getColors().add(TColor.YELLOW);
        TPanel header = new TPanel(0, title.getHeight());
        header.getComponents().add(title);
        this.setHeader(header);

        TLabel introMessage = new TLabel(type.getTitle(), this.getLength() - 2);
        introMessage.getColors().add(TColor.BOLD);
        introMessage.getColors().add(TColor.BLINKING);
        introMessage.getColors().add(TColor.YELLOW);
        this.getContentPane().getComponents().add(introMessage);

        TLabel errorMessage = new TLabel(text, this.getLength() - 2);
        errorMessage.getColors().add(TColor.YELLOW);
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
