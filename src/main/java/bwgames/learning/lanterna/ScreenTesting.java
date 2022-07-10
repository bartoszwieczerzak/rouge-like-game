package bwgames.learning.lanterna;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.InputProvider;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.SwingTerminalFrame;

import java.io.IOException;

public class ScreenTesting {
    public static void main(String[] args) {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

//        TerminalScreen
        Screen screen = null;
        try {
            screen = defaultTerminalFactory.createScreen();

            screen.startScreen();

            TextGraphics textGraphics = screen.newTextGraphics();
            textGraphics.setForegroundColor(TextColor.ANSI.RED);
            textGraphics.setBackgroundColor(TextColor.ANSI.GREEN);
            textGraphics.putString(10, 5, "Hello Lanterna!");

            screen.refresh();

            KeyStroke character = screen.readInput();
            System.out.println(character.getCharacter().toString());

            textGraphics.putString(8, 5, character.getCharacter().toString());

            screen.refresh();

            Thread.sleep(5000);
            screen.stopScreen();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
