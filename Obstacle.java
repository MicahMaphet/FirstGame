import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

public class Obstacle {

    private BufferedImage image;
    private Point pos;

    public Obstacle(int x, int y) {
        loadImage();
        pos = new Point(x, y);
    }
    private void loadImage() {
        try {
            image = ImageIO.read(new File("images/Black Square.png")); //50 by 50 pixels
        } catch (IOException exc) {
            System.out.println("Error opening image file: " + exc.getMessage());
        }
    }
    public void draw(Graphics g, ImageObserver observer) {
        g.drawImage(
            image, 
            pos.x, 
            pos.y, 
            observer
        );
    }

    public Point getPos() {
        return pos;
    }
}
