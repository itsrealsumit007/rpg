package characters;

public class Archer extends Hero {
    private static final int BASE_HEALTH = 90;
    private static final int BASE_ATTACK = 15;
    private static final int BASE_DEFENSE = 8;

    public Archer(String name, int level) {
        super(name, BASE_HEALTH + level * 9, BASE_ATTACK + level * 4, BASE_DEFENSE + level * 2, level);
    }

    public void useSkill(Enemy enemy) {
        enemy.takeDamage(getAttack() * 2);
    }
}
