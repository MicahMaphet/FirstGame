
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
    private BufferedImage image;
    private Point pos;
    public Littguy() {
        loadImage();
        pos = new Point(0, 0);
    }


    private void loadImage() {    
        try {
            image = ImageIO.read(new File("images/littguy.png")); //50 by 50 pixels
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
       final int KickSpeed = 5;
       int key = e.getKeyCode();
//The Code below is just giving an initial kick of speed
       if (LitVolVer > KickSpeed * -1) {
       if (key == KeyEvent.VK_UP) {
                   LitVolVer = LitVolVer - KickSpeed; 
       }
    }
       if (LitVolHor < KickSpeed) {
       if (key == KeyEvent.VK_RIGHT) {
                   LitVolHor = LitVolHor + KickSpeed;
       }
    }
       if (LitVolVer < KickSpeed) {
       if (key == KeyEvent.VK_DOWN) {
                   LitVolVer = LitVolHor + KickSpeed;
       }
    }
       if (LitVolHor > KickSpeed * -1) {
       if (key == KeyEvent.VK_LEFT) {
                   LitVolHor = LitVolHor - KickSpeed;
       }
    }
//This code is the acceleration/main-movement
       if (key == KeyEvent.VK_UP) {
                   LitVolVer--; 
       } else if  (key == KeyEvent.VK_W) {
                   LitVolVer--; 
       }
       if (key == KeyEvent.VK_RIGHT) {
                   LitVolHor++;
       } else if  (key == KeyEvent.VK_D) {
                   LitVolHor++;
       }
       if (key == KeyEvent.VK_DOWN) {
                   LitVolVer++;
       } else if  (key == KeyEvent.VK_S) {
                   LitVolVer++;
       }
       if (key == KeyEvent.VK_LEFT) {
                   LitVolHor--;
       } else if  (key == KeyEvent.VK_A) {
                   LitVolHor--;
       }
   }
//the code within tick is constantly being activitated (or should be)
    public void tick() {
        pos.translate(LitVolHor, LitVolVer);  
        final int LGSpeedLimit = 20;
//limit speed
        if (LitVolHor < LGSpeedLimit * -1) {
            LitVolHor = LGSpeedLimit * -1;
        }
        if (LitVolVer < LGSpeedLimit * -1) {
            LitVolVer = LGSpeedLimit * -1;
        }
        if (LitVolHor > LGSpeedLimit) {
            LitVolHor = LGSpeedLimit;
        }
        if (LitVolVer > LGSpeedLimit) {
            LitVolVer = LGSpeedLimit;
        }
//slow down
        if (LitVolHor < 0) {
            LitVolHor = LitVolHor + 1;
        } else if (LitVolHor > 0) {
            LitVolHor = LitVolHor - 1;
        }
        if (LitVolVer < 0) {
            LitVolVer = LitVolVer + 1;
        } else if (LitVolVer > 0) {
            LitVolVer = LitVolVer - 1;
        }
//collision boarder
        if (pos.x < 0) {
            pos.x = 0;
        } else if (pos.x > 1850) {
            pos.x = 1850;
        }
        if (pos.y < 0) {
            pos.y = 0;
        } else if (pos.y > 950) {
            pos.y = 950;
         }
//collision on obstacles
    }


    public Point getPos() {
        return pos;
    }

 }
