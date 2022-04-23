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
      obstacles = drawObstacles();
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
  public ArrayList<Obstacle> drawObstacles() {
    ArrayList<Obstacle> ObstacleList = new ArrayList<>();
      ObstacleList.add(new Obstacle(0, 100));
      ObstacleList.add(new Obstacle(50, 100));
      ObstacleList.add(new Obstacle(100, 100));
      ObstacleList.add(new Obstacle(150, 100));
      ObstacleList.add(new Obstacle(200, 100));
      ObstacleList.add(new Obstacle(250, 100));
      ObstacleList.add(new Obstacle(300, 100));
      // another wall
      ObstacleList.add(new Obstacle(400, 0));
      ObstacleList.add(new Obstacle(400, 50));
      ObstacleList.add(new Obstacle(400, 100));
      ObstacleList.add(new Obstacle(400, 150));

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

