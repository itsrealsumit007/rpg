import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CharacterCustomizationUI extends JPanel {
    private JTextField nameField;
    private JComboBox<String> classDropdown;
    private JButton confirmButton;

    public CharacterCustomizationUI() {
        setLayout(new GridLayout(3, 2));

        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);

        add(new JLabel("Class:"));
        classDropdown = new JComboBox<>(new String[] { "Warrior", "Mage", "Archer" });
        add(classDropdown);

        confirmButton = new JButton("Confirm");
        confirmButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String heroClass = (String) classDropdown.getSelectedItem();
                Hero hero = createHero(name, heroClass);
                launchGame(hero);
            }
        });
        add(confirmButton);
    }

    private Hero createHero(String name, String heroClass) {
        switch (heroClass) {
            case "Warrior":
                return new Warrior(name, 100, 20, 10, 1);
            case "Mage":
                return new Mage(name, 80, 30, 5, 1);
            case "Archer":
                return new Archer(name, 90, 25, 7, 1);
            default:
                throw new IllegalArgumentException("Unknown class: " + heroClass);
        }
    }

    private void launchGame(Hero hero) {
        JFrame gameFrame = new JFrame("Heroes of Java");
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.setSize(800, 600);
        gameFrame.add(new GameUI(hero));
        gameFrame.setVisible(true);
    }
}
