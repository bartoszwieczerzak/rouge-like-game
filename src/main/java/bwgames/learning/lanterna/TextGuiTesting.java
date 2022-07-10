package bwgames.learning.lanterna;

import com.googlecode.lanterna.gui2.MultiWindowTextGUI;
import com.googlecode.lanterna.gui2.TextGUIThread;
import com.googlecode.lanterna.gui2.Window;
import com.googlecode.lanterna.gui2.WindowBasedTextGUI;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TextGuiTesting {
    public static void main(String[] args) {

        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();
            Screen screen = new TerminalScreen(terminal);
            WindowBasedTextGUI gui = new MultiWindowTextGUI(screen);
            screen.startScreen();

            MyWindow myWindow = new MyWindow();
            List<Window.Hint> windowHints = new ArrayList<>();
            windowHints.add(Window.Hint.CENTERED);
            myWindow.setHints(windowHints);
            gui.addWindow(myWindow);
            myWindow.waitUntilClosed();
//            gui.getGUIThread().processEventsAndUpdate();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if (terminal != null) {
                try {
                    terminal.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
