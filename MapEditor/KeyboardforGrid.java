package org.academiadecodigo.MapEditor;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.io.IOException;

import static org.academiadecodigo.MapEditor.Directions.*;

/**
 * Created by tomasamaro on 26/10/16.
 */
public class KeyboardforGrid implements KeyboardHandler {

    private Keyboard keyboard;
    private MapEditor mapEditor;

    public KeyboardforGrid(MapEditor mapEditor) {
        this.mapEditor = mapEditor;
        start();
    }

    public void start(){
        keyboard = new Keyboard(this);
        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent space = new KeyboardEvent();
        space.setKey(KeyboardEvent.KEY_SPACE);
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(space);

        KeyboardEvent c = new KeyboardEvent();
        c.setKey(KeyboardEvent.KEY_C);
        c.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(c);

        KeyboardEvent s = new KeyboardEvent();
        s.setKey(KeyboardEvent.KEY_S);
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(s);
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        System.out.println("Key Pressed");

        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_UP:
                mapEditor.getCursor().move(UP);
                break;
            case KeyboardEvent.KEY_DOWN:
                mapEditor.getCursor().move(DOWN);
                break;
            case KeyboardEvent.KEY_LEFT:
                mapEditor.getCursor().move(LEFT);
                break;
            case KeyboardEvent.KEY_RIGHT:
                mapEditor.getCursor().move(RIGHT);
                break;
            case KeyboardEvent.KEY_SPACE:
                mapEditor.toggleCell(Color.GREEN);
                //mapEditor.eraseCell();

                break;
            case KeyboardEvent.KEY_C:
                mapEditor.toggleCell(Color.RED);
                break;
            case KeyboardEvent.KEY_S:
                try {
                    mapEditor.saveFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;

            default:
                System.out.println("Something went wrong on the KeyPressed switch");

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
