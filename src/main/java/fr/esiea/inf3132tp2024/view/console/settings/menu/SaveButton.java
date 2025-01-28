package fr.esiea.inf3132tp2024.view.console.settings.menu;

import fr.esiea.inf3132tp2024.old.AppSettings;
import fr.esiea.inf3132tp2024.view.console.Console;
import fr.esiea.inf3132tp2024.view.console.api.dialog.DialogType;
import fr.esiea.inf3132tp2024.view.console.api.dialog.ErrorDialog;
import fr.esiea.inf3132tp2024.view.console.component.common.QuitComponentButton;

import java.io.File;
import java.io.IOException;

public class SaveButton extends QuitComponentButton {
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
            Console.getInstance().show(new ErrorDialog(DialogType.ERROR, "Impossible de sauvegarder les paramètres\n \nErreur : " + e.getMessage()));
        }
    }
}
