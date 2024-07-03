public class Mage extends Hero {
    public Mage(String name, int level) {
        super(name, 80 + level * 8, 25 + level * 6, 5 + level * 1, level);
    }

    public void useSkill(Enemy enemy) {
        enemy.takeDamage(attack * 3);
    }
}
