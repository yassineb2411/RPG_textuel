package rpg_textuel.Weapons;

import rpg_textuel.Monsters.Monster;
import rpg_textuel.Obstacles.Obstacle;

public abstract class Weapon {

    protected double damage;
    protected String name;

    protected double monster_damage_ratio;
    protected double obstacle_damage_ratio;

    public Weapon(){}

    public Weapon(double d, String name, double monsterRatio, double obstacleRatio) {
        this.damage = d;
        this.name = name;
        this.monster_damage_ratio = monsterRatio;
        this.obstacle_damage_ratio = obstacleRatio;
    }

    public double getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public double getMonsterDamageRatio() {
        return this.monster_damage_ratio;
    }

    public double getObstacleDamageRatio() {
        return this.obstacle_damage_ratio;
    }

    public abstract String asciiArt();

    public void attack(Monster m) {
        m.hit(this.damage * this.getMonsterDamageRatio());
    }

    public void attack(Obstacle o) {
        o.hit(this.damage * this.getObstacleDamageRatio());
    }
}
