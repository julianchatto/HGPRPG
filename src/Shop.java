import java.util.Random;
import java.util.Scanner;

public class Shop {
    private int[] stock = {9, 9, 9, 9, 9, 9};
    Shop() {}

    void goShop(Hero h) {
        Scanner bScan = new Scanner(System.in);
        int userInput;
        String[] items = {"Bagel", "Egg", "Cheese", "Sausage", "OP Heal Potion", "Regular Heal Potion"};
        int[] prices = {10, 5, 3, 7, 1000, 100};

        int item1 = 0; int item2 = 0; int item3 = 0;
        boolean shopping = true;

        // ensures two items of same type are not used
        while ((item1 == item2) || (item1 == item3) || (item2 == item3)) {
            Random i1 = new Random();
            Random i2 = new Random();
            Random i3 = new Random();
            item1 = i1.nextInt(5);
            item2 = i2.nextInt(5);
            item3 = i3.nextInt(5);
        }

        System.out.println("\nWelcome to the shop!");
        // Shop
        while (shopping) {
            System.out.println("\nWhat would you like to buy?\n");
            System.out.println("1. " + items[item1] + ". Price: " + prices[item1] + ". Stock: " + stock[item1] + ".");
            System.out.println("2. " + items[item2] + ". Price: " + prices[item2] + ". Stock: " + stock[item2] + ".");
            System.out.println("3. " + items[item3] + ". Price: " + prices[item3] + ". Stock: " + stock[item3] + ".");
            System.out.println("4. Nothing.");
            userInput = bScan.nextInt();

            switch (userInput) {
                case 1: // item 1
                    if (stock[item1] > 0) { // not of stock
                        boolean outStock = true;

                        while (outStock) {
                            System.out.println("How many " + items[item1] + "'s would you like to buy?");
                            userInput = bScan.nextInt();
                            int currentCoins = h.getCoins();
                            if ((userInput <= stock[item1]) && (userInput > 0)) { // enough in stock
                                if ((prices[item1]*userInput) <= currentCoins) { // checks if user has enough coins
                                    // changes value of hero
                                    int potionCount1 = 0;
                                    for (int i = 0; i < 8; i++) { // adds item to inventory
                                        if (h.getInvItem(i).equals(items[item1])) {
                                            int tempCount = h.getInvCount(i) + 1;
                                            h.replaceInvCount(i, tempCount);
                                            potionCount1 = 1;
                                            i=9;
                                        }
                                    }
                                    if (potionCount1 == 0) {
                                        for (int i = 0; i < 8; i++) { // adds item to inventory
                                            if (h.getInvItem(i).equals(items[item1])) {
                                                h.replaceInvItem(i, items[item1]);
                                                h.replaceInvCount(i, 1);
                                                i=9;
                                            }
                                        }
                                    }
                                    h.setCoins(h.getCoins()-prices[item1]);
                                    stock[item1] = stock[item1] - userInput;
                                    outStock = false;

                                    if (userInput > 1) { // more than one item
                                        System.out.println(userInput + " " +  items[item1] + "'s have been added to your inventory.");
                                    } else { // one item
                                        System.out.println("A " + items[item1] + "has been added to your inventory.");
                                    }
                                } else { // not enough coins
                                    System.out.println("You do not have enough coins for that purchase!");
                                }
                            } else if (userInput == 0) { // enters 0
                                System.out.println("You don't want to buy any " + items[item1] + "!?\n1. I do\n2. Nope");
                                userInput = bScan.nextInt();
                                if (userInput == 2) { // sends back to shop menu
                                    outStock = false;
                                }
                            } else { // enters an amount greater than what is in stock
                                System.out.println("There is not enough " + items[item1] + " in stock. \nPlease enter a new amount.");
                            }
                        }
                    } else { // out of stock
                        System.out.println("Sorry, " + items[item1] + " are out of stock.");
                        System.out.println("Would you like to buy something else?\n1. Yes\n2. No");
                        userInput = bScan.nextInt();
                        if (userInput == 2) { // sends back to shop menu
                            shopping = false;
                        }
                    }
                    break;
                case 2: // item 2
                    if (stock[item2] > 0) { // not of stock
                        boolean outStock = true;

                        while (outStock) {
                            System.out.println("How many " + items[item2] + "'s would you like to buy?");
                            userInput = bScan.nextInt();

                            int currentCoins = h.getCoins();
                            if ((userInput <= stock[item2]) && (userInput > 0)) { // enough in stock
                                if ((prices[item2]*userInput) <= currentCoins) { // checks if user has enough coins
                                    // changes value of hero
                                    int potionCount1 = 0;
                                    for (int i = 0; i < 8; i++) { // adds item to inventory
                                        if (h.getInvItem(i).equals(items[item2])) {
                                            int tempCount = h.getInvCount(i) + 1;
                                            h.replaceInvCount(i, tempCount);
                                            potionCount1 = 1;
                                            i=9;
                                        }
                                    }
                                    if (potionCount1 == 0) {
                                        for (int i = 0; i < 8; i++) { // adds item to inventory
                                            if (h.getInvItem(i).equals(items[item2])) {
                                                h.replaceInvItem(i, items[item2]);
                                                h.replaceInvCount(i, 1);
                                                i=9;
                                            }
                                        }
                                    }
                                    h.setCoins(h.getCoins()-prices[item2]);
                                    stock[item2] = stock[item2] - userInput;
                                    outStock = false;

                                    if (userInput > 1) { // more than one item
                                        System.out.println(userInput + items[item2] + "'s have been added to your inventory.");
                                    } else { // one item
                                        System.out.println("A " + items[item2] + "has been added to your inventory.");
                                    }
                                } else { // not enough coins
                                    System.out.println("You do not have enough coins for that purchase!");
                                }
                            } else if (userInput == 0) { // enters 0
                                System.out.println("You don't want to buy any " + items[item2] + "!?\n1. I do\n2. Nope");
                                userInput = bScan.nextInt();
                                if (userInput == 2) { // sends back to shop menu
                                    outStock = false;
                                }
                            } else { // enters an amount greater than what is in stock
                                System.out.println("There is not enough " + items[item2] + " in stock. \nPlease enter a new amount.");
                            }
                        }
                    } else { // out of stock
                        System.out.println("Sorry, " + items[item2] + " are out of stock.");
                        System.out.println("Would you like to buy something else?\n1. Yes\n2. No");
                        userInput = bScan.nextInt();
                        if (userInput == 2) { // sends back to shop menu
                            shopping = false;
                        }
                    }
                    break;
                case 3: // item 3
                    if (stock[item3] > 0) { // not of stock
                        boolean outStock = true;

                        while (outStock) {
                            System.out.println("How many " + items[item3] + "'s would you like to buy?");
                            userInput = bScan.nextInt();
                            int currentCoins = h.getCoins();
                            if ((userInput <= stock[item3]) && (userInput > 0)) { // enough in stock
                                if ((prices[item3]*userInput) <= currentCoins) { // checks if user has enough coins
                                    // changes value of hero
                                    int potionCount1 = 0;
                                    for (int i = 0; i < 8; i++) { // adds item to inventory
                                        if (h.getInvItem(i).equals(items[item3])) {
                                            int tempCount = h.getInvCount(i) + 1;
                                            h.replaceInvCount(i, tempCount);
                                            potionCount1 = 1;
                                            i=9;
                                        }
                                    }
                                    if (potionCount1 == 0) {
                                        for (int i = 0; i < 8; i++) { // adds item to inventory
                                            if (h.getInvItem(i).equals(items[item3])) {
                                                h.replaceInvItem(i, items[item3]);
                                                h.replaceInvCount(i, 1);
                                                i=9;
                                            }
                                        }
                                    }
                                    h.setCoins(h.getCoins()-prices[item3]);
                                    stock[item3] = stock[item3] - userInput;
                                    outStock = false;

                                    if (userInput > 1) { // more than one item
                                        System.out.println(userInput + " " +  items[item3] + "'s have been added to your inventory.");
                                    } else { // one item
                                        System.out.println("A " + items[item3] + "has been added to your inventory.");
                                    }
                                } else { // not enough coins
                                    System.out.println("You do not have enough coins for that purchase!");
                                }
                            } else if (userInput == 0) { // enters 0
                                System.out.println("You don't want to buy any " + items[item3] + "!?\n1. I do\n2. Nope");
                                userInput = bScan.nextInt();
                                if (userInput == 2) { // sends back to shop menu
                                    outStock = false;
                                }
                            } else { // enters an amount greater than what is in stock
                                System.out.println("There is not enough " + items[item3] + " in stock. \nPlease enter a new amount.");
                            }
                        }
                    } else { // out of stock
                        System.out.println("Sorry, " + items[item3] + " are out of stock.");
                        System.out.println("Would you like to buy something else?\n1. Yes\n2. No");
                        userInput = bScan.nextInt();
                        if (userInput == 2) { // sends back to shop menu
                            shopping = false;
                        }
                    }
                    break;
                case 4:  // cancel
                    shopping = false;
                    break;
                default:
                    System.out.println("Not a valid input. Try again");
                    break;
            }
        }
    }
}
