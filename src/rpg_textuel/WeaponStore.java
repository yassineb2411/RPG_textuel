package rpg_textuel;
import java.util.ArrayList;

public class WeaponStore {

    private ArrayList<Weapon> weapons;

    public WeaponStore() {
        this.weapons = new ArrayList<>();
        this.weapons.add(new Axe());
        this.weapons.add(new Sword());
        this.weapons.add(new Bow());
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }
}
