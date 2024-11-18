package rpg_textuel.Weapons;

public class Bow extends Weapon {

    private static final double DAMAGE = 17.5;
    private static final double PRICE = 12;
    private static final String NAME = "Bow";

    private static final double MONSTER_DAMAGE_RATIO = 1.4;
    private static final double OBSTACLE_DAMAGE_RATIO = 1.0;


    public Bow() {
        super(DAMAGE, NAME, MONSTER_DAMAGE_RATIO, OBSTACLE_DAMAGE_RATIO);
    }

    @Override
    public String asciiArt() {
        return "   (\n" +
                "    \\\n" +
                "     )\n" +
                "##-------->\n" +
                "     )\n" +
                "    /\n" +
                "   (";
    }
}
