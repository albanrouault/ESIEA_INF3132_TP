package fr.esiea.inf3132tp2024.view.console.api.component;

import fr.esiea.inf3132tp2024.old.audio.SoundEffect;
import fr.esiea.inf3132tp2024.old.event.key.KeyListener;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.utils.audio.AudioPlayer;
import fr.esiea.inf3132tp2024.utils.audio.AudioTrack;
import fr.esiea.inf3132tp2024.view.console.TColor;

public abstract class TButton extends TLabel implements SelectableComponent, KeyListener {
    private boolean selected = false;

    public TButton(String text) {
        this(HorizontalAlignment.CENTER, text);
    }

    public TButton(HorizontalAlignment horizontalAlignment, String text) {
        super(horizontalAlignment, text);
    }

    public TButton(String text, int length) {
        this(HorizontalAlignment.CENTER, text, length);
    }

    public TButton(HorizontalAlignment horizontalAlignment, String text, int length) {
        super(horizontalAlignment, text, length);
    }

    public TButton(String text, int length, int height) {
        this(HorizontalAlignment.CENTER, text, length, height);
    }

    public TButton(HorizontalAlignment horizontalAlignment, String text, int length, int height) {
        super(horizontalAlignment, text, length, height);
    }

    public abstract void execute();

    @Override
    public String[] render() {
        if (selected) {
            if (!this.getColors().contains(TColor.REVERSE)) {
                this.getColors().add(TColor.REVERSE);
            }
        } else {
            this.getColors().remove(TColor.REVERSE);
        }

        return super.render();
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        int key = event.getKey();

        // 10 = Entrée dans netbeans ; 13 = Entrée dans un terminal ; 32 = Espace
        if (this.isSelected() && (key == 10 || key == 13 || key == 32)) {
            AudioTrack audioTrack = AudioPlayer.getInstance().createAudioTrack(SoundEffect.SELECT);
            audioTrack.play();

            this.execute();
        }
    }

    @Override
    public boolean isSelected() {
        return selected;
    }

    @Override
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
