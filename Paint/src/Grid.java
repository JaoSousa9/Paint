import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.io.*;
import java.util.LinkedList;

public class Grid {
    public MyCube myCube = new MyCube();
    private final int pixelSize = myCube.getRectangle().getWidth();
    private final int cols = 30;
    private final int rows = 30;
    private final Rectangle rectangle = new Rectangle(0, 0, pixelSize * cols, pixelSize * rows);
    private final int pixelsNumber = (rectangle.getWidth() / pixelSize) * (rectangle.getHeight() / pixelSize);
    private final Pixels[] pixels = new Pixels[pixelsNumber];
    private int myCubeposition = 0;

    public Grid() {
        for (int row = 0; row < (rectangle.getHeight()); row += pixelSize) {
            drawLine(row);
        }
        drawCube();
        myCube.print();
    }

    private void drawCube() {
        myCube.getRectangle().setColor(Color.GREEN);
        myCube.getRectangle().fill();
    }

    private void drawLine(int row) {
        int x = 0;
        int j = cols * (row / pixelSize);
        for (int i = row; i < row + cols; i++) {
            pixels[j] = new Pixels(10 + x, 10 + row, pixelSize, pixelSize);
            pixels[j].getRectangle().draw();
            x += pixelSize;
            j++;
        }
    }

    public void myCubePosition(int n) {
        switch (n) {
            case 1 -> myCubeposition++;
            case 2 -> myCubeposition--;
            case 3 -> myCubeposition -= rows;
            case 4 -> myCubeposition += rows;
        }
    }

    public int getPixelSize() {
        return pixelSize;
    }

    public class MyCube {
        int size = 20;
        private final Rectangle rectangle = new Rectangle(10, 10, size, size);

        public Rectangle getRectangle() {
            return rectangle;
        }

        public void paint(Color color) {
            if (!pixels[myCubeposition].isPainted()) {
                pixels[myCubeposition].setPainted(true);
                pixels[myCubeposition].getRectangle().setColor(color);
                pixels[myCubeposition].getRectangle().fill();
            } else {
                pixels[myCubeposition].getRectangle().draw();
                pixels[myCubeposition].setPainted(false);
            }
        }

        public void clear() {
            for (Pixels pix : pixels) {
                pix.getRectangle().draw();
                pix.setPainted(false);
            }
        }

        public void save() {
            String saved = "";
            for (int i = 0; i < pixelsNumber; i++) {
                if (pixels[i].isPainted()) {
                    saved += "1";
                } else {
                    saved += "0";
                }
            }
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter("./save.txt"));
                writer.write(saved);
                writer.flush();
                writer.close();
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
        }

        public void print() {
            clear();
            String saved[] = new String[pixelsNumber];

            try {
                FileReader reader = new FileReader("./save.txt");
                // READS TEXT FROM CHARACTER-INPUT
                BufferedReader bReader = new BufferedReader(reader);

                String line = "";

                // RETURNS EVERYTHING IN ONE SINGLE STRING
                while ((line = bReader.readLine()) != null) {
                    saved = line.split("");
                }
                bReader.close();
            } catch (IOException f) {
                System.out.println(f.getMessage());
            }
            for (int i = 0; i < pixelsNumber; i++) {
                if (saved[i].equals("1")) {
                    System.out.println("Estou aqui");
                    pixels[i].setPainted(true);
                    pixels[i].getRectangle().setColor(Color.BLACK);
                    pixels[i].getRectangle().fill();
                } else {
                    pixels[i].getRectangle().draw();
                }
            }
        }

    }
}
