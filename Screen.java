import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;


public class Screen extends JPanel implements ActionListener, KeyListener {
    private final int DELAY = 25;
    private Timer timer;
    private Littguy littguy;
    public int Screensize = 500;
    private ArrayList<Obstacle> obstacles;

    public Screen() {
      setPreferredSize(new Dimension(Screensize, Screensize));
      setBackground(new Color(232, 232, 232));
      littguy = new Littguy();
      obstacles = drawObstacles(200, 300, 200, 200);
      timer = new Timer(DELAY, this);
      timer.start();
  }
  @Override
  public void actionPerformed(ActionEvent e) {
      littguy.tick();
      repaint();
  }
  @Override
  public void paintComponent(Graphics g) {
      super.paintComponent(g);
      for (Obstacle obstacle : obstacles){
        obstacle.draw(g, this);
      }
      littguy.draw(g, this);

      Toolkit.getDefaultToolkit().sync();
  }

  public void drawObstacles(int x1, int x2, int y1, int y2) {
    if (x1 < x2){
    for (int i = 0; i < Math.abs(x1 - x2) / 50; i++) {
      ManageOL(50 * i + x1, y1);
    }
  
    } else if (x1 > x2) {
      for (int i = 0; i < Math.abs(x2 - x1) / 50; i++) {
        ManageOL(50 * i + x1, y1); 
    }
  }
}

 public ArrayList<Obstacle> ManageOL(int x_, int y_) {
  ArrayList<Obstacle> ObstacleList = new ArrayList<>();
  ObstacleList.add(new Obstacle(x_, y_));
  return ObstacleList;
 }
  @Override
  public void keyTyped(KeyEvent e) {
  }

  @Override
  public void keyPressed(KeyEvent e) {
      littguy.keyPressed(e);
      
  }

  @Override
  public void keyReleased(KeyEvent e) {
  }
}

