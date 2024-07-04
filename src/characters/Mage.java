package characters;

public class Mage extends Hero {
    private static final int BASE_HEALTH = 80;
    private static final int BASE_ATTACK = 25;
    private static final int BASE_DEFENSE = 5;

    public Mage(String name, int level) {
        super(name, BASE_HEALTH + level * 8, BASE_ATTACK + level * 6, BASE_DEFENSE + level * 1, level);
    }

    public void useSkill(Enemy enemy) {
        enemy.takeDamage(getAttack() * 3);
    }
}
