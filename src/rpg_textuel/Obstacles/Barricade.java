package rpg_textuel.Obstacles;

public class Barricade extends Obstacle {
    private static final double DEFAULT_LIFE = 50;

    public Barricade() {
        super(DEFAULT_LIFE);
    }

    public void hit(double damageTaken) {
        super.hit(damageTaken);
        System.out.println("Le piège est attaqué avec un dégât de " + damageTaken + " et il lui reste :" + this.life + " points de vie !");
    }
}
