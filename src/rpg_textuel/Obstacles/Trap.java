package rpg_textuel.Obstacles;

public class Trap extends Obstacle{

    private static final double DEFAULT_LIFE = 50;
    private double life;
    private static final double DAMAGE = 10;

    public Trap() {
        super(DEFAULT_LIFE, DAMAGE);
        this.life = DEFAULT_LIFE;
    }

    public void hit(double damageTaken) {
        super.hit(damageTaken);
        System.out.println("Le piège est attaqué avec un dégât de " + damageTaken + " et il lui reste :" + this.life + " points de vie !");
    }

    public void attack(double targetLife) {
        super.attack(targetLife);
        System.out.println("Le gobelin attaque avec un dégât de " + DAMAGE + " points de vie !");
    }
}
