import javax.swing.*;

class App {
    private static void initWindow() {
        JFrame window = new JFrame("Window");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Screen screen = new Screen();
        window.add(screen);
        window.pack();
        window.addKeyListener(screen);
        window.setVisible(true);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            initWindow();
        }
    });
  }
}
