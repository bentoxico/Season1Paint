package org.academiadecodigo.heroisdovar;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

public class Cursor {

    private Ellipse cursor;

    private TileManager tileManager;

    public Cursor(TileManager tileManager) {
        this.tileManager = tileManager;
        new InputHandler();
        cursor = new Ellipse(Grid.PADDING, Grid.PADDING, Grid.cellSize, Grid.cellSize);
        cursor.setColor(Color.MAGENTA);
        cursor.fill();
    }


    public class InputHandler implements KeyboardHandler {
        private KeyboardEvent[] events;
        public final Keyboard keyboard;

        public InputHandler() {
            keyboard = new Keyboard(this);
            createEvents();
        }


        private void createEvents() {
            events = new KeyboardEvent[15];

            for (int i = 0; i < events.length; i++) {
                events[i] = new KeyboardEvent();
            }
            events[0].setKey(KeyboardEvent.KEY_SPACE);
            events[1].setKey(KeyboardEvent.KEY_UP);
            events[2].setKey(KeyboardEvent.KEY_DOWN);
            events[3].setKey(KeyboardEvent.KEY_LEFT);
            events[4].setKey(KeyboardEvent.KEY_RIGHT);
            events[5].setKey(KeyboardEvent.KEY_D);
            events[6].setKey(KeyboardEvent.KEY_S);
            events[7].setKey(KeyboardEvent.KEY_L);
            events[8].setKey(KeyboardEvent.KEY_C);
            events[9].setKey(KeyboardEvent.KEY_1);
            events[10].setKey(KeyboardEvent.KEY_2);
            events[11].setKey(KeyboardEvent.KEY_3);
            events[12].setKey(KeyboardEvent.KEY_4);
            events[13].setKey(KeyboardEvent.KEY_5);
            events[14].setKey(KeyboardEvent.KEY_ESC);

            for (int i = 0; i < events.length; i++) {
                events[i].setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
                keyboard.addEventListener(events[i]);
            }

            KeyboardEvent keyboardEventSpaceRelease = new KeyboardEvent();
            keyboardEventSpaceRelease.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
            keyboardEventSpaceRelease.setKey(KeyboardEvent.KEY_SPACE);
            keyboard.addEventListener(keyboardEventSpaceRelease);

        }

        @Override
        public void keyPressed(KeyboardEvent keyboardEvent) {

            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_UP:
                    if (cursor.getY() > Grid.PADDING) {
                        cursor.translate(0, -Grid.cellSize);
                    }
                    if (tileManager.isPainting()) {
                        tileManager.paintTile(cursor);
                    }
                    break;
                case KeyboardEvent.KEY_DOWN:
                    if (cursor.getY() + Grid.cellSize < Grid.gridHeight) {
                        cursor.translate(0, Grid.cellSize);
                    }
                    if (tileManager.isPainting()) {
                        tileManager.paintTile(cursor);
                    }
                    break;
                case KeyboardEvent.KEY_LEFT:
                    if (cursor.getX() > Grid.PADDING) {
                        cursor.translate(-Grid.cellSize, 0);
                    }
                    if (tileManager.isPainting()) {
                        tileManager.paintTile(cursor);
                    }
                    break;
                case KeyboardEvent.KEY_RIGHT:
                    if (cursor.getX() + Grid.cellSize < Grid.gridWidth) {
                        cursor.translate(Grid.cellSize, 0);
                    }
                    if (tileManager.isPainting()) {
                        tileManager.paintTile(cursor);
                    }
                    break;
                case KeyboardEvent.KEY_SPACE:
                    tileManager.setPainting(true);
                    break;
                case KeyboardEvent.KEY_D:
                    tileManager.eraseTile(cursor);
                    break;
                case KeyboardEvent.KEY_S:
                    try {
                        tileManager.save("src/org/academiadecodigo/heroisdovar/grid.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case KeyboardEvent.KEY_L:
                    try {
                        tileManager.loadLastSave("src/org/academiadecodigo/heroisdovar/grid.txt");
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case KeyboardEvent.KEY_C:
                    tileManager.clearAll();
                    break;
                case KeyboardEvent.KEY_ESC:
                    System.out.println("Bye have a great time!!");
                    System.exit(0);
                    break;
                case KeyboardEvent.KEY_1:
                    tileManager.paintSpecificColor(Color.BLACK);
                    break;
                case KeyboardEvent.KEY_2:
                    tileManager.paintSpecificColor(Color.RED);
                    break;
                case KeyboardEvent.KEY_3:
                    tileManager.paintSpecificColor(Color.BLUE);
                    break;
                case KeyboardEvent.KEY_4:
                    tileManager.paintSpecificColor(Color.YELLOW);
                    break;
                case KeyboardEvent.KEY_5:
                    tileManager.paintSpecificColor(Color.GREEN);
                    break;
            }

        }

        @Override
        public void keyReleased(KeyboardEvent keyboardEvent) {
            switch (keyboardEvent.getKey()) {
                case KeyboardEvent.KEY_SPACE:
                    tileManager.setPainting(false);
            }
        }
    }
}