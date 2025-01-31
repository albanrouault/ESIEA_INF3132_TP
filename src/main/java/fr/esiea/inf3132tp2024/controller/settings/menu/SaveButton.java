package fr.esiea.inf3132tp2024.controller.settings.menu;

import fr.esiea.inf3132tp2024.controller.AppSettings;
import fr.esiea.inf3132tp2024.view.api.terminal.Terminal;
import fr.esiea.inf3132tp2024.view.api.common.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.api.terminal.dialog.TErrorDialog;
import fr.esiea.inf3132tp2024.view.api.terminal.TQuitComponentButton;

import java.io.File;
import java.io.IOException;

public class SaveButton extends TQuitComponentButton {
    public SaveButton(SettingsMenu settingsMenu) {
        super(settingsMenu, "Sauvegarder");
    }

    @Override
    public void execute() {
        super.execute();

        File settingsFile = new File(AppSettings.DEFAULT_FILE_PATH);
        try {
            AppSettings.getInstance().save(settingsFile);
        } catch (IOException e) {
            Terminal.getInstance().show(new TErrorDialog(DialogType.ERROR, "Impossible de sauvegarder les paramètres\n \nErreur : " + e.getMessage()));
        }
    }
}
