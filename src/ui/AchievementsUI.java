import javax.swing.*;
import java.awt.*;

public class AchievementsUI extends JPanel {
    private Hero hero;

    public AchievementsUI(Hero hero) {
        this.hero = hero;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Achievements"));

        for (Achievement achievement : hero.getAchievementManager().getAchievements()) {
            String status = achievement.isUnlocked() ? "Unlocked" : "Locked";
            add(new JLabel(achievement.getTitle() + ": " + achievement.getDescription() + " (" + status + ")"));
        }

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            ((JFrame) getRootPane().getParent()).dispose();
        });
        add(backButton);
    }
}
