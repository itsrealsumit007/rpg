public class Warrior extends Hero {
    public Warrior(String name, int level) {
        super(name, 100 + level * 10, 20 + level * 5, 10 + level * 2, level);
    }

    public void useSkill(Enemy enemy) {
        enemy.takeDamage(attack * 2);
    }
}
