import java.sql.SQLOutput;
import java.util.Scanner;

public class World {
    // Attributes


    World() {
    }

    // helper methods
    void roamTheWorld(Hero h, Enemy e1) {
        String[] inventory = h.getInventory();
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
                    boolean healing = true;
                    while (healing) {
                        System.out.println("How would you like to heal?");
                        System.out.println("1. Use a potion.");
                        System.out.println("2. Search for a hidden breakfast burritos.");
                        System.out.println("3. Cancel.");
                        userInput = bScan.nextInt();
                        switch (userInput) {
                            case 1:
                                boolean healPotionTF = false;
                                for (int i = 0; i < inventory.length; i++) {
                                    if (inventory[i].equals("Regular Heal Potion")) {
                                        healPotionTF = true;
                                    } else if (inventory[i].equals("OP Heal Potion")) {
                                        healPotionTF = true;
                                    }
                                }
                                if (healPotionTF) {
                                    boolean potionHeal = true;
                                    while (potionHeal) {
                                        System.out.println("Which heal potion would you like to use?");
                                        System.out.println("1. Regular Heal Potion.");
                                        System.out.println("2. OP Heal Potion.");
                                        System.out.println("3. Cancel");
                                        userInput = bScan.nextInt();
                                        switch (userInput) {
                                            case 1:
                                                for (int i = 0; i < inventory.length; i++) {
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
                                            case 2:
                                                for (int i = 0; i < inventory.length; i++) {
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
                            case 2:
                                hiddenBreaky();
                                healing = false;
                                break;
                            case 3:
                                healing = false;
                                break;
                            default:
                                System.out.println("Incorrect Input.");
                                break;
                        }
                    }
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


    public static void hiddenBreaky() {
        String[][] map = {{"H", "G", "G"},
                {"G", "G", "G"},
                {"G", "G", "G"}};

        for (int row = 0; row < 3; row++) {
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(map[row][col] + " ");
            }
        }
        System.out.println("You look around the world and need to decide where to look for a heal potion. However," +
                "you only have 5 moves!\n\n Make sure to choose carefully. ");
        moveRight(map);
        for (int row = 0; row < 3; row++) {
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(map[row][col] + " ");
            }
        }
    }

    public static void moveRight(String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }
        if (heroCol == 2) {
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot right
            m[heroRow][heroCol+1] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }

    }
    public static void moveLeft (String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }

        if (heroCol == 0) {
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot left
            m[heroRow][heroCol-1] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }


    }

    public static void moveDown (String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }
        if (heroRow == 2) {
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot up
            m[heroRow+1][heroCol] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }

    }

    public static void moveUp (String[][] m) {
        int heroRow = 0;
        int heroCol = 0;
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (m[row][col].equals("H")) {
                    heroRow = row;
                    heroCol = col;
                    break;
                }
            }
        }
        if (heroRow == 0) {
            System.out.println("You can not move that way and lost a turn!");
        } else {
            // Move location 1 spot up
            m[heroRow-1][heroCol] = "H";

            // Replace hero with grass
            m[heroRow][heroCol] = "G";
        }

    }

}

