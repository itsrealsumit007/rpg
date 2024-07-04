import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoadGameUI extends JPanel {
    private JFrame mainFrame;

    public LoadGameUI(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new GridLayout(5, 1));

        for (int i = 1; i <= 3; i++) {
            JButton loadSlotButton = new JButton("Load Slot " + i);
            loadSlotButton.addActionListener(new LoadSlotActionListener(i));
            add(loadSlotButton);
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mainFrame.dispose();
            }
        });
        add(backButton);
    }

    private class LoadSlotActionListener implements ActionListener {
        private int slot;

        public LoadSlotActionListener(int slot) {
            this.slot = slot;
        }

        public void actionPerformed(ActionEvent e) {
            String filename = "savegame" + slot + ".dat";
            Hero loadedHero = SaveLoadManager.loadGame(filename);
            if (loadedHero != null) {
                launchGame(loadedHero);
            } else {
                JOptionPane.showMessageDialog(LoadGameUI.this, "Failed to load game from slot " + slot + "!");
            }
        }
    }

    private void launchGame(Hero hero) {
        JFrame gameFrame = new JFrame("Heroes of Java");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);
        gameFrame.add(new GameUI(hero));
        gameFrame.setVisible(true);
        mainFrame.dispose();
    }
}
