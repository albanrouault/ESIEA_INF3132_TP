package fr.esiea.inf3132tp2024.old.audio;

public enum Music {
    MENU("Stranger Things 3 - The Game Soundtrack - Hess Farm.wav"),
    GAME("Stranger Things 3 - The Game Soundtrack - Russian Farm Base.wav"),
    FIGHT("Final Fantasy 10 - Battle Theme.wav"),
    DEATH("Risitas, meme Original.wav"),
    ERROR("Curb your enthusiasm - Credits + Theme Song.wav"),
    WIN("I Will Survive.wav"),
    CHEAT("Microsoft Windows XP Shutdown Sound.wav");

    private static final String basePath = "/assets/music/";
    private final String fileName;

    Music(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return basePath + fileName;
    }
}
