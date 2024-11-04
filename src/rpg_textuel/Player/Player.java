package rpg_textuel.Player;

import rpg_textuel.Obstacles.Obstacle;
import rpg_textuel.Weapons.Weapon;
import rpg_textuel.Monsters.Monster;

public class Player {
    private double life;
    private double monsterDamage;
    private double obstacleDamage;
    private Weapon equippedWeapon;

    public Player( Weapon _equippedWeapon) {
        this.life = 100;
        this.equippedWeapon = _equippedWeapon;
        this.monsterDamage = equippedWeapon.getMonsterDamageRatio() * equippedWeapon.getDamage();
        this.obstacleDamage = equippedWeapon.getObstacleDamageRatio() * equippedWeapon.getDamage();
    }

    public double getLife() {
        return life;
    }

    public double getMonsterDamage() {
        return monsterDamage;
    }

    public double getObstacleDamage() {
        return obstacleDamage;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void hit(double damageTaken) {
        this.life -= damageTaken;
        if (this.life < 0) {
            this.life = 0;
        }
        System.out.println("Vous avez perdu " + damageTaken + " points de vie. Vie restante : " + this.life);
    }


    public void attackMonster(Monster monster) {
        monster.hit(this.monsterDamage);
    }

    public void attackObstacle(Obstacle obstacle) {
        obstacle.hit(this.obstacleDamage);
    }

    public void equipWeapon(Weapon weapon) {
        this.equippedWeapon = weapon;
        System.out.println("Vous êtes équipé d'un(e) " + weapon.getName());
    }

    public void regenerateLife(double lifeAdded) {
        this.life += lifeAdded;
        if (this.life > 100) {
            this.life = 100;
        }
        System.out.println("Votre vie a été régénérée. Vie actuelle : " + this.life);
    }

}
