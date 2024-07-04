import javax.swing.SwingUtilities;
import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame customizationFrame = new JFrame("Character Customization");
                customizationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                customizationFrame.setSize(400, 200);
                customizationFrame.add(new CharacterCustomizationUI());
                customizationFrame.setVisible(true);
            }
        });
    }
}
