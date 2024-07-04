import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Hero hero = new Warrior("Aragon", 1);
                GameUI gameUI = new GameUI(hero);
                new MainMenu(gameUI).setVisible(true);
            }
        });
    }
}
