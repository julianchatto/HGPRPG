import java.util.Random;
import java.util.Scanner;

public class World {
    private int healCount;
    private boolean studented;


    // Attributes
    World() {
        this.studented = true;
        healCount = 0;
    }


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
        int help;
        boolean haveBrekky = false;
        int counter = 0;
        //Check for sausage egg and cheese in inventory and if they have it set haveBrekky to true
        for (int i = 0; i < 12; i++) {
            if (h.getInvItem(i).equals("Sausage")) {
                counter++;
            } else if (h.getInvItem(i).equals("Egg")) {
                counter++;
            } else if (h.getInvItem(i).equals("Cheese")) {
                counter++;
            }
        }
        if (counter == 3) {
            haveBrekky = true;
        }
        Random q = new Random();
       //Randomizes enemy type
        int typeR = q.nextInt(3) + 1;
        if (typeR == 1) {
            e1.setType("Sausage");
        } else if (typeR == 2) {
            e1.setType("Pork Roll");
        } else {
            e1.setType("Bacon");
        }
        int encounterR = q.nextInt(10)+1;
        if (encounterR<=9) {
            while (battleOn) { // Main loop while attacking an enemy

                System.out.println("An evil breakfast gremlin of type " + e1.getType() + " is attacking... ");
                System.out.println("Choose an option(1-3)");
                System.out.println("1. Attack");
                System.out.println("2. Heal");
                System.out.println("3. Run Away");
                userInput = bScan.nextInt();

                switch (userInput) {
                    case 1: // attack
                        boolean attacking = true;
                        while (attacking) {
                            System.out.println("How would you like to attack?\n1. Normal\n2. Use a brekky");
                            int userInput2 = bScan.nextInt();
                            switch (userInput2) {
                                case 1:
                                    if (h.getHealth() <= 0) {
                                        System.out.println("You are already dead. You must heal first!");
                                        battleOn = false;
                                    } else {
                                        h.attack(e1);
                                        if (e1.getHealth() <= 0) { //enemy dies
                                            System.out.println("\nEnemy health: 0");
                                            System.out.println("\n\nYou won!");
                                            System.out.println("\nThat enemy dropped some righteous loot:");
                                            h.setCoins(h.getCoins() + (h.getLevel() * 100));
                                            System.out.println("You now have " + h.getCoins() + " dabloons...CHA CHING $$$");
                                            h.setLevel(h.getLevel() + 1);
                                            System.out.println("You also leveled up! level: " + h.getLevel());
                                            battleOn = false;
                                            int drop = q.nextInt(4) + 1;
                                            if (drop <= 2) {
                                                if (e1.getType().equals("Sausage")) {
                                                    System.out.println("The enemy also dropped some Sausage!!");
                                                    int counts = 0;
                                                    for (int i = 0; i < 12; i++) {
                                                        if (h.getInvItem(i).equals("Sausage")) {
                                                            int tempS = h.getInvCount(i) + 1;
                                                            h.replaceInvCount(i, tempS);
                                                            counts++;
                                                        }
                                                    }
                                                    if (counts == 0) {
                                                        for (int i = 0; i < 12; i++) {
                                                            if (h.getInvItem(i).equals("Empty")) {
                                                                h.replaceInvItem(i, "Sausage");
                                                                h.replaceInvCount(i, 1);
                                                                i = 13;
                                                            }
                                                        }
                                                    }

                                                } else if (e1.getType().equals("Pork Roll")) {
                                                    System.out.println("The enemy also dropped some Pork Roll!!");
                                                    //add pork roll to inventory
                                                    int counts = 0;
                                                    for (int i = 0; i < 12; i++) {
                                                        if (h.getInvItem(i).equals("Sausage")) {
                                                            int tempS = h.getInvCount(i) + 1;
                                                            h.replaceInvCount(i, tempS);
                                                            counts++;
                                                        }
                                                    }
                                                    if (counts == 0) {
                                                        for (int i = 0; i < 12; i++) {
                                                            if (h.getInvItem(i).equals("Empty")) {
                                                                h.replaceInvItem(i, "Pork Roll");
                                                                h.replaceInvCount(i, 1);
                                                                i = 13;
                                                            }
                                                        }
                                                    }

                                                } else if (e1.getType().equals("Bacon")) {
                                                    System.out.println("The enemy also dropped some Bacon!!");
                                                    //add bacon to your inventory
                                                    int counts = 0;
                                                    for (int i = 0; i < 12; i++) {
                                                        if (h.getInvItem(i).equals("Bacon")) {
                                                            int tempS = h.getInvCount(i) + 1;
                                                            h.replaceInvCount(i, tempS);
                                                            counts++;
                                                        }
                                                    }
                                                    if (counts == 0) {
                                                        for (int i = 0; i < 12; i++) {
                                                            if (h.getInvItem(i).equals("Empty")) {
                                                                h.replaceInvItem(i, "Bacon");
                                                                h.replaceInvCount(i, 1);
                                                                i = 13;
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            e1.setHealth(50 * h.getLevel());
                                        } else {
                                            System.out.println("\nEnemy health: " + e1.getHealth());
                                            System.out.println("\nNow the enemy is attacking you!");
                                            e1.attack(h);
                                            if (h.getHealth() <= 0) {
                                                System.out.println("you died :(");
                                                h.setHealth(100*h.getLevel());
                                                battleOn = false;
                                            } else {
                                                System.out.println("Your health: " + h.getHealth());
                                            }
                                        }
                                    }
                                    attacking = false;
                                    break;
                                case 2:
                                    boolean breakyTF = false;
                                    for (int i = 0; i < 12; i++) { // checks if user has heal potion
                                        if (h.getInvItem(i).equals("Bacon Egg N'Cheese")) {
                                            breakyTF = true;
                                        } else if (h.getInvItem(i).equals("Sausage Egg N'Cheese")) {
                                            breakyTF = true;
                                        } else if (h.getInvItem(i).equals("Pork Roll Egg N'Cheese")) {
                                            breakyTF = true;
                                        }
                                    }
                                    if (breakyTF) {
                                        boolean brekkyDam = true;

                                        while (brekkyDam) { // to choose what potion user wants to use

                                            System.out.println("Which brekky would you like to use?");
                                            System.out.println("1. Bacon Egg N'Cheese");
                                            System.out.println("2. Sausage Egg N'Cheese");
                                            System.out.println("3. Pork Roll Egg N'Cheese");
                                            System.out.println("4. Cancel");
                                            userInput = bScan.nextInt();

                                            switch (userInput) {
                                                case 1: // Bacon
                                                    int oPCount = 0;
                                                    for (int i = 0; i < 12; i++) { // adds health to hero
                                                        if (h.getInvItem(i).equals("Bacon Egg N'Cheese")) {
                                                            oPCount++;
                                                            if (e1.getType().equals("Bacon")) {
                                                                if (h.getMagicPowerType().equals("Bacon")) {
                                                                    int tempH = e1.getHealth() - 60;
                                                                    e1.setHealth(tempH);
                                                                } else {
                                                                    int tempH = e1.getHealth() - 40;
                                                                    e1.setHealth(tempH);
                                                                }
                                                            } else if (e1.getType().equals("Sausage")){
                                                                int tempH = e1.getHealth() - 10;
                                                                e1.setHealth(tempH);
                                                            } else {
                                                                int tempH = e1.getHealth() - 20;
                                                                e1.setHealth(tempH);
                                                            }
                                                            if (h.getInvCount(i) == 1) {
                                                                h.replaceInvItem(i, "Empty");
                                                                h.replaceInvCount(i, 0);
                                                            } else {
                                                                int tempC = h.getInvCount(i) - 1;
                                                                h.replaceInvCount(i,tempC);
                                                            }
                                                            i = 13;

                                                            System.out.println("Bacon Egg N'Cheese used!\n");
                                                            System.out.println("Enemy health is: " + e1.getHealth());
                                                        }
                                                    }
                                                    if (oPCount == 0) {
                                                        System.out.println("You do not have a Bacon Egg N'Cheese!");
                                                    }
                                                    brekkyDam = false;
                                                    break;
                                                case 2:
                                                    int oPCount2 = 0;
                                                    for (int i = 0; i < 12; i++) { // adds health to hero
                                                        if (h.getInvItem(i).equals("Sausage Egg N'Cheese")) {
                                                            oPCount2++;
                                                            if (e1.getType().equals("Sausage")) {
                                                                if (h.getMagicPowerType().equals("Sausage")) {
                                                                    int tempH = e1.getHealth() - 60;
                                                                    e1.setHealth(tempH);
                                                                } else {
                                                                    int tempH = e1.getHealth() - 40;
                                                                    e1.setHealth(tempH);
                                                                }
                                                            } else  if (e1.getType().equals("Pork Roll")){
                                                                int tempH = e1.getHealth() - 10;
                                                                e1.setHealth(tempH);
                                                            } else {
                                                                int tempH = e1.getHealth() - 20;
                                                                e1.setHealth(tempH);
                                                            }
                                                            if (h.getInvCount(i) == 1) {
                                                                h.replaceInvItem(i, "Empty");
                                                                h.replaceInvCount(i, 0);
                                                            } else {
                                                                int tempC = h.getInvCount(i) - 1;
                                                                h.replaceInvCount(i,tempC);
                                                            }
                                                            i = 13;

                                                            System.out.println("Sausage Egg N'Cheese used!\n");
                                                            System.out.println("Enemy health is: " + e1.getHealth());
                                                        }
                                                    }
                                                    if (oPCount2 == 0) {
                                                        System.out.println("You do not have a Sausage Egg N'Cheese!");
                                                    }
                                                    brekkyDam = false;
                                                    break;
                                                case 3:
                                                    int oPCount3 = 0;
                                                    for (int i = 0; i < 12; i++) { // adds health to hero
                                                        if (h.getInvItem(i).equals("Pork Roll Egg N'Cheese")) {
                                                            oPCount3++;
                                                            if (e1.getType().equals("Pork Roll")) {
                                                                if (h.getMagicPowerType().equals("Pork Roll")) {
                                                                    int tempH = e1.getHealth() - 60;
                                                                    e1.setHealth(tempH);
                                                                } else {
                                                                    int tempH = e1.getHealth() - 40;
                                                                    e1.setHealth(tempH);
                                                                }
                                                            } else if (e1.getType().equals("Bacon")){
                                                                int tempH = e1.getHealth() - 10;
                                                                e1.setHealth(tempH);
                                                            } else {
                                                                int tempH = e1.getHealth() - 20;
                                                                e1.setHealth(tempH);
                                                            }
                                                            if (h.getInvCount(i) == 1) {
                                                                h.replaceInvItem(i, "Empty");
                                                                h.replaceInvCount(i, 0);
                                                            } else {
                                                                int tempC = h.getInvCount(i) - 1;
                                                                h.replaceInvCount(i,tempC);
                                                            }
                                                            i = 13;

                                                            System.out.println("Pork Roll Egg N'Cheese used!\n");
                                                            System.out.println("Enemy health is: " + e1.getHealth());
                                                        }
                                                    }
                                                    if (oPCount3 == 0) {
                                                        System.out.println("You do not have a Pork Roll Egg N'Cheese!");
                                                    }
                                                    brekkyDam = false;
                                                    break;
                                                case 4:
                                                    brekkyDam = false;
                                                    break;
                                                default:
                                                    System.out.println("Invalid input, try again");
                                                    break;
                                            }
                                        }
                                        if (e1.getHealth() <= 0) { //enemy dies
                                            System.out.println("Enemy health: 0");
                                            System.out.println("You won!");
                                            System.out.println("That enemy dropped some righteous loot");
                                            h.setCoins(h.getCoins() + (h.getLevel() * 100));
                                            System.out.println("You now have " + h.getCoins() + " dabloons...CHA CHING $$$");
                                            h.setLevel(h.getLevel() + 1);
                                            System.out.println("You also leveled up! level: " + h.getLevel());
                                            battleOn = false;
                                            int drop = q.nextInt(4) + 1;
                                            if (drop == 1) {
                                                if (e1.getType().equals("Sausage")) {
                                                    System.out.println("The enemy dropped some Sausage!!");
                                                    int counts = 0;
                                                    for (int i = 0; i < 12; i++) {
                                                        if (h.getInvItem(i).equals("Sausage")) {
                                                            int tempS = h.getInvCount(i) + 1;
                                                            h.replaceInvCount(i, tempS);
                                                            counts++;
                                                        }
                                                    }
                                                    if (counts == 0) {
                                                        for (int i = 0; i < 12; i++) {
                                                            if (h.getInvItem(i).equals("Empty")) {
                                                                h.replaceInvItem(i, "Sausage");
                                                                h.replaceInvCount(i, 1);
                                                                i = 13;
                                                            }
                                                        }
                                                    }
                                                    //add sausage to inventory
                                                } else if (e1.getType().equals("Pork Roll")) {
                                                    System.out.println("The enemy dropped some Pork Roll!!");
                                                    //add pork roll to inventory
                                                    int counts = 0;
                                                    for (int i = 0; i < 12; i++) {
                                                        if (h.getInvItem(i).equals("Sausage")) {
                                                            int tempS = h.getInvCount(i) + 1;
                                                            h.replaceInvCount(i, tempS);
                                                            counts++;
                                                        }
                                                    }
                                                    if (counts == 0) {
                                                        for (int i = 0; i < 12; i++) {
                                                            if (h.getInvItem(i).equals("Empty")) {
                                                                h.replaceInvItem(i, "Pork Roll");
                                                                h.replaceInvCount(i, 1);
                                                                i = 13;
                                                            }
                                                        }
                                                    }

                                                } else if (e1.getType().equals("Bacon")) {
                                                    System.out.println("The enemy dropped some Bacon!!");
                                                    //add bacon to your inventory
                                                    int counts = 0;
                                                    for (int i = 0; i < 12; i++) {
                                                        if (h.getInvItem(i).equals("Bacon")) {
                                                            int tempS = h.getInvCount(i) + 1;
                                                            h.replaceInvCount(i, tempS);
                                                            counts++;
                                                        }
                                                    }
                                                    if (counts == 0) {
                                                        for (int i = 0; i < 12; i++) {
                                                            if (h.getInvItem(i).equals("Empty")) {
                                                                h.replaceInvItem(i, "Bacon");
                                                                h.replaceInvCount(i, 1);
                                                                i = 13;
                                                            }
                                                        }
                                                    }
                                                }
                                            }

                                            e1.setHealth(50 * h.getLevel());
                                        } else {
                                            System.out.println("Now the enemy is attacking you!");
                                            e1.attack(h);
                                            if (h.getHealth() <= 0) {
                                                System.out.println("you died :(");
                                                h.setHealth(100*h.getLevel());
                                                battleOn = false;
                                            } else {
                                                System.out.println("Your health: " + h.getHealth());
                                            }
                                        }
                                    } else {
                                        System.out.println("\nYou do not have any brekkys\n");
                                    }
                                    attacking = false;
                                    break;
                                default:
                                    System.out.println("Invalid input, try again");
                                    break;
                            }
                        }
                        break;
                    case 2: // heal
                        healing(h);
                        break;
                    case 3: // run away
                        Random r = new Random();//40% you cannot get away and the gremlin attacks you
                        if (h.getHealth() > 10) { //can't die while running away bc that's lame
                            int esc = r.nextInt(10) + 1;
                            if (esc <= 4) {
                                System.out.println("The evil gremlin wont stop chasing you!");
                                h.setHealth(h.getHealth() - 10);
                                System.out.println("\nYour health:" + h.getHealth()+ "\n");
                            } else {
                                System.out.println("You ran away...phew\n");
                                battleOn = false;
                            }
                        } else {
                            System.out.println("You ran away");
                            battleOn = false;
                        }
                        break;
                    default:
                        System.out.println("Wrong Input");
                        break;
                }
            }//Gremlin Encounter
        } else {
            if (haveBrekky && studented){
                System.out.println("A student is snoring loudly and blocking your way");
                System.out.println("He looks like he needs a Sausage, Egg, and Cheese maybe if you give him one he will help you out.");
                System.out.println("His information is vital to defeating the final boss!");
                System.out.println("Would you like to help him?");
                System.out.println("1. Yes\n2. No");
                help = bScan.nextInt();
                if (help==1){//Helping the student
                    System.out.println("zzzzzzzzzzz...I really need a brekky...zzzzzzzzzzzzz");
                    System.out.println("You gave the student the three ingredients.");
                    //Sausage Egg and Cheese is deleted from your inventory
                    for (int i = 0; i < 12; i++) {
                        if ((h.getInvItem(i).equals("Sausage")) || (h.getInvItem(i).equals("Cheese")) || (h.getInvItem(i).equals("Egg"))) {
                            if (h.getInvCount(i) == 1) {
                                h.replaceInvItem(i, "Empty");
                                h.replaceInvCount(i, 0);
                            } else {
                                int tempCount = h.getInvCount(i) - 1;
                                h.replaceInvCount(i, tempCount);
                            }
                        }
                    }
                    System.out.println("*student wakes up* Good looks Brotendo. Take this");
                    int tempCoin = h.getCoins()+1000;
                    h.setCoins(tempCoin);
                    System.out.println("He gave you 1000 big ones $$$");
                    System.out.println("He also gave you a scroll that says the recipe for Mega Brekky:");
                    String[][] table = {{"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "},
                            {"|  |  ", "|  |  ", "|  |  "}};
                    table[0][0] = "Bagel"; table[0][1] = "Bagel"; table[0][2] = "Bagel";
                    table[1][0] = "Sausage"; table[1][1] = "Pork Roll"; table[1][2] = "Bacon";
                    table[2][0] = "Egg"; table[2][1] = "Egg"; table[2][2] = "Egg";
                    table[3][0] = "Cheese"; table[3][1] = "Cheese"; table[3][2] = "Cheese";
                    table[4][0] = "Bagel"; table[4][1] = "Bagel"; table[4][2] = "Bagel";
                    System.out.println("Scroll:");
                    for (int row = 0; row < 5; row++) { // prints  crafting table
                        // For row 0...
                        System.out.println(); // Hit enter
                        for (int col = 0; col < 3; col++) {
                            // Individual values in 2d Array
                            System.out.print(table[row][col] + " ");
                        }
                    }
                    System.out.println("\n\nMake sure to press 7 in the crafting table to make it!!!!!!");
                    studented = false;
                }else{
                    System.out.println("That student seemed wise. Maybe he had some valuable information about how to beat the game");
                    System.out.println("Oh well, hopefully you seem him again");
                }

            } else {
                System.out.println("You found a mysterious room with a healing aura called the LONE RANGER");
                System.out.println("It gave you +50 health");
                h.setHealth(h.getHealth()+50);
            }
        }
    }


    void healing(Hero h) {
        World w1 = new World();
        Scanner bScan = new Scanner(System.in);
        boolean healing = true;
        int healCounter = w1.getHealCount();


        while (healing) { // main loop for healing

            System.out.println("How would you like to heal?");
            System.out.println("1. Use a potion.");
            System.out.println("2. Search for a hidden heal potion.");
            System.out.println("3. Cancel");
            int userInput = bScan.nextInt();

            switch (userInput) {
                case 1: // uses potion in inventory

                    boolean healPotionTF = false;

                    for (int i = 0; i < 12; i++) { // checks if user has heal potion
                        if (h.getInvItem(i).equals("Regular Heal Potion")) {
                            healPotionTF = true;
                        } else if (h.getInvItem(i).equals("OP Heal Potion")) {
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
                                    boolean rhpIng = true;
                                    while (rhpIng) {
                                        int oPCount = 0;
                                        for (int i = 0; i < 12; i++) { // adds health to hero
                                            if (h.getInvItem(i).equals("Regular Heal Potion")) {
                                                if (h.getHealth() < 70) {
                                                    int tempH = h.getHealth() + 30;
                                                    h.setHealth(tempH);
                                                } else {
                                                    h.setHealth(100);
                                                }
                                                if (h.getInvCount(i) == 1) {
                                                    h.replaceInvItem(i, "Empty");
                                                    h.replaceInvCount(i,0);
                                                } else {
                                                    int tempCount = h.getInvCount(i) - 1;
                                                    h.replaceInvCount(i, tempCount);
                                                }
                                                oPCount++;
                                                System.out.println("Regular Heal Potion used!\n");
                                                System.out.println("Your current health is: " + h.getHealth());
                                                System.out.println("\nWould you like to use another one?\n1. Yes\n2. No");
                                                userInput = bScan.nextInt();
                                                if (userInput == 2) {
                                                    rhpIng = false;
                                                }

                                            }
                                        }
                                        if (oPCount == 0) {
                                            System.out.println("You do not have a Regular Heal Potion");
                                            rhpIng = false;
                                        }
                                    }
                                    potionHeal = false;
                                    break;
                                case 2: // OP heal potion
                                    int oPCount2 = 0;
                                    for (int i = 0; i < 12; i++) {
                                        if (h.getInvItem(i).equals("OP Heal Potion")) {
                                            h.setHealth(h.getLevel()*100);
                                            if (h.getInvCount(i) == 1) { // changes inventory
                                                h.replaceInvItem(i, "Empty");
                                                h.replaceInvCount(i, 0);
                                                i = 13;
                                            } else {
                                                int tempCount = h.getInvCount(i) - 1;
                                                h.replaceInvCount(i, tempCount);
                                            }
                                            oPCount2++;
                                            System.out.println("OP Heal Potion used");
                                        }

                                    }
                                    if (oPCount2 == 0) {
                                        System.out.println("You do not have an OP Heal Potion");
                                    }
                                    potionHeal = false;
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
                        w1.setHealCount(1);
                    } else {
                        System.out.println("You already searched for hidden heal potion in this area!");
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
        } else if (mapColumn < 30 && mapColumn > 5) {
            potionLocCol = 1;
        }
        // sets location for hidden potion in the row
        if (mapRow>30) {
            potionLocRow = 2;
        } else if (mapRow < 30 && mapRow > 5) {
            potionLocRow = 1;
        }
        // sets location to 2,2 if both are originally 0,0
        if (potionLocCol == 0 && potionLocRow == 0) {
            potionLocCol = 2;
            potionLocRow = 2;
        }

        for (int row = 0; row < 3; row++) { // prints map
            // For row 0...
            System.out.println(); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(map[row][col] + " ");
            }
        }
        System.out.println("\nYou look around the world and need to decide where to look for a heal potion. However," +
                "you only have 5 moves!\n\nMake sure to choose carefully. ");

        while (moves < 5) {

            System.out.println("\nWhat direction would you like to move?");
            System.out.println("1. Left\n2. Right\n3. Up\n4. Down");
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
                int potionReplace = 0;
                for (int i = 0; i < 12; i++) {
                    if (h.getInvItem(i).equals("Regular Heal Potion")) {
                        int tempCount = h.getInvCount(i) + 1;
                        h.replaceInvCount(i, tempCount);
                        i = 13;
                        potionReplace++;
                    }
                }
                if (potionReplace == 0) {
                    for (int j = 0; j < 12; j++) {
                        if (h.getInvItem(j).equals("Empty")) {
                            h.replaceInvCount(j, 1);
                            h.replaceInvItem(j, "Regular Heal Potion");
                            j = 13;

                        }
                    }
                }

                System.out.println("\nYou found a Regular Heal Potion! Head back to the heal menu if you'd like to use it now.");
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
            System.out.println(); // Hit enter
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
            System.out.println(); // Hit enter
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
            System.out.println(); // Hit enter
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
            System.out.println(); // Hit enter
            for (int col = 0; col < 3; col++) {
                // Individual values in 2d Array
                System.out.print(m[row][col] + " ");
            }
        }

    }
}

