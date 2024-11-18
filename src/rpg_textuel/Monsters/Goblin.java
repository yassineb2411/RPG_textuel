package rpg_textuel.Monsters;

import rpg_textuel.Player.Player;

public class Goblin extends Monster {

    private static final double DEFAULT_LIFE = 50;
    private double life;
    private static final double DAMAGE = 10;

    public Goblin() {
        super("Gobelin", DEFAULT_LIFE, DAMAGE);
        this.life = DEFAULT_LIFE;
    }

    public void hit(double damageTaken) {
        super.hit(damageTaken);
    }

    public void attack(Player player) {
        super.attack(player);
    }
}
