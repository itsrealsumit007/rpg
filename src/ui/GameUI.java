import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameUI extends JPanel {
    private Hero hero;
    private QuestManager questManager;

    public GameUI(Hero hero) {
        this.hero = hero;
        this.questManager = new QuestManager();

        Quest mainQuest = new Quest("Defeat the Dragon", "Defeat the dragon terrorizing the kingdom.", 100);
        questManager.addQuest(mainQuest);

        updateUI();
    }

    private void updateUI() {
        removeAll();
        JLabel heroLabel = new JLabel("Hero: " + hero.name + " Level: " + hero.level);
        add(heroLabel);

        JButton questButton = new JButton("View Quests");
        questButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showQuests();
            }
        });
        add(questButton);

        revalidate();
        repaint();
    }

    private void showQuests() {
        removeAll();
        for (Quest quest : questManager.getQuests()) {
            JLabel questLabel = new JLabel(quest.getName() + ": " + quest.getDescription());
            add(questLabel);
        }
        revalidate();
        repaint();
    }
}
