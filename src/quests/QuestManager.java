import java.util.ArrayList;
import java.util.List;

public class QuestManager {
    private List<Quest> quests;

    public QuestManager() {
        quests = new ArrayList<>();
    }

    public void addQuest(Quest quest) {
        quests.add(quest);
    }

    public void completeQuest(String questName) {
        for (Quest quest : quests) {
            if (quest.getName().equals(questName) && !quest.isCompleted()) {
                quest.completeQuest();
                break;
            }
        }
    }

    public List<Quest> getQuests() {
        return quests;
    }
}
