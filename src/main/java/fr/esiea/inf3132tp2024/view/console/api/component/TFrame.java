package fr.esiea.inf3132tp2024.view.console.api.component;

import fr.esiea.inf3132tp2024.old.event.key.KeyListener;
import fr.esiea.inf3132tp2024.old.event.key.KeyPressedEvent;
import fr.esiea.inf3132tp2024.utils.StringUtils;

// ┌┐└┘├┤─│┴┯
public class TFrame extends TComponent implements KeyListener {
    private TPanel header;
    private TPanel contentPane;
    private TPanel footer;

    public TFrame(int length, int height) {
        super(null, length, height);

        this.contentPane = new TPanel(0, 0);

        autoResize();
    }

    public TFrame(int length, int height, String title) {
        this(length, height);

        String[] titleLines = StringUtils.convertStringToStringArray(title);
        TPanel header = new TPanel(0, titleLines.length);
        header.getComponents().add(new TLabel(titleLines));

        setHeader(header);
    }

    @Override
    public String[] render() {
        String[] result = new String[this.getHeight()];
        int linePointer = 0;

        linePointer = renderAddLine(result, linePointer, '┌' + "─".repeat(this.getLength() - 2) + '┐');

        // Header
        if (this.header != null && this.header.getHeight() > 0) {
            String[] headerRender = this.header.render();
            for (String line : headerRender) {
                linePointer = renderAddLine(result, linePointer, '│' + line + '│');
            }
            linePointer = renderAddLine(result, linePointer, '├' + "─".repeat(this.getLength() - 2) + '┤');
        }

        // Content
        for (String line : contentPane.render()) {
            linePointer = renderAddLine(result, linePointer, '│' + line + '│');
        }

        // Footer
        if (this.footer != null && this.footer.getHeight() > 0) {
            linePointer = renderAddLine(result, linePointer, '├' + "─".repeat(this.getLength() - 2) + '┤');
            String[] footerRender = this.footer.render();
            for (String line : footerRender) {
                linePointer = renderAddLine(result, linePointer, '│' + line + '│');
            }
        }

        renderAddLine(result, linePointer, '└' + "─".repeat(this.getLength() - 2) + '┘');

        return result;
    }

    private int renderAddLine(String[] lines, int linePointer, String line) {
        if (!(linePointer < lines.length)) {
            return linePointer;
        }

        lines[linePointer] = line;
        return ++linePointer;
    }

    @Override
    public void onKeyPressed(KeyPressedEvent event) {
        if (this.header != null) {
            this.header.onKeyPressed(event);
        }
        this.contentPane.onKeyPressed(event);
        if (this.footer != null) {
            this.footer.onKeyPressed(event);
        }
    }

    public TPanel getHeader() {
        return header;
    }

    public void setHeader(TPanel header) {
        this.header = header;

        autoResize();
    }

    public TPanel getContentPane() {
        return contentPane;
    }

    public void setContentPane(TPanel contentPane) {
        this.contentPane = contentPane;

        autoResize();
    }

    public TPanel getFooter() {
        return footer;
    }

    public void setFooter(TPanel footer) {
        this.footer = footer;

        autoResize();
    }

    @Override
    public void setLength(int length) {
        super.setLength(length);

        autoResize();
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);

        autoResize();
    }

    private void autoResize() {
        int contentHeight = this.getHeight() - 2;
        if (this.header != null && this.header.getHeight() > 0) {
            contentHeight -= this.header.getHeight();
            contentHeight--;
        }
        if (this.footer != null && this.footer.getHeight() > 0) {
            contentHeight -= this.footer.getHeight();
            contentHeight--;
        }
        if (contentHeight < 0) {
            contentHeight = 0;
        }
        this.contentPane.setHeight(contentHeight);

        int length = this.getLength() - 2;
        if (length < 0) {
            length = 0;
        }
        if (this.header != null) {
            this.header.setLength(length);
        }
        this.contentPane.setLength(length);
        if (this.footer != null) {
            this.footer.setLength(length);
        }
    }
}
