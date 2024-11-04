package rpg_textuel.Monsters;

import rpg_textuel.Player.Player;

public class Monster {

    protected double life;
    protected double damage;
    protected String name;

    public Monster(double l, double d) {
        this.life = l;
        this.damage = d;
    }

    public double getLife() {
        return life;
    }

    public String getName() {
        return name;
    }

    public double getDamage() {
        return damage;
    }

    public void hit(double damageTaken) {
        this.life -= damageTaken;
        if (this.life < 0) {
            this.life = 0;
        }
        System.out.println("Le " + this.name + " est attaqué avec un dégât de " + damageTaken +
                " et il lui reste : " + this.life + " points de vie !");
    }

    public void attack(Player player) {
        player.hit(this.damage);
        System.out.println("Le " + this.name + " vous attaque avec un dégât de " + this.damage +
                " et il vous reste : " + player.getLife() + " points de vie !");
    }

    public boolean isDefeated() {
        return this.life <= 0;
    }
}
