import java.util.ArrayList;
import java.util.List;

public abstract class Hero {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int level;
    protected int xp;
    protected List<Item> inventory;

    public Hero(String name, int health, int attack, int defense, int level) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
        this.xp = 0;
        this.inventory = new ArrayList<>();
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
        System.out.println(name + " leveled up to level " + level + "!");
    }

    public void addItem(Item item) {
        inventory.add(item);
    }

    public int getHealth() {
        return health;
    }
}
