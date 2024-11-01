package rpg_textuel;

public class Sword extends Weapon{

    private static final double DAMAGE = 25;
    private static final double PRICE = 15;
    private static final String NAME = "Hammer";

    private static final double MONSTER_DAMAGE_RATIO = 1.5;
    private static final double OBSTACLE_DAMAGE_RATIO = 1.2;


    public Sword() {
        super(DAMAGE, PRICE, NAME, MONSTER_DAMAGE_RATIO, OBSTACLE_DAMAGE_RATIO);
    }

    @Override
    public String asciiArt() {
        return "          -\n" +
                "          |\n" +
                "O=========|>>>>>>>>>>>>>>>>>>>>>>>>>>\n" +
                "          |\n" +
                "          -";
    }
}
