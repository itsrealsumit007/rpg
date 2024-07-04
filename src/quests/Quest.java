public class Quest {
    private String name;
    private String description;
    private boolean isCompleted;
    private int xpReward;

    public Quest(String name, String description, int xpReward) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
        this.xpReward = xpReward;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void completeQuest() {
        isCompleted = true;
    }

    public int getXpReward() {
        return xpReward;
    }
}
