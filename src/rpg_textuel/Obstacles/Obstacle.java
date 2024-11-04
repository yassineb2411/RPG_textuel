package rpg_textuel.Obstacles;

public class Obstacle {

    protected double life;

    public Obstacle(double l) {
        this.life = l;
    }

    public double getLife() {
        return life;
    }

    public void hit(double damageTaken) {
        this.life -= damageTaken;
        if(this.life < 0) {
            this.life = 0;
        }
    }
}
