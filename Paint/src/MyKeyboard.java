import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class MyKeyboard implements KeyboardHandler {

    Keyboard kb = new Keyboard(this);
    Grid.MyCube myCube;
    Grid grid;

    private boolean isDPressed;
    public MyKeyboard(Grid.MyCube myCube, Grid grid){
        this.myCube = myCube;
        this.grid = grid;
    }
    public void handler() {

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);
        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);
        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);
        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);
        kb.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);
        kb.addEventListener(space);

        KeyboardEvent d = new KeyboardEvent();
        d.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        d.setKey(KeyboardEvent.KEY_D);
        kb.addEventListener(d);

        KeyboardEvent drel = new KeyboardEvent();
        drel.setKeyboardEventType(KeyboardEventType.KEY_RELEASED);
        drel.setKey(KeyboardEvent.KEY_D);
        kb.addEventListener(drel);

        KeyboardEvent s = new KeyboardEvent();
        s.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        s.setKey(KeyboardEvent.KEY_S);
        kb.addEventListener(s);

        KeyboardEvent p = new KeyboardEvent();
        p.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        p.setKey(KeyboardEvent.KEY_P);
        kb.addEventListener(p);



    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()){
            case KeyboardEvent.KEY_RIGHT ->{
                    grid.myCubePosition(1);
                    myCube.getRectangle().translate(grid.getPixelSize(), 0);
                    if (isDPressed){
                        myCube.paint(Color.BLACK);
                    }
            }
            case KeyboardEvent.KEY_LEFT -> {
                grid.myCubePosition(2);
                myCube.getRectangle().translate(-grid.getPixelSize(), 0);
                if (isDPressed){
                    myCube.paint(Color.BLACK);
                }
            }
            case KeyboardEvent.KEY_UP -> {
                grid.myCubePosition(3);
                myCube.getRectangle().translate(0,-grid.getPixelSize());
                if (isDPressed){
                    myCube.paint(Color.BLACK);
                }
            }
            case KeyboardEvent.KEY_DOWN ->{
                grid.myCubePosition(4);
                myCube.getRectangle().translate(0, grid.getPixelSize());
                if (isDPressed){
                    myCube.paint(Color.BLACK);
                }
            }
            case KeyboardEvent.KEY_D -> {
                myCube.paint(Color.BLACK);
                isDPressed = true;
            }
            case KeyboardEvent.KEY_SPACE -> myCube.clear();
            case KeyboardEvent.KEY_S -> myCube.save();
            case KeyboardEvent.KEY_P -> myCube.print();
        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_D -> isDPressed = false;
        }
    }
}
