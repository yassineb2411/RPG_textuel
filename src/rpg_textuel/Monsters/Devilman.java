package rpg_textuel.Monsters;

import rpg_textuel.Player.Player;

public class Devilman extends Monster {

    private static final double DEFAULT_LIFE = 500;
    private double life;
    private static final double DAMAGE = 50;

    public Devilman() {
        super("Devilman", DEFAULT_LIFE, DAMAGE);
        this.life = DEFAULT_LIFE;
    }

    public void hit(double damageTaken) {
        super.hit(damageTaken);
    }

    public void attack(Player player) {
        super.attack(player);
    }
}
