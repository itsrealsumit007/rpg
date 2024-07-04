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
                hero.useSkill(enemy);
                if (enemy.getHealth() <= 0) {
                    System.out.println(enemy.getName() + " defeated!");
                    hero.gainXp(enemy.getXpReward());
                    hero.getAchievementManager().checkAchievements(hero);
                    return;
                }
            }
            if (!enemy.isStunned()) {
                enemy.attack(hero);
                if (hero.getHealth() <= 0) {
                    System.out.println(hero.getName() + " defeated!");
                    return;
                }
            }
            hero.applyStatusEffects();
            enemy.applyStatusEffects();
        }
    }
}
