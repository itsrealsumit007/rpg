import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AchievementManager implements Serializable {
    private List<Achievement> achievements;

    public AchievementManager() {
        achievements = new ArrayList<>();
        achievements.add(new Achievement("First Battle", "Complete your first battle."));
        achievements.add(new Achievement("Level Up", "Reach level 2."));
        achievements.add(new Achievement("Defeated the Dragon", "Defeat the dragon boss."));
    }

    public void checkAchievements(Hero hero) {
        if (hero.getLevel() >= 2) {
            unlockAchievement("Level Up");
        }
        // Add more conditions for unlocking achievements
    }

    public void unlockAchievement(String title) {
        for (Achievement achievement : achievements) {
            if (achievement.getTitle().equals(title) && !achievement.isUnlocked()) {
                achievement.unlock();
                System.out.println("Achievement Unlocked: " + title);
            }
        }
    }

    public List<Achievement> getAchievements() {
        return achievements;
    }
}
