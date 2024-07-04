import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCustomizationUI extends JPanel {
    private JTextField nameField;
    private JComboBox<String> classComboBox;
    private JButton createButton;
    private Hero hero;

    public CharacterCustomizationUI() {
        setLayout(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Hero Name:");
        nameField = new JTextField();
        add(nameLabel);
        add(nameField);

        JLabel classLabel = new JLabel("Hero Class:");
        String[] classes = {"Warrior", "Mage", "Archer"};
        classComboBox = new JComboBox<>(classes);
        add(classLabel);
        add(classComboBox);

        createButton = new JButton("Create Hero");
        createButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                createHero();
            }
        });
        add(new JLabel());
        add(createButton);
    }

    private void createHero() {
        String name = nameField.getText();
        String selectedClass = (String) classComboBox.getSelectedItem();

        switch (selectedClass) {
            case "Warrior":
                hero = new Warrior(name, 1);
                break;
            case "Mage":
                hero = new Mage(name, 1);
                break;
            case "Archer":
                hero = new Archer(name, 1);
                break;
        }

        JFrame gameFrame = new JFrame("Heroes of Java");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);
        gameFrame.add(new GameUI(hero));
        gameFrame.setVisible(true);

        SwingUtilities.getWindowAncestor(this).dispose();
    }
}
