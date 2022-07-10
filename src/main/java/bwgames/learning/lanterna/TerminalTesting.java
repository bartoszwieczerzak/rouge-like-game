package bwgames.learning.lanterna;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.TerminalResizeListener;

import java.io.IOException;
/*
 *
 * Lanterna:
 *
 * Repository:
 * https://github.com/mabe02/lanterna
 *
 * Tutorials:
 * https://github.com/mabe02/lanterna/blob/master/docs/contents.md
 */

public class TerminalTesting {
    public static void main(String[] args) {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        Terminal terminal = null;
        try {
//            terminal = new FullScreenSwingTerminalFrame();
            terminal = defaultTerminalFactory.createTerminal();
//            terminal = defaultTerminalFactory.createSwingTerminal();

            terminal.enterPrivateMode();
            terminal.setCursorVisible(false);

            final TextGraphics textGraphics = terminal.newTextGraphics();

            textGraphics.setForegroundColor(TextColor.ANSI.WHITE);
            textGraphics.setBackgroundColor(TextColor.ANSI.BLACK);

            textGraphics.putString(2, 1, "Lanterna Tutorial 2 - Press ESC to exit", SGR.BOLD);
            textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
            textGraphics.setBackgroundColor(TextColor.ANSI.DEFAULT);
            textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
            textGraphics.putString(5 + "Terminal Size: ".length(), 3, terminal.getTerminalSize().toString());

            terminal.flush();




            terminal.addResizeListener(new TerminalResizeListener() {
                @Override
                public void onResized(Terminal terminal, TerminalSize newSize) {
                    // Be careful here though, this is likely running on a separate thread. Lanterna is threadsafe in
                    // a best-effort way so while it shouldn't blow up if you call terminal methods on multiple threads,
                    // it might have unexpected behavior if you don't do any external synchronization
                    textGraphics.drawLine(5, 3, newSize.getColumns() - 1, 3, ' ');
                    textGraphics.putString(5, 3, "Terminal Size: ", SGR.BOLD);
                    textGraphics.putString(5 + "Terminal Size: ".length(), 3, newSize.toString());
                    try {
                        terminal.flush();
                    }
                    catch(IOException e) {
                        // Not much we can do here
                        throw new RuntimeException(e);
                    }
                }
            });

            textGraphics.putString(5, 4, "Last Keystroke: ", SGR.BOLD);
            textGraphics.putString(5 + "Last Keystroke: ".length(), 4, "<Pending>");
            terminal.flush();


            System.out.println("READING INPUT");
            KeyStroke keyStroke = terminal.readInput();
            System.out.println("AFTER READING INPUT");

            while(keyStroke.getKeyType() != KeyType.Escape) {
                textGraphics.drawLine(5, 4, terminal.getTerminalSize().getColumns() - 1, 4, ' ');
                textGraphics.putString(5, 4, "Last Keystroke: ", SGR.BOLD);
                textGraphics.putString(5 + "Last Keystroke: ".length(), 4, keyStroke.toString());
                terminal.flush();
                keyStroke = terminal.readInput();
            }

            Thread.sleep(1);
            terminal.exitPrivateMode();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            if(terminal != null) {
                try {
                    terminal.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
