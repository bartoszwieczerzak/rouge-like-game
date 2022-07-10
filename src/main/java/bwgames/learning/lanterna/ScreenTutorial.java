package bwgames.learning.lanterna;

import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;

import java.io.IOException;
import java.util.Random;

public class ScreenTutorial {
    public static void main(String[] args) {
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory();

//        TerminalScreen
        Screen screen = null;
        try {
            screen = defaultTerminalFactory.createScreen();

            screen.startScreen();
            screen.setCursorPosition(null);


            while(true) {
                KeyStroke keyStroke = screen.pollInput();
                Random random = new Random();
                TerminalSize terminalSize = screen.getTerminalSize();
                for(int column = 0; column < terminalSize.getColumns(); column++) {
                    for(int row = 0; row < terminalSize.getRows(); row++) {
                        screen.setCharacter(column, row, new TextCharacter(
                                ' ',
                                TextColor.ANSI.DEFAULT,
                                // This will pick a random background color
                                TextColor.ANSI.values()[random.nextInt(TextColor.ANSI.values().length)]));
                    }
                }

                if (keyStroke != null && (keyStroke.getKeyType() == KeyType.Escape || keyStroke.getKeyType() == KeyType.EOF)) {
                    break;
                }

                TerminalSize newSize = screen.doResizeIfNecessary();
                if(newSize != null) {
                    terminalSize = newSize;
                }

                // Increase this to increase speed
                final int charactersToModifyPerLoop = 1;
                for(int i = 0; i < charactersToModifyPerLoop; i++) {
                    TerminalPosition cellToModify = new TerminalPosition(
                            random.nextInt(terminalSize.getColumns()),
                            random.nextInt(terminalSize.getRows()));
                    TextColor.ANSI color = TextColor.ANSI.values()[random.nextInt(TextColor.ANSI.values().length)];

                    TextCharacter characterInBackBuffer = screen.getBackCharacter(cellToModify);
                    characterInBackBuffer = characterInBackBuffer.withBackgroundColor(color);
                    characterInBackBuffer = characterInBackBuffer.withCharacter(' ');   // Because of the label box further down, if it shrinks
                    screen.setCharacter(cellToModify, characterInBackBuffer);
                }

                String sizeLabel = "Terminal Size: " + terminalSize;
                TerminalPosition labelBoxTopLeft = new TerminalPosition(1, 1);
                TerminalSize labelBoxSize = new TerminalSize(sizeLabel.length() + 2, 3);
                TerminalPosition labelBoxTopRightCorner = labelBoxTopLeft.withRelativeColumn(labelBoxSize.getColumns() - 1);
                TextGraphics textGraphics = screen.newTextGraphics();
                //This isn't really needed as we are overwriting everything below anyway, but just for demonstrative purpose
                textGraphics.fillRectangle(labelBoxTopLeft, labelBoxSize, ' ');

                textGraphics.drawLine(
                        labelBoxTopLeft.withRelativeColumn(1),
                        labelBoxTopLeft.withRelativeColumn(labelBoxSize.getColumns() - 2),
                        Symbols.DOUBLE_LINE_HORIZONTAL);
                textGraphics.drawLine(
                        labelBoxTopLeft.withRelativeRow(2).withRelativeColumn(1),
                        labelBoxTopLeft.withRelativeRow(2).withRelativeColumn(labelBoxSize.getColumns() - 2),
                        Symbols.DOUBLE_LINE_HORIZONTAL);

                textGraphics.setCharacter(labelBoxTopLeft, Symbols.DOUBLE_LINE_TOP_LEFT_CORNER);
                textGraphics.setCharacter(labelBoxTopLeft.withRelativeRow(1), Symbols.DOUBLE_LINE_VERTICAL);
                textGraphics.setCharacter(labelBoxTopLeft.withRelativeRow(2), Symbols.DOUBLE_LINE_BOTTOM_LEFT_CORNER);
                textGraphics.setCharacter(labelBoxTopRightCorner, Symbols.DOUBLE_LINE_TOP_RIGHT_CORNER);
                textGraphics.setCharacter(labelBoxTopRightCorner.withRelativeRow(1), Symbols.DOUBLE_LINE_VERTICAL);
                textGraphics.setCharacter(labelBoxTopRightCorner.withRelativeRow(2), Symbols.DOUBLE_LINE_BOTTOM_RIGHT_CORNER);

                textGraphics.putString(labelBoxTopLeft.withRelative(1, 1), sizeLabel);

                screen.refresh();
                Thread.yield();
            }

            screen.stopScreen();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
