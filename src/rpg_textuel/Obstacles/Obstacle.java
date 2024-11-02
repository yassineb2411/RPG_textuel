package rpg_textuel.Obstacles;

public class Obstacle {

    protected double life;
    protected double damage;

    public Obstacle(double l, double d) {
        this.life = l;
        this.damage = d;
    }

    public void hit(double damageTaken) {
        this.life -= damageTaken;
    }

    public void attack(double targetLife) {
        targetLife -= this.damage;
    }
}
