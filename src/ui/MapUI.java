import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class MapUI extends JPanel {
    private WorldMap worldMap;
    private JTextArea locationDescription;
    private JComboBox<String> locationDropdown;
    private JButton exploreButton;

    public MapUI() {
        worldMap = new WorldMap();
        setLayout(new BorderLayout());

        locationDescription = new JTextArea(10, 30);
        locationDescription.setEditable(false);

        locationDropdown = new JComboBox<>();
        for (String location : worldMap.getLocations().keySet()) {
            locationDropdown.addItem(location);
        }

        exploreButton = new JButton("Explore");
        exploreButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedLocation = (String) locationDropdown.getSelectedItem();
                locationDescription.setText(worldMap.getLocationDescription(selectedLocation));
            }
        });

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        topPanel.add(new JLabel("Select Location:"));
        topPanel.add(locationDropdown);
        topPanel.add(exploreButton);

        add(topPanel, BorderLayout.NORTH);
        add(new JScrollPane(locationDescription), BorderLayout.CENTER);
    }
}
