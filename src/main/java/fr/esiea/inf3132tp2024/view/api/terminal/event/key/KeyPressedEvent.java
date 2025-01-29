package fr.esiea.inf3132tp2024.view.api.terminal.event.key;

public class KeyPressedEvent {
    private final int key;

    public KeyPressedEvent(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
}
