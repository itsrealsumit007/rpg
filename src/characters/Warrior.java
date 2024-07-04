package characters;

public class Warrior extends Hero {
    private static final int BASE_HEALTH = 100;
    private static final int BASE_ATTACK = 20;
    private static final int BASE_DEFENSE = 10;

    public Warrior(String name, int level) {
        super(name, BASE_HEALTH + level * 10, BASE_ATTACK + level * 5, BASE_DEFENSE + level * 2, level);
    }

    public void useSkill(Enemy enemy) {
        enemy.takeDamage(getAttack() * 2);
    }
}
