import java.util.Scanner;

public class GameRunner {


    public static void main(String[] args) {
        // Game objects and characters
        Hero h = new Hero();
        Enemy e1 = new Enemy();
        Scanner scan = new Scanner(System.in);
        boolean gameOn = true;
        World w = new World();
        Shop g = new Shop();
        System.out.println("Welcome to the HGP RPG! What's your name?");
        String heroName = scan.nextLine();
        h.setName(heroName);
        //Allows user to set their name


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
                    System.out.println(h.toString());
                    break;
                case 3:
                    //shop
                    g.goShop();
                    break;
                case 4:
                    // final boss
                    break;
                case 5:
                   // end game
                    gameOn = false;
                    System.out.println("Thanks for playing.");
                    break;
                case 6:
                    // Crafting Table
                    System.out.println("");
                default:
                    System.out.println("INVALID INPUT. TRY AGAIN." );
                    break;
            }
        }
    }
}