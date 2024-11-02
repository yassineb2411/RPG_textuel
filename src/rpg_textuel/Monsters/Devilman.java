package rpg_textuel.Monsters;

public class Devilman extends Monster {

    private static final double DEFAULT_LIFE = 500;
    private double life;
    private static final double DAMAGE = 100;

    public Devilman() {
        super(DEFAULT_LIFE, DAMAGE);
        this.life = DEFAULT_LIFE;
    }

    public double getLife() {
        return life;
    }

    public void hit(double damageTaken) {
        super.hit(damageTaken);
        System.out.println("Devilman est attaqué avec un dégât de " + damageTaken + " et il lui reste :" + this.life + " points de vie !");
    }

    public void attack(double DAMAGE) {
        super.attack(DAMAGE);
        System.out.println("Devilman attaque avec un dégât de " + DAMAGE + " points de vie !");
    }
}
