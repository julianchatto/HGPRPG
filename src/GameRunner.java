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
            System.out.println("1. Sausage Slammer- Strong against sausage type gremlins but weak against Pork Roll");
            System.out.println("2. Pork Roll Pounder- Strong against Pork Roll gremlins but weak against Bacon");
            System.out.println("3. Bacon Beast- Strong against Bacon but weak against Sausage");
            int magicPower = scan.nextInt();
            if (magicPower == 2) {
                h.setMagicPowerType("Pork Roll Pounder");
                magicPowering = false;
            } else if (magicPower == 3) {
                h.setMagicPowerType("Bacon Beast");
                magicPowering = false;
            } else if (magicPower == 1 ) {
                h.setMagicPowerType("Sausage Slammer");
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
            System.out.println("3. View Inventory");
            System.out.println("4. Shop");
            System.out.println("5. Crafting Table");
            System.out.println("6. Final Boss Battle");
            System.out.println("7. Quit Game");


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
                    // View Inventory
                    System.out.println(h.toStringInventory());
                    break;
                case 4:
                    //shop
                    g.goShop(h);
                    break;
                case 5:
                    // Crafting Table
                    cT.crafting(h);
                    break;
                case 6:
                    // final boss
                    if (h.getLevel() < 5) {
                        System.out.println("The Aramark CEO is no joke! Come back again when you level up.");
                    } else {
                        fB.bossFight(h,w);
                        System.out.println("You are fighting the final brekky boss- THE CEO OF ARAMARK. Good Luck. You'll need it.");
                    }
                    break;
                case 7:
                    // end game
                    gameOn = false;
                    System.out.println("Thanks for playing. You get no brekkys.");
                    break;
                default:
                    System.out.println("INVALID INPUT. TRY AGAIN." );
                    break;
            }
        }
    }
}