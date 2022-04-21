import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Screen extends JPanel implements ActionListener, KeyListener {
    private final int DELAY = 25;
    private Timer timer;
    private Littguy littguy;
    public int Screensize = 500;

    public Screen() {
      setPreferredSize(new Dimension(Screensize, Screensize));
      setBackground(new Color(232, 232, 232));
      littguy = new Littguy();
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
      littguy.draw(g, this);
      Toolkit.getDefaultToolkit().sync();
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
    littguy.keyReleased(e);
  }
}

