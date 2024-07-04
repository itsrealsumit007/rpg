import java.util.Random;

public class AdvancedEnemyAI {
    private Enemy enemy;
    private Random random;

    public AdvancedEnemyAI(Enemy enemy) {
        this.enemy = enemy;
        this.random = new Random();
    }

    public void performAction(Hero hero) {
        int action = random.nextInt(3);
        if (action == 0) {
            enemy.attack(hero);
        } else if (action == 1) {
            hero.addStatusEffect(new StatusEffect("Stun", 1, 0, true));
        } else {
            hero.addStatusEffect(new StatusEffect("Poison", 3, 5, false));
        }
    }
}
