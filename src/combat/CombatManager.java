public class CombatManager {
    private Hero hero;
    private Enemy enemy;

    public CombatManager(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void startCombat() {
        while (hero.getHealth() > 0 && enemy.getHealth() > 0) {
            if (!hero.isStunned()) {
                hero.applyStatusEffects();
                hero.useSkill(enemy);
            } else {
                hero.setStunned(false);
            }
            if (enemy.getHealth() > 0) {
                enemy.attack(hero);
            }
        }
        if (hero.getHealth() <= 0) {
            System.out.println("Hero has been defeated!");
        } else {
            System.out.println("Enemy has been defeated!");
            hero.gainXp(enemy.getXpReward());
        }
    }
}
