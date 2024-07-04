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
        JLabel heroLabel = new JLabel("Hero: " + hero.getName() + " Level: " + hero.getLevel());
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

        JButton saveButton = new JButton("Save Game");
        saveButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showSaveGameUI();
            }
        });
        buttonsPanel.add(saveButton);

        JButton loadButton = new JButton("Load Game");
        loadButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showLoadGameUI();
            }
        });
        buttonsPanel.add(loadButton);

        JButton mapButton = new JButton("World Map");
        mapButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showMap();
            }
        });
        buttonsPanel.add(mapButton);

        JButton achievementsButton = new JButton("Achievements");
        achievementsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                showAchievementsUI();
            }
        });
        buttonsPanel.add(achievementsButton);

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

    private void showMap() {
        removeAll();
        add(new MapUI(), BorderLayout.CENTER);

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

    private void showSaveGameUI() {
        JFrame saveFrame = new JFrame("Save Game");
        saveFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        saveFrame.setSize(300, 200);
        saveFrame.add(new SaveGameUI(hero));
        saveFrame.setVisible(true);
    }

    private void showLoadGameUI() {
        JFrame loadFrame = new JFrame("Load Game");
        loadFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        loadFrame.setSize(300, 200);
        loadFrame.add(new LoadGameUI(loadFrame));
        loadFrame.setVisible(true);
    }

    private void showAchievementsUI() {
        JFrame achievementsFrame = new JFrame("Achievements");
        achievementsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        achievementsFrame.setSize(300, 200);
        achievementsFrame.add(new AchievementsUI(hero));
        achievementsFrame.setVisible(true);
    }
}
