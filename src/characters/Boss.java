public class Boss extends Enemy {
    public Boss(String name, int health, int attack, int defense) {
        super(name, health, attack, defense);
    }

    @Override
    public void attackHero(Hero hero) {
        int damage = getAttack() * 2 - hero.defense;
        damage = damage < 0 ? 0 : damage;
        hero.health -= damage;
        System.out.println(getName() + " uses a powerful attack on " + hero.name + " for " + damage + " damage.");
    }
}
