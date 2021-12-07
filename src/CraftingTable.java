import java.util.Scanner;

public class CraftingTable {
    void crafting (Hero h){
        Scanner bScan = new Scanner(System.in);
        boolean craftInProg = true;

        String[][] table = {{"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "}};

        printTable(table);

        while (craftInProg) {
            System.out.println("What would you like to place in the inventory?");
            String userInput = bScan.next();
            boolean craftInProgCol = true;
            switch (userInput) {
                case "Bagel":
                    while (craftInProgCol) {
                        System.out.println("Where would you like to place the "+ userInput + " (x-coordinate)?");
                        int userInputInt = bScan.nextInt();
                        switch (userInputInt) {
                            case 0:
                                boolean craftInProgRow = true;
                                int craftCol = userInputInt;
                                while (craftInProgRow) {
                                    System.out.println("Where would you like to place the " + userInput + " (y-coordinate)?");
                                    userInputInt = bScan.nextInt();
                                    switch (userInputInt) {
                                        case 0:
                                            table[0][craftCol] = "| " + userInput + " |  ";
                                            craftInProgRow = false;
                                            printTable(table);
                                            break;
                                        case 1:
                                            table[1][craftCol] = "| " + userInput + " |  ";
                                            craftInProgRow = false;
                                            printTable(table);
                                            break;
                                        case 2:
                                            table[2][craftCol] = "| " + userInput + " |  ";
                                            craftInProgRow = false;
                                            printTable(table);
                                            break;
                                        case 3:
                                            table[3][craftCol] = "| " + userInput + " |  ";
                                            craftInProgRow = false;
                                            printTable(table);
                                            break;
                                        case 4:
                                            table[4][craftCol] = "| " + userInput + " |  ";
                                            craftInProgRow = false;
                                            printTable(table);
                                            break;
                                        default:
                                            System.out.println("Incorrect input, try again!");

                                    }
                                }
                                craftInProgCol = false;
                                break;
                            case 1:
                                break;
                            case 2:
                                break;
                            default:
                                System.out.println("Incorrect input, try again!");

                        }
                    }
                    craftInProg = false;
                    break;
                case "Egg":
                    craftInProg = false;
                    break;
                case "Cheese":
                    craftInProg = false;
                    break;
                case "Sausage":
                    craftInProg = false;
                    break;
                default:
                    System.out.println("That cannot be placed in the crafting table!");
                    break;
            }
        }



    }
    public static void printTable(String[][] table) {
        System.out.println("\nCrafting table:");
        for (int row = 0; row < 3; row++) { // prints  crafting table
            // For row 0...
            System.out.println(""); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(table[row][col] + " ");
            }
        }
    }
}
