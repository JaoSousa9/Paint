public class Paint {
    private Grid grid = new Grid();
    private MyKeyboard myKeyboard = new MyKeyboard(grid.myCube, grid);
    public void initPaint(){
        myKeyboard.handler();
    }

}
