package fr.esiea.inf3132tp2024.old.event;

public interface CancelableEvent {
    boolean isCanceled();

    void setCanceled(boolean cancel);
}
