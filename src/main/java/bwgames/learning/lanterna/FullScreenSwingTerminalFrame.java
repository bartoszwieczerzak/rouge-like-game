package bwgames.learning.lanterna;

import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

public class FullScreenSwingTerminalFrame extends SwingTerminalFrame {
    public FullScreenSwingTerminalFrame() {
        super();
        this.setExtendedState(this.MAXIMIZED_BOTH);
    }
}
