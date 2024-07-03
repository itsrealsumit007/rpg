import java.util.Random;

public class CombatManager {
    private Hero hero;
    private Enemy enemy;

    public CombatManager(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void startCombat() {
        Random random = new Random();
        while (hero.health > 0 && enemy.getHealth() > 0) {
            if (random.nextBoolean()) {
                hero.useSkill(enemy);
            } else {
                hero.health -= enemy.getAttack() - hero.defense;
            }
        }
        if (hero.health <= 0) {
            System.out.println("Hero is defeated!");
        } else {
            System.out.println("Enemy is defeated!");
        }
    }
}

