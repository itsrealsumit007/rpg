public abstract class Hero {
    protected String name;
    protected int health;
    protected int attack;
    protected int defense;
    protected int level;

    public Hero(String name, int health, int attack, int defense, int level) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.level = level;
    }

    public abstract void useSkill(Enemy enemy);
}
