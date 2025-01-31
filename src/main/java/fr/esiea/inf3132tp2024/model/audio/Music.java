package fr.esiea.inf3132tp2024.model.audio;

public enum Music {
    MENU("Menu-Bourg-Palette-Pokemon-Lets-Go-PikachuLets-Go-evoli-OST.wav"),
    GAME("Fight-Pokemon-Lets-Go-Pikachu-and-Lets-Go-Eevee.wav"),
    ERROR("Curb your enthusiasm - Credits + Theme Song.wav"),
    WIN("Victory_-_Pokemon-Lets-Go-Pikachu-and-Lets-Go-Eevee-OST-_Gamerip_.wav"),
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
