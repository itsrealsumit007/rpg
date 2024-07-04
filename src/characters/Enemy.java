public abstract class Enemy {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;

    public Enemy(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void attack(Hero hero) {
        hero.takeDamage(attack - hero.defense);
    }

    public int getHealth() {
        return health;
    }

    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public abstract int getXpReward();
}
