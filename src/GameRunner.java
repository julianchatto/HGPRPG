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

        // main menu loop
        while (gameOn) {
            System.out.println("Choose an option (1-5):\n");
            System.out.println("1. Roam the World");
            System.out.println("2. Check hero stats");
            System.out.println("3. Shop");
            System.out.println("4. Crafting Table");
            System.out.println("5. Final Boss Battle");
            System.out.println("6. Quit Game");

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
                    fB.bossing();
                    break;
                case 6:
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