import java.sql.SQLOutput;
import java.util.Scanner;

public class World {
    // Attributes


    World() {}

    // helper methods
    void roamTheWorld(Hero h, Enemy e1) {

        boolean battleOn = true;
        Scanner bScan = new Scanner(System.in);
        int userInput;

        while (battleOn) {

            System.out.println("An enemy is approaching... ");
            System.out.println("Choose an option(1-3)");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Run Away");
            userInput = bScan.nextInt();

            switch (userInput) {
                case 1:
                    h.attack(e1);

                    break;
                case 2:
                    //Healing();
                    break;
                case 3:
                    System.out.println("You ran away");
                    battleOn = false;
                    break;
                default:
                    System.out.println("Wrong Input");

            }
        }

        e1.attack(h);
    }


    public static void Healing(Hero h) {
        boolean healing = true;
        Scanner bScan = new Scanner(System.in);
        String[] inventory = h.getInventory();
        while (healing) {
            System.out.println("How would you like to heal?");
            System.out.println("1. Use a potion.");
            System.out.println("2. Search for a hidden breakfast burritos.");
            int userInput = bScan.nextInt();
            switch (userInput) {
                case 1:
                    boolean healPotionTF = false;
                    for (int i = 0; i < inventory.length; i++) {
                        if (inventory[i].equals("Heal Potion")) {
                            healPotionTF = true;
                        } else if (inventory[i].equals("OP Heal Potion")) {
                            healPotionTF = true;
                        }
                    }
                    if (healPotionTF) {
                        System.out.println("Which heal potion would you like to use?");
                        String userInputS = bScan.next();


                    }
                    healing = false;
                    break;
                case 2:
                    hiddenBreaky();
                    healing = false;
                    break;
                default:
                    System.out.println("Incorrect Input.");
                    break;
            }
        }
    }
    public static void hiddenBreaky () {

    }
}

