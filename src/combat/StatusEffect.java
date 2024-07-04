public class StatusEffect {
    private String name;
    private int duration;
    private int damagePerTurn;
    private boolean stun;

    public StatusEffect(String name, int duration, int damagePerTurn, boolean stun) {
        this.name = name;
        this.duration = duration;
        this.damagePerTurn = damagePerTurn;
        this.stun = stun;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public int getDamagePerTurn() {
        return damagePerTurn;
    }

    public boolean isStun() {
        return stun;
    }

    public void applyEffect(Hero hero) {
        hero.takeDamage(damagePerTurn);
        duration--;
        if (stun) {
            hero.setStunned(true);
        }
    }
}
