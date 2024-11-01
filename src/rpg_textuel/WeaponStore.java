package rpg_textuel;
import java.util.ArrayList;

public class WeaponStore extends Weapon {

    private ArrayList<Weapon> weapons;

    public WeaponStore() {
        this.weapons = new ArrayList<>();
        this.weapons.add(new Axe());
        this.weapons.add(new Bow());
        this.weapons.add(new Sword());
    }

    public ArrayList<Weapon> getWeapons() {
        return this.weapons;
    }

    @Override
    public String asciiArt() {
        return "";
    }
}
