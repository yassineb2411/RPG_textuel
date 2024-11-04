import rpg_textuel.Monsters.Devilman;
import rpg_textuel.Monsters.Goblin;
import rpg_textuel.Obstacles.Barricade;
import rpg_textuel.Obstacles.Obstacle;
import rpg_textuel.Obstacles.Trap;
import rpg_textuel.Player.Player;
import rpg_textuel.Weapons.Weapon;
import rpg_textuel.Weapons.WeaponStore;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static final Scanner scanner = new Scanner(System.in);
    private static final Random random = new Random();

    public static void main(String[] args) {
        System.out.println("Vous venez d'être fait prisonnier dans le donjon par Devilman,\n" +
                "il va falloir combattre ses sbires monstrueux et réussir à passer les obstacles du donjon pour ensuite battre Devilman ! \n" +
                "Une fois Devilman battu vous pourrez retrouver la liberté... A vous de jouer ! \n");

        WeaponStore weaponStore = new WeaponStore();
        Weapon selectedWeapon = selectWeapon(weaponStore);

        System.out.println("Vous êtes maintenant prêt à combattre !");

        boolean playAgain;
        do {
            playAgain = playGame(selectedWeapon);
        } while (playAgain);
    }

    private static Weapon selectWeapon(WeaponStore weaponStore) {
        System.out.println("Voici le magasin d'armes, sans arme vous ne pourrez jamais aller au bout du donjon " +
                "et vaincre Devilman. \n");

        for (Weapon weapon : weaponStore.getWeapons()) {
            System.out.println("\nRatio de dommage sur les monstres : " + weapon.getMonsterDamageRatio() + "\n" +
                    "Ratio de dommage sur les obstacles : " + weapon.getObstacleDamageRatio() + "\n" +
                    "Visuel de l'arme : \n" + weapon.asciiArt() + "\n");
        }

        System.out.println("Choisissez une arme ! \n" +
                "Appuyez sur A pour sélectionner la hache\n" +
                "Appuyez sur B pour sélectionner l'arc\n" +
                "Appuyez sur S pour sélectionner l'épée\n");

        String choice = scanner.nextLine().toUpperCase();
        switch (choice) {
            case "A": return weaponStore.getWeapons().get(0);  // hache
            case "B": return weaponStore.getWeapons().get(1);  // arc
            case "S": return weaponStore.getWeapons().get(2);  // épée
            default:
                System.out.println("Choix invalide. Veuillez appuyer sur A, B ou S pour sélectionner une arme.");
                return selectWeapon(weaponStore);
        }
    }

    private static boolean playGame(Weapon weapon) {
        Player player = new Player(weapon);
        int encounters = 5; // Nombre d'étapes avant Devilman

        for (int i = 0; i < encounters; i++) {
            if (random.nextBoolean()) {
                handleGoblinEncounter(player, weapon);
            } else {
                handleObstacleEncounter(player, weapon);
            }

            if (player.getLife() <= 0) {
                System.out.println("Vous avez perdu !");
                return askToPlayAgain();
            }
        }

        // Combat final contre Devilman
        return handleDevilmanEncounter(player, weapon);
    }

    private static void handleGoblinEncounter(Player player, Weapon weapon) {
        Goblin goblin = new Goblin();
        System.out.println("\nUn gobelin apparaît avec " + goblin.getLife() + " points de vie !");

        while (goblin.getLife() > 0 && player.getLife() > 0) {
            System.out.println("Appuyez sur 'a' pour attaquer ou sur 'f' pour fuir.");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("a")) {
                player.attackMonster(goblin);
                if (goblin.getLife() > 0) {
                    goblin.attack(player);
                }
            } else if (choice.equals("f")) {
                System.out.println("Vous fuyez le combat !");
                return;
            } else {
                System.out.println("Choix invalide.");
            }
        }

        if (goblin.getLife() <= 0) {
            System.out.println("Vous avez vaincu le gobelin !");
            player.regenerateLife(10);
        }
    }

    private static void handleObstacleEncounter(Player player, Weapon weapon) {
        Obstacle obstacle = random.nextBoolean() ? new Trap() : new Barricade();
        System.out.println("\nVous rencontrez un obstacle : " + (obstacle instanceof Trap ? "Piège" : "Barricade"));

        while (obstacle.getLife() > 0) {
            System.out.println("Appuyez sur 'a' pour attaquer l'obstacle ou sur 'f' pour le contourner.");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("a")) {
                player.attackObstacle(obstacle);
            } else if (choice.equals("f")) {
                System.out.println("Vous contournez l'obstacle.");
                break;
            } else {
                System.out.println("Choix invalide.");
            }
        }

        if (obstacle.getLife() <= 0) {
            System.out.println("Vous avez surmonté l'obstacle !");
        }
    }

    private static boolean handleDevilmanEncounter(Player player, Weapon weapon) {
        Devilman devilman = new Devilman();
        System.out.println("\nVous avez atteint le boss final : Devilman !");

        while (devilman.getLife() > 0 && player.getLife() > 0) {
            System.out.println("Appuyez sur 'a' pour attaquer ou sur 'f' pour essayer de fuir.");
            String choice = scanner.nextLine().toLowerCase();

            if (choice.equals("a")) {
                player.attackMonster(devilman);
                if (devilman.getLife() > 0) {
                    devilman.attack(player);
                }
            } else if (choice.equals("f")) {
                System.out.println("Vous ne pouvez pas fuir contre Devilman !");
            } else {
                System.out.println("Choix invalide.");
            }
        }

        if (player.getLife() <= 0) {
            System.out.println("Vous avez perdu contre Devilman !");
            return askToPlayAgain();
        } else if (devilman.getLife() <= 0) {
            System.out.println("Félicitations ! Vous avez vaincu Devilman et gagné votre liberté !");
            return askToPlayAgain();
        }
        return false;
    }

    private static boolean askToPlayAgain() {
        System.out.println("Voulez-vous rejouer ? (O/N)");
        String choice = scanner.nextLine().trim().toUpperCase();
        return choice.equals("O");
    }
}