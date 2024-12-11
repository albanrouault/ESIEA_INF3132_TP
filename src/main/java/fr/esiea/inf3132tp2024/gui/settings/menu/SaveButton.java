package fr.esiea.inf3132tp2024.gui.settings.menu;

import fr.esiea.inf3132tp2024.App;
import fr.esiea.inf3132tp2024.AppSettings;
import fr.esiea.inf3132tp2024.gui.common.QuitComponentButton;
import fr.esiea.inf3132tp2024.gui.dialog.DialogType;
import fr.esiea.inf3132tp2024.gui.dialog.ErrorDialog;

import java.io.File;
import java.io.IOException;

public class SaveButton extends QuitComponentButton {
    private final App app;

    public SaveButton(App app, SettingsMenu settingsMenu) {
        super(app, settingsMenu, "Sauvegarder");

        this.app = app;
    }

    @Override
    public void execute() {
        super.execute();

        File settingsFile = new File(AppSettings.DEFAULT_FILE_PATH);
        try {
            app.getSettings().save(settingsFile);
        } catch (IOException e) {
            app.getConsole().show(new ErrorDialog(DialogType.ERROR, "Impossible de sauvegarder les paramètres\n \nErreur : " + e.getMessage()));
        }
    }
}