package fr.esiea.inf3132tp2024.controller;

import java.io.*;

public class AppSettings {
    private static final AppSettings INSTANCE = new AppSettings();

    public static AppSettings getInstance() {
        return INSTANCE;
    }

    public static final int CONSOLE_MIN_LENGTH = 130;
    public static final int CONSOLE_MIN_HEIGHT = 35;
    public static final int MUSIC_DEFAULT_VOLUME = 50;
    public static final int SOUND_DEFAULT_VOLUME = 25;
    public static final String DEFAULT_FILE_PATH = "settings.dat";

    private int consoleLength = CONSOLE_MIN_LENGTH;
    private int consoleHeight = CONSOLE_MIN_HEIGHT;
    private float musicVolume = (float) MUSIC_DEFAULT_VOLUME / 100;
    private float soundEffectsVolume = (float) SOUND_DEFAULT_VOLUME / 100;

    /**
     * Méthode permettant de définir les paramètres de l'application.
     * <p>
     * Bloquer l'instanciation de la classe (pattern Singleton)
     */
    private AppSettings() {
        String detectedConsoleLengthStr = System.getProperty("COLUMNS");
        if (detectedConsoleLengthStr != null) {
            int detectedConsoleLength = Integer.parseInt(detectedConsoleLengthStr);
            if (detectedConsoleLength > consoleLength) {
                consoleLength = detectedConsoleLength;
            }
        }
        String detectedConsoleHeightStr = System.getProperty("LINES");
        if (detectedConsoleHeightStr != null) {
            int detectedConsoleHeight = Integer.parseInt(detectedConsoleHeightStr);
            if (detectedConsoleHeight > consoleHeight) {
                consoleHeight = detectedConsoleHeight;
            }
        }
    }

    /**
     * Méthode permettant de sauvegarder dans un fichier les paramètres de l'utilisateur.
     *
     * @param file Le fichier où doivent être sauvegardés les paramètres
     * @throws IOException Levé d'une exception si un problème lors de la sauvegarde
     */
    public void save(File file) throws IOException {
        FileOutputStream fluxEntree = new FileOutputStream(file);
        BufferedOutputStream outTampon = new BufferedOutputStream(fluxEntree);
        DataOutputStream out = new DataOutputStream(outTampon);

        out.writeInt(this.consoleLength);
        out.writeInt(this.consoleHeight);
        out.writeFloat(this.musicVolume);
        out.writeFloat(this.soundEffectsVolume);

        out.close();
    }

    /**
     * Méthode permettant de récupérer les paramètres de l'utilisateur si ceux-ci existent.
     *
     * @param file Le fichier où doivent être sauvegardés les paramètres
     * @throws IOException                    Levé d'une exception si un problème lors du chargement du fichier
     * @throws SettingsFileCorruptedException Levé d'une exception si le fichier de paramètres est corrompu
     */
    public void load(File file) throws IOException, SettingsFileCorruptedException {
        FileInputStream fluxEntree = new FileInputStream(file);
        BufferedInputStream inTampon = new BufferedInputStream(fluxEntree);
        DataInputStream in = new DataInputStream(inTampon);

        if (in.available() < 4) {
            in.close();
            throw new SettingsFileCorruptedException(file, "Le fichier de paramètres est corrompu");
        }

        setConsoleLength(in.readInt());
        setConsoleHeight(in.readInt());
        setMusicVolume(in.readFloat());
        setSoundEffectsVolume(in.readFloat());

        in.close();
    }

    /**
     * Getter permettant de récupérer la longueur de la console.
     *
     * @return La longueur de la console
     */
    public int getConsoleLength() {
        return consoleLength;
    }

    /**
     * Setter permettant de définir la longueur de la console.
     * Si la longueur est inférieure à CONSOLE_MIN_LENGTH, ne change pas la taille
     *
     * @param consoleLength La longueur de la console
     */
    public void setConsoleLength(int consoleLength) {
        if (consoleLength < CONSOLE_MIN_LENGTH) {
            return;
        }
        this.consoleLength = consoleLength;
    }

    /**
     * Getter permettant de récupérer la hauteur de la console.
     *
     * @return La hauteur de la console
     */
    public int getConsoleHeight() {
        return consoleHeight;
    }

    /**
     * Setter permettant de définir la hauteur de la console.
     * Si la hauteur est inférieure à CONSOLE_MIN_HEIGHT, ne change pas la taille
     *
     * @param consoleHeight La hauteur de la console
     */
    public void setConsoleHeight(int consoleHeight) {
        if (consoleHeight < CONSOLE_MIN_HEIGHT) {
            return;
        }
        this.consoleHeight = consoleHeight;
    }

    /**
     * Getter permettant de récupérer le volume de la musique.
     *
     * @return le volume de la musique compris entre 0 et 1 (float)
     */
    public float getMusicVolume() {
        return musicVolume;
    }

    /**
     * Setter permettant de définir le volume de la musique.
     *
     * @param musicVolume le volume de la musique entre 0 et 1 (float)
     */
    public void setMusicVolume(float musicVolume) {
        this.musicVolume = musicVolume;
    }

    /**
     * Getter permettant de récupérer le volume des effets sonores.
     *
     * @return le volume des effets sonores compris entre 0 et 1 (float)
     */
    public float getSoundEffectsVolume() {
        return soundEffectsVolume;
    }

    /**
     * Setter permettant de définir le volume des effets sonores.
     *
     * @param soundEffectsVolume le volume des effets sonores entre 0 et 1 (float)
     */
    public void setSoundEffectsVolume(float soundEffectsVolume) {
        this.soundEffectsVolume = soundEffectsVolume;
    }
}
