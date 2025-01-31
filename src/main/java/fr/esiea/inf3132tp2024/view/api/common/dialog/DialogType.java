package fr.esiea.inf3132tp2024.view.api.common.dialog;

public enum DialogType {
    INFO("\u24D8 Information \u24D8", "Appuyez sur une touche pour continuer..."),
    WARNING("\u26A0 Attention \u26A0", "Appuyez sur une touche pour continuer..."),
    ERROR("\u26A0 Erreur \u26A0", "Appuyez sur une touche pour continuer..."),
    HISTORY("\u270F Histoire \u270F", "Appuyez sur une touche pour continuer..."),
    EXCEPTION("\u26A0 Une erreur fatale est survenue \u26A0", "Appuyez sur une touche pour quitter...");

    private final String title;
    private final String footer;

    DialogType(String text, String footer) {
        this.title = text;
        this.footer = footer;
    }

    public String getTitle() {
        return title;
    }

    public String getFooter() {
        return footer;
    }
}

