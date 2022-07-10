package bwgames.learning.lanterna;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;

public class MyWindow extends BasicWindow {
    public MyWindow() {
        super("Hello World - my new window in a console!");

        Panel horizontalPanel = new Panel();
        horizontalPanel.setLayoutManager(new LinearLayout(Direction.HORIZONTAL));
        Panel leftPanel = new Panel();
        Panel middlePanel = new Panel();
        Panel rightPanel = new Panel();

        horizontalPanel.addComponent(leftPanel);
        horizontalPanel.addComponent(middlePanel);
        horizontalPanel.addComponent(rightPanel);
//        horizontalPanel.addComponent(Borders.singleLineBevel("Panel Title"));
//        horizontalPanel.addComponent(Borders.doubleLineBevel("Other bevel"));

        // This ultimately links in the panels as the window content
        setComponent(horizontalPanel);

        Panel contentPane = new Panel();
        contentPane.setLayoutManager(new LinearLayout(Direction.VERTICAL));
        contentPane.addComponent(new Label("This is the first label"));
        contentPane.addComponent(new Label("This is the second label, red").setForegroundColor(TextColor.ANSI.RED));
        contentPane.addComponent(new Label("This is the last label\nSpanning\nMultiple\nRows"));

        contentPane.addComponent(new Button("Exit", new Runnable() {
            @Override
            public void run() {
                MyWindow.this.close();
            }
        }));

        contentPane.addComponent(new Button("Prev", new Runnable() {
            @Override
            public void run() {
                MyWindow.this.close();
            }
        }));

        contentPane.addComponent(new Button("Next", new Runnable() {
            @Override
            public void run() {
                MyWindow.this.close();
            }
        }));


        setComponent(contentPane);
    }
}
