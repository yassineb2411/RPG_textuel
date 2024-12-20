package rpg_textuel.Weapons;

public class Axe extends Weapon {

    private static final double DAMAGE = 20;
    private static final String NAME = "Axe";

    private static final double MONSTER_DAMAGE_RATIO = 1.6;
    private static final double OBSTACLE_DAMAGE_RATIO = 1.75;


    public Axe() {
        super(DAMAGE, NAME, MONSTER_DAMAGE_RATIO, OBSTACLE_DAMAGE_RATIO);
    }

    public String asciiArt() {
        return "  ,  /\\  .  \n" +
                " //`-||-'\\\\ \n" +
                "(| -=||=- |)\n" +
                " \\\\,-||-.// \n" +
                "  `  ||  '  \n" +
                "     ||     \n" +
                "     ||     \n" +
                "     ||     \n" +
                "     ||     \n" +
                "     ||     \n" +
                "     ()";
    }
}
