import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventoryUI extends JPanel {
    private Hero hero;

    public InventoryUI(Hero hero) {
        this.hero = hero;
        updateInventory();
    }

    private void updateInventory() {
        removeAll();
        List<Item> items = hero.inventory;
        for (Item item : items) {
            JLabel itemLabel = new JLabel(item.getName());
            add(itemLabel);
        }
        revalidate();
        repaint();
    }
}
