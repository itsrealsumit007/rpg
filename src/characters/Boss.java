public class Boss extends Enemy {
    public Boss(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public void attack(Hero hero) {
        super.attack(hero);
        hero.addStatusEffect(new StatusEffect("Poison", 3, 5, false));
    }

    @Override
    public int getXpReward() {
        return 200;
    }
}
