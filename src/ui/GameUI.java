import javax.swing.*;
import java.awt.*;
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

        setLayout(new BorderLayout());
        updateUI();
    }

    private void updateUI() {
        removeAll();

        JPanel heroPanel = new JPanel();
        heroPanel.setLayout(new BoxLayout(heroPanel, BoxLayout.Y_AXIS));
        JLabel heroLabel = new JLabel("Hero: " + hero.name + " Level: " + hero.level);
        heroPanel.add(heroLabel);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());

        JButton questButton = new JButton("View Quests");
        questButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showQuests();
            }
        });
        buttonsPanel.add(questButton);

        JButton combatButton = new JButton("Fight Dragon");
        combatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Enemy dragon = new Boss("Dragon", 200, 40, 20);
                CombatManager combatManager = new CombatManager(hero, dragon);
                combatManager.startCombat();
            }
        });
        buttonsPanel.add(combatButton);

        add(heroPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }

    private void showQuests() {
        removeAll();
        JPanel questsPanel = new JPanel();
        questsPanel.setLayout(new BoxLayout(questsPanel, BoxLayout.Y_AXIS));
        for (Quest quest : questManager.getQuests()) {
            JLabel questLabel = new JLabel(quest.getName() + ": " + quest.getDescription());
            questsPanel.add(questLabel);
        }
        add(questsPanel, BorderLayout.CENTER);

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateUI();
            }
        });
        add(backButton, BorderLayout.SOUTH);

        revalidate();
        repaint();
    }
}
