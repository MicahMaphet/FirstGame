
import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.awt.event.KeyEvent;

public class Littguy {
    public int LitVolVer; //The class littguy's verticle volocity
    public int LitVolHor; //The class littguy's horizontal volocity
    int slow;
    private BufferedImage image;
    private Point pos;
    public Littguy() {
        loadImage();
        pos = new Point(100, 100);
    }


    private void loadImage() {    
        try {
            image = ImageIO.read(new File("images/littguy.png"));
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

    public void keyPressed(KeyEvent e) {

        slow = 0;
        int key = e.getKeyCode();
                if (key == KeyEvent.VK_UP) {
                    LitVolVer--; 
        }
        if (key == KeyEvent.VK_RIGHT) {
                    LitVolHor++;
        }
        if (key == KeyEvent.VK_DOWN) {
                    LitVolVer++;
        }
        if (key == KeyEvent.VK_LEFT) {
                    LitVolHor--;
        }

    }

    public void keyReleased(KeyEvent e) {
        slow = 1;
    }


    public void tick() {
        pos.translate(LitVolHor, LitVolVer);  
        if (slow == 1) {          
        slow();
        }

    
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x >= 2000) {
            pos.x = pos.x - 1;
        }
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y >= 1000) {
            pos.y = pos.y - 1;
               }
    }

    public void slow() {
        if (LitVolHor < 0) {
            LitVolHor++;
        } else if (LitVolHor > 0) {
            LitVolHor--;
        }
        if (LitVolVer < 0) {
            LitVolVer++;
        } else if (LitVolVer > 0) {
            LitVolVer--;
        }
    }
    public Point getPos() {
        return pos;
    }

 }
