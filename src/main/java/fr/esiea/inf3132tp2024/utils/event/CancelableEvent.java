package fr.esiea.inf3132tp2024.utils.event;

public interface CancelableEvent {
    boolean isCanceled();

    void setCanceled(boolean cancel);
}
