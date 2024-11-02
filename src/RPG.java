import rpg_textuel.Weapons.Weapon;
import rpg_textuel.Weapons.WeaponStore;

import java.util.Scanner;

public class RPG {
    public static void main(String[] args) {
        System.out.println("Vous venez d'être fait prisonnier dans le donjon par Devilman,\n"+
                "il va falloir combattre ses sbires monstrueux et réussir à passer les obstacles du donjon pour ensuite battre Devilman ! \n"+
                "Une fois Devilman battu vous pourrez retrouver la liberté... A vous de jouer ! \n");

        WeaponStore weaponStore = new WeaponStore();

        System.out.println("Voici le magasin d'armes, sans arme vous ne pourrez jamais aller au bout du donjon " +
                "et vaincre Devilman. \n");

        for (Weapon weapon : weaponStore.getWeapons()) {
            System.out.println();
            System.out.println("Ratio de dommage sur les monstres : " + weapon.getMonsterDamageRatio() + "\n" +
                               "Ratio de dommage sur les obstacles : " + weapon.getObstacleDamageRatio()  + "\n" +
                               "Visuel de l'arme : \n" + weapon.asciiArt() + "\n");
        }

        System.out.println("Choisissez une arme ! \n" +
                           "Appuyez sur A pour séléctionner la hache \n" +
                           "Appuyez sur B pour séléctionner l'arc \n" +
                           "Appuyez sur S pour séléctionner l'épée \n");

        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toUpperCase();
        Weapon selectedWeapon = null;

        switch (choice) {
            case "A":
                selectedWeapon = weaponStore.getWeapons().get(0);  // l'index 0 est la hache
                System.out.println("Vous avez sélectionné la hache !");
                break;
            case "B":
                selectedWeapon = weaponStore.getWeapons().get(1);  // l'index 1 est l'arc
                System.out.println("Vous avez sélectionné l'arc !");
                break;
            case "S":
                selectedWeapon = weaponStore.getWeapons().get(2);  // l'index 2 est l'épée
                System.out.println("Vous avez sélectionné l'épée !");
                break;
            default:
                System.out.println("Choix invalide. Veuillez appuyer sur A, B ou S pour sélectionner une arme.");
                break;
        }

        System.out.println("Vous êtes maintenant prêt à combattre");


    }
}