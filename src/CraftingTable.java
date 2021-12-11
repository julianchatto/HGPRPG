import java.util.Scanner;

public class CraftingTable {
    void crafting (Hero h){
        World w1 = new World();
        Scanner bScan = new Scanner(System.in);
        boolean craftInProg = true;

        String[][] table = {{"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "}};

        printTable(table);
        if (w1.isStudented() == false)
        System.out.println("What would you like to craft?\n1. Bacon Egg N'Cheese\n2. Sausage Egg N'Cheese\n3. Pork Roll Egg N'Cheese");
        while (craftInProg) {
            System.out.println("What would you like to place in the inventory?\nBagel");
            String userInput = bScan.next();
            boolean craftInProgCol = true;
            boolean craftInProgRow = true;
            int craftCol = 0;
            int craftRow = 0;
            if ((userInput != "Bagel") || (userInput != "Egg")  || (userInput != "Sausage") || (userInput != "Egg")) {
                System.out.println("That cannot be placed in the crafting table!");
            } else {
                for (int i = 0; i < 8; i++) {
                    if (h.getInvItem(i).equals(userInput)) {
                        while (craftInProgCol) {
                            System.out.println("Where would you like to place the " + userInput + " (x-coordinate)?");
                            craftCol = bScan.nextInt();
                            if ((craftCol != 0) || (craftCol != 1) || (craftCol != 2)){
                                System.out.println("Not a correct input. Try again.");
                            } else {
                                craftInProgCol = false;
                            }
                        }
                        while (craftInProgRow) {
                            System.out.println("Where would you like to place the " + userInput + " (y-coordinate)?");
                            craftRow = bScan.nextInt();
                            if ((craftRow != 0) || (craftRow != 1) || (craftRow != 2) || (craftRow != 3) || (craftRow != 4)){
                                System.out.println("Not a correct input. Try again.");
                            } else {
                                craftInProgRow = false;
                            }
                        }
                    }
                    int tempCount = h.getInvCount(i) - 1;
                    h.replaceInvCount(i, tempCount);
                    if (tempCount == 0) {
                        h.replaceInvItem(i, "Empty");
                    }
                    i = 9;
                }
                table[craftRow][craftCol] = userInput;
                printTable(table);
            }
            crafted(h);
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
    public static void crafted(Hero h) {

    }
}
