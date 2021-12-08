import java.util.Random;
import java.util.Scanner;
public class GameRunner {
    public static void main(String[] args) {
        // Game objects and characters
        Hero h = new Hero();
        Enemy e1 = new Enemy();
        FinalBoss fB = new FinalBoss();
        World w = new World();
        Shop g = new Shop();
        CraftingTable cT = new CraftingTable();
        Scanner scan = new Scanner(System.in);
        boolean gameOn = true;
        System.out.println("Welcome to the HGP RPG! What's your name?");
        String heroName = scan.nextLine();
        h.setName(heroName);
        boolean magicPowering = true;



        while (magicPowering) {
            System.out.println("What would you like your magic power to be?");
            System.out.println("1. Fire\n2. Water\n3. Wind");
            int magicPower = scan.nextInt();
            if (magicPower == 2) {
                h.setMagicPowerType("Water");
                magicPowering = false;
            } else if (magicPower == 3) {
                h.setMagicPowerType("Wind");
                magicPowering = false;
            } else if (magicPower == 1 ) {
                h.setMagicPowerType("Fire");
                magicPowering = false;
            } else {
                System.out.println("Incorrect input, try again!");
            }
        }



        // main menu loop
        while (gameOn) {
            System.out.println("Choose an option (1-5):\n");
            System.out.println("1. Roam the World");
            System.out.println("2. Check hero stats");
            System.out.println("3. Shop");
            System.out.println("4. Crafting Table");
            System.out.println("5. Final Boss Battle");
            System.out.println("6. Quit Game");
            System.out.println("7. View Inventory");

            int userInput = scan.nextInt();

            switch(userInput) {
                case 1:
                    // Roam
                    w.roamTheWorld(h, e1);
                    break;
                case 2:
                    // check stats
                    System.out.println(h);
                    break;
                case 3:
                    //shop
                    g.goShop(h);
                    break;
                case 4:
                    // Crafting Table
                    cT.crafting(h);
                    break;
                case 5:
                    // final boss
                    if (h.getLevel() < 5) {
                        System.out.println("The Aramark CEO is no joke! Come back again when you level up.");
                    } else {
                        fB.bossing(h);
                        System.out.println("You are fighting the final brekky boss. Good Luck. You'll need it.");
                    }
                    break;
                case 6:
                    // end game
                    gameOn = false;
                    System.out.println("Thanks for playing. You get no brekkys.");
                    break;
                case 7:
                    // View Inventory
                    System.out.println(h.toStringInventory());
                    break;
                default:
                    System.out.println("INVALID INPUT. TRY AGAIN." );
                    break;
            }
        }
    }
}