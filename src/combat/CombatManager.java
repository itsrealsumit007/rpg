public class CombatManager {
    private Hero hero;
    private Enemy enemy;

    public CombatManager(Hero hero, Enemy enemy) {
        this.hero = hero;
        this.enemy = enemy;
    }

    public void startCombat() {
        while (hero.health > 0 && enemy.getHealth() > 0) {
            hero.useSkill(enemy);
            if (enemy.getHealth() <= 0) {
                hero.gainXp(50);
                break;
            }
            enemy.attackHero(hero);
            if (hero.health <= 0) {
                System.out.println("Hero is defeated!");
                break;
            }
        }
        if (hero.health > 0) {
            System.out.println("Enemy is defeated!");
        }
    }
}
