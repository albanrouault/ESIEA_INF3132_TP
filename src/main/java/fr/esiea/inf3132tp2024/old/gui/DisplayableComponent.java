package fr.esiea.inf3132tp2024.old.gui;

public interface DisplayableComponent {
    boolean isInFullScreenMode();

    boolean isInLoopingMode();

    void stopLoopingMode();
}