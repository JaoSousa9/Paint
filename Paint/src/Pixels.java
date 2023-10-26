import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Pixels {

    private final Rectangle rectangle;
    private boolean painted = false;
    public Pixels(int x, int y, int width, int height){
            rectangle = new Rectangle(x,y,width,height);
    }
    public Rectangle getRectangle() {
        return rectangle;
    }
    public void setPainted(boolean painted) {
        this.painted = painted;
    }
    public boolean isPainted() {
        return painted;
    }
}
