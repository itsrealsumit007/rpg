import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public abstract class Hero implements Serializable {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int level;
    protected int xp;
    protected boolean stunned;
    protected List<Item> inventory;
    protected List<StatusEffect> statusEffects;
    private AchievementManager achievementManager;

    public Hero(String name, int health, int attack, int defense, int level) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.xp = 0;
        this.stunned = false;
        this.inventory = new ArrayList<>();
        this.statusEffects = new ArrayList<>();
        this.achievementManager = new AchievementManager();
    }

    public abstract void useSkill(Enemy enemy);

    public void gainXp(int amount) {
        xp += amount;
        if (xp >= level * 100) {
            levelUp();
        }
    }

    public void levelUp() {
        level++;
        health += 10;
        attack += 5;
        defense += 2;
        xp = 0;
        achievementManager.checkAchievements(this);
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public void addStatusEffect(StatusEffect effect) {
        statusEffects.add(effect);
    }

    public void applyStatusEffects() {
        for (StatusEffect effect : statusEffects) {
            effect.applyEffect(this);
        }
        statusEffects.removeIf(effect -> effect.getDuration() <= 0);
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isStunned() {
        return stunned;
    }

    public void setStunned(boolean stunned) {
        this.stunned = stunned;
    }

    public AchievementManager getAchievementManager() {
        return achievementManager;
    }
}
