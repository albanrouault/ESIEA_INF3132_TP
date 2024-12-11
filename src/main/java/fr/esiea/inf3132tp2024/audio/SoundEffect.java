package fr.esiea.inf3132tp2024.audio;

public enum SoundEffect {
    HOVER("button_hover.wav"),
    SELECT("Undertale - select.wav");

    private static final String basePath = "/assets/sound/";
    private final String fileName;

    SoundEffect(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return basePath + fileName;
    }
}
