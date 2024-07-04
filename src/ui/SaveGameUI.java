import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SaveGameUI extends JPanel {
    private Hero hero;

    public SaveGameUI(Hero hero) {
        this.hero = hero;
        setLayout(new GridLayout(5, 1));

        for (int i = 1; i <= 3; i++) {
            JButton saveSlotButton = new JButton("Save Slot " + i);
            saveSlotButton.addActionListener(new SaveSlotActionListener(i));
            add(saveSlotButton);
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JFrame) getRootPane().getParent()).dispose();
            }
        });
        add(backButton);
    }

    private class SaveSlotActionListener implements ActionListener {
        private int slot;

        public SaveSlotActionListener(int slot) {
            this.slot = slot;
        }

        public void actionPerformed(ActionEvent e) {
            String filename = "savegame" + slot + ".dat";
            SaveLoadManager.saveGame(hero, filename);
            JOptionPane.showMessageDialog(SaveGameUI.this, "Game saved to slot " + slot + "!");
        }
    }
}
