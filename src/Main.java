import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Hero hero = new Warrior("Aragon", 1);
                GameUI gameUI = new GameUI(hero);
                JFrame frame = new JFrame("Heroes of Java");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(800, 600);
                frame.add(gameUI);
                frame.setVisible(true);
            }
        });
    }
}
