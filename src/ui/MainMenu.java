import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    private GameUI gameUI;

    public MainMenu(GameUI gameUI) {
        this.gameUI = gameUI;

        setTitle("Heroes of Java - Main Menu");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        JButton optionsButton = new JButton("Options");
        JButton exitButton = new JButton("Exit");

        panel.add(startButton);
        panel.add(optionsButton);
        panel.add(exitButton);

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gameUI.setVisible(true);
                dispose();
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
