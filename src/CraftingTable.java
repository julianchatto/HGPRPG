

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
            System.out.println("\nWhat would you like to craft?\n1. Bacon Egg N'Cheese\n2. Sausage Egg N'Cheese\n3. Pork Roll Egg N'Cheese\n4. Cancel");

            int userInput = bScan.nextInt();
            switch (userInput) {
                case 1:
                    int counter = 0;
                    for (int i = 0; i < 12; i++) {
                        if (h.getInvItem(i).equals("Bacon")) {
                            counter++;
                        } else if (h.getInvItem(i).equals("Egg")) {
                            counter++;
                        } else if (h.getInvItem(i).equals("Cheese")) {
                            counter++;
                        } else if (h.getInvItem(i).equals("Bagel")) {
                            if (h.getInvCount(i) == 2) {
                                counter++;
                            }
                        }
                    }
                    if (counter == 4) {
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Bacon")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Egg")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Cheese")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Bagel")) {
                                if (h.getInvCount(i) == 2) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 2;
                                    h.replaceInvCount(i,tempCount);
                                }
                            }
                        }
                        table[0][1] = "| Bagel |  ";
                        table[1][1] = "| Bacon |  ";
                        table[2][1] = "| Egg |  ";
                        table[3][1] = "| Cheese |  ";
                        table[4][1] = "| Bagel |  ";
                        printTable(table);
                        int test = 0;
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Bacon Egg N'Cheese")) {
                                int tcount = h.getInvCount(i) + 1;
                                h.replaceInvCount(i,tcount);
                                test++;
                            }
                        }
                        if (test == 0) {
                            for (int i = 0; i < 12; i++) {
                                if (h.getInvItem(i).equals("Empty")) {
                                    h.replaceInvItem(i,"Bacon Egg N'Cheese");
                                    h.replaceInvCount(i,1);
                                    test++;
                                    i = 13;
                                }
                            }
                        }
                        System.out.println("\nA Bacon Egg N'Cheese has been added to your inventory");
                    }  else {
                        System.out.println("You do not have the ingredients for a Bacon Egg N'Cheese");
                    }
                    break;
                case 2:
                    int counter2 = 0;
                    for (int i = 0; i < 8; i++) {
                        if (h.getInvItem(i).equals("Sausage")) {
                            counter2++;
                        } else if (h.getInvItem(i).equals("Egg")) {
                            counter2++;
                        } else if (h.getInvItem(i).equals("Cheese")) {
                            counter2++;
                        } else if (h.getInvItem(i).equals("Bagel")) {
                            if (h.getInvCount(i) == 2) {
                                counter2++;
                            }
                        }
                    }
                    if (counter2 == 4) {
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Sausage")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Egg")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Cheese")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Bagel")) {
                                if (h.getInvCount(i) == 2) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 2;
                                    h.replaceInvCount(i,tempCount);
                                }
                            }
                        }
                        table[0][1] = "| Bagel |  ";
                        table[1][1] = "| Sausage |  ";
                        table[2][1] = "| Egg |  ";
                        table[3][1] = "| Cheese |  ";
                        table[4][1] = "| Bagel |  ";
                        printTable(table);
                        int test = 0;
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Sausage Egg N'Cheese")) {
                                int tCount = h.getInvCount(i) + 1;
                                h.replaceInvCount(i,tCount);
                                test++;
                            }
                        }
                        if (test == 0) {
                            for (int i = 0; i < 12; i++) {
                                if (h.getInvItem(i).equals("Empty")) {
                                    h.replaceInvItem(i,"Sausage Egg N'Cheese");
                                    h.replaceInvCount(i,1);
                                    test++;
                                    i = 13;
                                }
                            }
                        }
                        System.out.println("\nA Sausage Egg N'Cheese has been added to your inventory");
                    }  else {
                        System.out.println("You do not have the ingredients for a Sausage Egg N'Cheese");
                    }
                    break;
                case 3:
                    int counter3 = 0;
                    for (int i = 0; i < 8; i++) {
                        if (h.getInvItem(i).equals("Pork Roll")) {
                            counter3++;
                        } else if (h.getInvItem(i).equals("Egg")) {
                            counter3++;
                        } else if (h.getInvItem(i).equals("Cheese")) {
                            counter3++;
                        } else if (h.getInvItem(i).equals("Bagel")) {
                            if (h.getInvCount(i) == 2) {
                                counter3++;
                            }
                        }
                    }
                    if (counter3 == 4) {
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Pork Roll")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Egg")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Cheese")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Bagel")) {
                                if (h.getInvCount(i) == 2) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 2;
                                    h.replaceInvCount(i,tempCount);
                                }
                            }
                        }
                        table[0][1] = "| Bagel |  ";
                        table[1][1] = "| Pork Roll |  ";
                        table[2][1] = "| Egg |  ";
                        table[3][1] = "| Cheese |  ";
                        table[4][1] = "| Bagel |  ";
                        printTable(table);
                        int test = 0;
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Pork Roll Egg N'Cheese")) {
                                int tCount = h.getInvCount(i) + 1;
                                h.replaceInvCount(i,tCount);
                                test++;
                            }
                        }
                        if (test == 0) {
                            for (int i = 0; i < 12; i++) {
                                if (h.getInvItem(i).equals("Empty")) {
                                    h.replaceInvItem(i,"Pork Roll Egg N'Cheese");
                                    h.replaceInvCount(i,1);
                                    test++;
                                    i = 13;
                                }
                            }
                        }
                        System.out.println("\nA Pork Roll Egg N'Cheese has been added to your inventory");
                    }  else {
                        System.out.println("You do not have the ingredients for a Pork Roll Egg N'Cheese");
                    }
                    break;
                case 4: // Cancel
                    craftInProg = false;
                    break;
                case 7: // Mega brek
                    int counter4 = 0;
                    for (int i = 0; i < 8; i++) {
                        if (h.getInvItem(i).equals("Pork Roll")) {
                            counter4++;
                        } else if (h.getInvItem(i).equals("Egg")) {
                            if (h.getInvCount(i) == 3) {
                                counter4++;
                            }
                        } else if (h.getInvItem(i).equals("Cheese")) {
                            if (h.getInvCount(i) == 3) {
                                counter4++;
                            }
                        } else if (h.getInvItem(i).equals("Bagel")) {
                            if (h.getInvCount(i) == 6) {
                                counter4++;
                            }
                        } else if (h.getInvItem(i).equals("Sausage")) {
                            counter4++;
                        } else if (h.getInvItem(i).equals("Bacon")) {
                            counter4++;
                        }
                    }
                    if (counter4 == 6) {
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Pork Roll")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Egg")) {
                                if (h.getInvCount(i) == 3) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 3;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Cheese")) {
                                if (h.getInvCount(i) == 3) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 3;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Bagel")) {
                                if (h.getInvCount(i) == 6) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 6;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Sausage")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            } else if (h.getInvItem(i).equals("Bacon")) {
                                if (h.getInvCount(i) == 1) {
                                    h.replaceInvItem(i,"Empty");
                                    h.replaceInvCount(i,0);
                                } else {
                                    int tempCount = h.getInvCount(i) - 1;
                                    h.replaceInvCount(i,tempCount);
                                }
                            }
                        }
                        // Fills table
                        table[0][0] = "| Bagel |  "; table[0][1] = "| Bagel |  "; table[0][2] = "| Bagel |  ";
                        table[1][0] = "| Sausage |  "; table[1][1] = "| Pork Roll |  "; table[1][2] = "| Bacon |  ";
                        table[2][0] = "| Egg |  "; table[2][1] = "| Egg |  "; table[2][2] = "| Egg |  ";
                        table[3][0] = "| Cheese |  "; table[3][1] = "| Cheese |  "; table[3][2] = "| Cheese |  ";
                        table[4][0] = "| Bagel |  "; table[4][1] = "| Bagel |  "; table[4][2] = "| Bagel |  ";
                        printTable(table); // prints table
                        // Empty table (except for middle col since it will always be replaced no matter craft)
                        table[0][0] = "|  |  "; table[0][2] = "|  |  ";
                        table[1][0] = "|  |  "; table[1][2] = "|  |  ";
                        table[2][0] = "|  |  "; table[2][2] = "|  |  ";
                        table[3][0] = "|  |  "; table[3][2] = "|  |  ";
                        table[4][0] = "|  |  "; table[4][2] = "|  |  ";
                        int test = 0;
                        for (int i = 0; i < 12; i++) {
                            if (h.getInvItem(i).equals("Mega Brekky")) {
                                int tCount = h.getInvCount(i) + 1;
                                h.replaceInvCount(i,tCount);
                                test++;
                            }
                        }
                        if (test == 0) {
                            for (int i = 0; i < 12; i++) {
                                if (h.getInvItem(i).equals("Empty")) {
                                    h.replaceInvItem(i,"Mega Brekky");
                                    h.replaceInvCount(i,1);
                                    test++;
                                    i = 13;
                                }
                            }
                        }
                        System.out.println("\nA Pork Roll Egg N'Cheese has been added to your inventory");
                    }  else {
                        System.out.println("You do not have the ingredients for a Mega Breaky");
                    }
                    craftInProg = false;
                    break;
                default:
                    System.out.println("Invalid Input, try again");
                    break;
            }
        }
    }

    public static void printTable(String[][] table) {
        System.out.println("\nCrafting table:");
        for (int row = 0; row < 5; row++) { // prints  crafting table
            // For row 0...
            System.out.println(); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(table[row][col] + " ");
            }
        }
    }
}
