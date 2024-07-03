public class Archer extends Hero {
    public Archer(String name, int level) {
        super(name, 90 + level * 9, 15 + level * 4, 8 + level * 2, level);
    }

    public void useSkill(Enemy enemy) {
        enemy.takeDamage(attack * 2);
    }
}
