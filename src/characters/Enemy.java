import java.util.Random;

public class Enemy {
    private String name;
    private int health;
    private int attack;
    private int defense;

    public Enemy(String name, int health, int attack, int defense) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.defense = defense;
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public void attackHero(Hero hero) {
        Random random = new Random();
        int damage = attack - hero.defense;
        damage = damage < 0 ? 0 : damage;
        hero.health -= damage;
        System.out.println(name + " attacks " + hero.name + " for " + damage + " damage.");
    }
}
