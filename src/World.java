import java.util.Random;
import java.util.Scanner;

public class World {
    private int healCount = 0;


    // Attributes
    World() {}

    public int getHealCount() {
        return healCount;
    }

    public void setHealCount(int healCount) {
        this.healCount = healCount;
    }

    // helper methods
    void roamTheWorld(Hero h, Enemy e1) {
        Scanner bScan = new Scanner(System.in);
        boolean battleOn = true;
        int userInput;
        Random q = new Random();
        int typeR = q.nextInt(3) + 1;
        if (typeR == 1) {
            e1.setType("Sausage");
        } else if (typeR == 2) {
            e1.setType("Pork Roll");
        } else {
            e1.setType("Bacon");
        }


        while (battleOn) { // Main loop while attacking an enemy

            //checking if hero is alive


            System.out.println("An evil breakfast gremlin of type " + e1.getType() + " is approaching... ");
            System.out.println("Choose an option(1-3)");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Run Away");
            userInput = bScan.nextInt();

            switch (userInput) {
                case 1: // attack
                    //attacking(h,e1);

                    if (h.getHealth()<=0) {
                        System.out.println("You are already dead. You must heal first!");
                        battleOn = false;
                    }
                    h.attack(e1);
                    System.out.println("You attacked the enemy");
                    if (e1.getHealth() <= 0) { //enemy dies
                        System.out.println("Enemy health: 0");
                        System.out.println("You won!");
                        System.out.println("That enemy dropped some righteous loot");
                        h.setCoins(h.getCoins()+(h.getLevel()*100));
                        System.out.println("You now have "+h.getCoins()+" dabloons...CHA CHING $$$");
                        h.setLevel(h.getLevel()+1);
                        System.out.println("You also leveled up! level: " + h.getLevel());
                        battleOn = false;
                        e1.setHealth(50*h.getLevel());
                    } else {
                        System.out.println("Enemy health:" + e1.getHealth());
                        System.out.println("Now the enemy is attacking you!");
                        e1.attack(h);
                        System.out.println("your health:" + h.getHealth());
                        if (h.getHealth()<=0) {
                            System.out.println("you died :(");
                            h.setHealth(100);
                            battleOn = false;
                        }
                    }
                    break;
                case 2: // heal
                    healing(h);
                    break;
                case 3: // run away
                    Random r = new Random();//40% you cannot get away and the gremlin attacks you
                    int esc = r.nextInt(10)+1;
                    if (esc<=4){
                        System.out.println("the gremlin wont stop chasing you");
                        e1.attack(h);
                        System.out.println("your health:" + h.getHealth());
                    }else{
                        System.out.println("You ran away...phew");
                        battleOn = false;
                        break;
                    }
                default:
                    System.out.println("Wrong Input");

            }
        }
    }

//    public static void attacking(Hero h, Enemy e1) {
//        h.attack(e1);
//        System.out.println("You attacked the enemy");
//        if (e1.getHealth() <= 0) {
//            System.out.println("Enemy health: 0");
//            System.out.println("You won!");
//            System.out.println("That enemy dropped some righteous loot");
//            h.setCoins(h.getCoins()+(h.getLevel()*100));
//            System.out.println("You now have "+h.getCoins()+" dabloons...CHA CHING $$$");
//            h.setLevel(h.getLevel()+1);
//            System.out.println("You also leveled up! level: " + h.getLevel());
//            battleOn = false;
//            e1.setHealth(50*h.getLevel());
//        } else {
//            System.out.println("Enemy health:" + e1.getHealth());
//            System.out.println("Now the enemy is attacking you!");
//            e1.attack(h);
//            System.out.println("your health:" + h.getHealth());
//            if (h.getHealth()<=0) {
//                System.out.println("you died :(");
//                h.setHealth(100);
//                battleOn = false;
//            }
//        }
//    }
    // heal function

    public static void healing(Hero h) {
        World healCount = new World();
        String[] inventory = h.getInventory();
        Scanner bScan = new Scanner(System.in);
        boolean healing = true;
        int healCounter = healCount.getHealCount();


        while (healing) { // main loop for healing

            System.out.println("How would you like to heal?");
            System.out.println("1. Use a potion.");
            System.out.println("2. Search for a hidden breakfast burrito.");
            System.out.println("3. No");
            int userInput = bScan.nextInt();

            switch (userInput) {
                case 1: // uses potion in inventory

                    boolean healPotionTF = false;

                    for (int i = 0; i < inventory.length; i++) { // checks if user has heal potion
                        if (inventory[i].equals("Regular Heal Potion")) {
                            healPotionTF = true;
                        } else if (inventory[i].equals("OP Heal Potion")) {
                            healPotionTF = true;
                        }
                    }
                    if (healPotionTF) {
                        boolean potionHeal = true;

                        while (potionHeal) { // to choose what potion user wants to use

                            System.out.println("Which heal potion would you like to use?");
                            System.out.println("1. Regular Heal Potion.");
                            System.out.println("2. OP Heal Potion.");
                            System.out.println("3. Cancel");
                            userInput = bScan.nextInt();

                            switch (userInput) {
                                case 1: // Regular heal potion

                                    for (int i = 0; i < inventory.length; i++) { // adds health to hero
                                        if (inventory[i].equals("Regular Heal Potion")) {
                                            if (h.getHealth() <= 70) {
                                                int tempH = h.getHealth() + 30;
                                                h.setHealth(tempH);
                                            } else {
                                                h.setHealth(100);
                                            }
                                            //h.setInventory();  needs to be fixed
                                        }
                                    }
                                    break;
                                case 2: // OP heal potion
                                    for (int i = 0; i < inventory.length; i++) { // sets health to 100
                                        if (inventory[i].equals("OP Heal Potion")) {
                                            h.setHealth(100);

                                            //h.setInventory();        needs to be fixed
                                        }
                                    }
                                    break;
                                case 3:
                                    potionHeal = false;
                                    break;
                                default:
                                    System.out.println("Incorrect Input. Try again");
                                    break;
                            }
                        }

                    } else {
                        System.out.println("You do not have a Heal Potion!");
                    }
                    healing = false;
                    break;
                case 2: // Search for heal potion
                    if (healCounter == 0) {
                        hiddenBreaky(h);
                        healing = false;
                        healCount.setHealCount(healCounter+1);
                    } else {
                        System.out.println("You already searched for hidden breakfast burritos in this area!");
                    }

                    break;
                case 3: // cancels
                    healing = false;
                    break;
                default:
                    System.out.println("Incorrect Input.");
                    break;
            }
        }
    }
    // search feature for a hidden breakfast sandwich
    public static void hiddenBreaky(Hero h) {
        Scanner bScan = new Scanner(System.in);
        int moves = 0;
        int potionFound = 0;
        int potionLocCol = 0;
        int potionLocRow = 0;

        String[][] map = {{"H", "G", "G"},
                {"G", "G", "G"},
                {"G", "G", "G"}};

        Random c = new Random();
        Random r = new Random();
        int mapColumn = c.nextInt(50);
        int mapRow = r.nextInt(50);

        // sets location for hidden potion in the column
        if (mapColumn>30) {
            potionLocCol = 2;
        } else if (mapColumn <= 30 && mapColumn > 5) {
            potionLocCol = 1;
        }
        // sets location for hidden potion in the row
        if (mapRow>30) {
            potionLocRow = 2;
        } else if (mapRow <= 30 && mapRow > 5) {
            potionLocRow = 1;
        }
        // sets location to 2,2 if both are originaly 0,0
        if (potionLocCol == 0 && potionLocRow == 0) {
            potionLocCol = 2;
            potionLocRow = 2;
        }

        for (int row = 0; row < 3; row++) { // prints map
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(map[row][col] + " ");
            }
        }
        System.out.println("You look around the world and need to decide where to look for a heal potion. However," +
                "you only have 5 moves!\n\n Make sure to choose carefully. ");

        while (moves < 5) {

            System.out.println("What direction would you like to move?");
            System.out.println("1. Left\n2. Right\n3. Up\n4.Down");
            int userInput = bScan.nextInt();

            switch (userInput) {
                case 1: // Left
                    moveLeft(map);
                    moves++;
                    break;
                case 2: // Right
                    moveRight(map);
                    moves++;
                    break;
                case 3: // Up
                    moveUp(map);
                    moves++;
                    break;
                case 4: // Down
                    moveDown(map);
                    moves++;
                    break;
                default:
                    System.out.println("Not a valid input, try again");
                    break;
            }

            if (map[potionLocCol][potionLocRow].equals("H")) { // checks if hero is on potion
                //h.setInventory(); // THIS NEEDS TO BE FIXED
                System.out.println("You found the hidden breakfast sandwich! Head back to the heal menu if you'd like to use it now.");
                potionFound++;
            }
            if (potionFound == 1) { // breaks out of while loop
                moves = 5;
            }
        }
    }
    // moves right
    public static void moveRight(String[][] m) {
        int heroRow = 0;
        int heroCol = 0;

        // Finds hero
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }

        if (heroCol == 2) { // restricts movement
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot right
            m[heroRow][heroCol+1] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }

        for (int row = 0; row < 3; row++) { // prints map
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(m[row][col] + " ");
            }
        }
    }
    // moves left
    public static void moveLeft (String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        // Finds hero
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }

        if (heroCol == 0) { // restricts movement
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot left
            m[heroRow][heroCol-1] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }
        for (int row = 0; row < 3; row++) { // prints map
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(m[row][col] + " ");
            }
        }

    }
    // moves down
    public static void moveDown (String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        // finds hero
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }
        if (heroRow == 2) { // restricts movement
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot up
            m[heroRow+1][heroCol] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }
        for (int row = 0; row < 3; row++) {  // prints map
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(m[row][col] + " ");
            }
        }

    }
    // moves up
    public static void moveUp (String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        // Finds hero
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }
        if (heroRow == 0) { // restricts movement
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot up
            m[heroRow-1][heroCol] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }
        for (int row = 0; row < 3; row++) { // pritns map
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(m[row][col] + " ");
            }
        }

    }
}

