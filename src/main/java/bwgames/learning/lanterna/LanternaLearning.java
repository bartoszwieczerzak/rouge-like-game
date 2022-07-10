package bwgames.learning.lanterna;

import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

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

public class LanternaLearning {
    public static void main(String[] args) {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

        Terminal terminal = null;
        try {
            terminal = defaultTerminalFactory.createTerminal();

            terminal.enterPrivateMode();

            terminal.putCharacter('H');
            terminal.putCharacter('e');
            terminal.setCursorPosition(10, 5);
            terminal.enableSGR(SGR.BLINK);
            terminal.setForegroundColor(TextColor.ANSI.RED);
            terminal.setBackgroundColor(TextColor.ANSI.BLUE);
            terminal.putCharacter('l');
            terminal.putCharacter('l');
            terminal.putCharacter('o');
            terminal.setForegroundColor(TextColor.ANSI.DEFAULT);
            terminal.setBackgroundColor(TextColor.ANSI.DEFAULT);
            terminal.disableSGR(SGR.BLINK);
            terminal.putCharacter('\n');
            terminal.flush();
            terminal.bell();

            Thread.sleep(2000);
            terminal.clearScreen();
            Thread.sleep(2000);
            terminal.exitPrivateMode();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
