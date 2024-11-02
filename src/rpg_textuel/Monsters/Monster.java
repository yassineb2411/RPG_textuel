package rpg_textuel.Monsters;

public class Monster {

    protected double life;
    protected double damage;

    public Monster(double l, double d) {
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
