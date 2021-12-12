import java.util.Random;
import java.util.Scanner;

public class FinalBoss {
   //Constructor
    FinalBoss() {}

    void bossFight (Hero h, World w){
        FBcharacteristics fB1 = new FBcharacteristics();
        boolean bossing = true;
        int userInput;
        Scanner s = new Scanner(System.in);
        while(bossing){
            System.out.println("The CEO stands in your path...");
            System.out.println("Choose an option(1-3)");
            System.out.println("1. Attack");
            System.out.println("2. Heal");
            System.out.println("3. Run Away");
            userInput = s.nextInt();
            switch (userInput) {
                case 1: // attack
                    boolean attacking = true;
                    while (attacking) {
                        System.out.println("How would you like to attack?\n1. Normal\n2. Use a breaky");
                        int userInput2 = s.nextInt();
                        switch (userInput2) {
                            case 1:
                                if (h.getHealth() <= 0) {
                                    System.out.println("You are already dead. You must heal first!");
                                    bossing = false;
                                } else {
                                    h.attackFB(fB1);
                                    System.out.println("You attacked the enemy");
                                    if (fB1.getHealth() <= 0) { //enemy dies
                                        System.out.println("Enemy health: 0");
                                        System.out.println("You won!");
                                        System.out.println("That Aramark CEO dropped some righteous loot");
                                        h.setCoins(2147483647);
                                        System.out.println("You now have " + h.getCoins() + " dabloons...CHA CHING $$$");
                                        h.setLevel(h.getLevel() + 1);
                                        System.out.println("You also leveled up! level: " + h.getLevel());
                                        bossing = false;
                                    } else {
                                        System.out.println("\nAramark CEO Health: " + fB1.getHealth());
                                        System.out.println("\nNow the enemy is attacking you!");
                                        fB1.attackFB(h);
                                        if (h.getHealth() <= 0) {
                                            System.out.println("you died :(");
                                            h.setHealth(100);
                                            bossing = false;
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
                                    } else if (h.getInvItem(i).equals("Mega Brekky")){
                                        breakyTF = true;
                                    }
                                }
                                if (breakyTF) {
                                    boolean brekkyDam = true;

                                    while (brekkyDam) { // to choose what potion user wants to use

                                        System.out.println("Which breaky would you like to use?");
                                        System.out.println("1. Bacon Egg N'Cheese");
                                        System.out.println("2. Sausage Egg N'Cheese");
                                        System.out.println("3. Pork Roll Egg N'Cheese");
                                        System.out.println("4. Mega Brekky");
                                        System.out.println("5. Cancel");
                                        userInput = s.nextInt();
                                        switch (userInput) {
                                            case 1: // Bacon
                                                int oPCount = 0;

                                                for (int i = 0; i < 12; i++) { // adds health to hero
                                                    if (h.getInvItem(i).equals("Bacon Egg N'Cheese")) {
                                                        oPCount++;
                                                        if (h.getInvCount(i) == 1) {
                                                            h.replaceInvItem(i, "Empty");
                                                            h.replaceInvCount(i, 0);
                                                        } else {
                                                            int tempC = h.getInvCount(i) - 1;
                                                            h.replaceInvCount(i,tempC);
                                                        }
                                                        i = 13;
                                                        int tempH = fB1.getHealth() - 60;
                                                        fB1.setHealth(tempH);
                                                        System.out.println("Bacon Egg N'Cheese used!\n");
                                                        System.out.println("Enemy health is: " + fB1.getHealth());
                                                    }
                                                }
                                                if (oPCount == 0) {
                                                    System.out.println("You do not have a Bacon Egg N'Cheese!");
                                                }
                                                brekkyDam = false;
                                                break;
                                            case 2: // Sausage
                                                int oPCount2 = 0;

                                                for (int i = 0; i < 12; i++) { // adds health to hero
                                                    if (h.getInvItem(i).equals("Sausage Egg N'Cheese")) {
                                                        oPCount2++;
                                                        if (h.getInvCount(i) == 1) {
                                                            h.replaceInvItem(i, "Empty");
                                                            h.replaceInvCount(i, 0);
                                                        } else {
                                                            int tempC = h.getInvCount(i) - 1;
                                                            h.replaceInvCount(i,tempC);
                                                        }
                                                        i = 13;
                                                        int tempH2 = fB1.getHealth() - 60;
                                                        fB1.setHealth(tempH2);
                                                        System.out.println("Sausage Egg N'Cheese used!\n");
                                                        System.out.println("Enemy health is: " + fB1.getHealth());
                                                    }
                                                }
                                                if (oPCount2 == 0) {
                                                    System.out.println("You do not have a Sausage Egg N'Cheese!");
                                                }
                                                brekkyDam = false;
                                                break;
                                            case 3: // Pork Roll
                                                int oPCount3 = 0;

                                                for (int i = 0; i < 12; i++) { // adds health to hero
                                                    if (h.getInvItem(i).equals("Pork Roll Egg N'Cheese")) {
                                                        oPCount3++;
                                                        if (h.getInvCount(i) == 1) {
                                                            h.replaceInvItem(i, "Empty");
                                                            h.replaceInvCount(i, 0);
                                                        } else {
                                                            int tempC = h.getInvCount(i) - 1;
                                                            h.replaceInvCount(i,tempC);
                                                        }
                                                        i = 13;
                                                        int tempH3 = fB1.getHealth() - 60;
                                                        fB1.setHealth(tempH3);
                                                        System.out.println("Pork Roll Egg N'Cheese used!\n");
                                                        System.out.println("Enemy health is: " + fB1.getHealth());
                                                    }
                                                }
                                                if (oPCount3 == 0) {
                                                    System.out.println("You do not have a Pork Roll Egg N'Cheese!");
                                                }
                                                brekkyDam = false;
                                                break;
                                            case 4:
                                                int oPCount4 = 0;

                                                for (int i = 0; i < 12; i++) { // adds health to hero
                                                    if (h.getInvItem(i).equals("Mega Brekky")) {
                                                        oPCount4++;
                                                        if (h.getInvCount(i) == 1) {
                                                            h.replaceInvItem(i, "Empty");
                                                            h.replaceInvCount(i, 0);
                                                        } else {
                                                            int tempC = h.getInvCount(i) - 1;
                                                            h.replaceInvCount(i,tempC);
                                                        }
                                                        i = 13;
                                                        int tempH4 = fB1.getHealth() - 400;
                                                        fB1.setHealth(tempH4);
                                                        System.out.println("Mega Brekky used!\n");
                                                        System.out.println("Enemy health is: " + fB1.getHealth());
                                                    }
                                                }
                                                if (oPCount4 == 0) {
                                                    System.out.println("You do not have a Mega Brekky!");
                                                }
                                                brekkyDam = false;
                                                break;
                                            case 5:
                                                brekkyDam = false;
                                                break;
                                            default:
                                                System.out.println("Invalid input, try again");
                                                break;
                                        }
                                    }
                                    if (fB1.getHealth() <= 0) { //enemy dies
                                        System.out.println("Aramark CEO health: 0");
                                        System.out.println("You won!");
                                        System.out.println("That enemy dropped some righteous loot");
                                        h.setCoins(2147483647);
                                        System.out.println("You now have " + h.getCoins() + " dabloons...CHA CHING $$$");
                                        h.setLevel(h.getLevel() + 1);
                                        System.out.println("You also leveled up! level: " + h.getLevel());
                                        bossing = false;
                                    } else {
                                        System.out.println("Now the Aramark CEO is attacking you!");
                                        fB1.attackFB(h);
                                        if (h.getHealth() <= 0) {
                                            System.out.println("you died :(");
                                            h.setHealth(100);
                                            bossing = false;
                                        } else {
                                            System.out.println("Your health: " + h.getHealth());
                                        }
                                    }
                                } else {
                                    System.out.println("\nYou do not have any breakys\n");
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
                    w.healing(h);
                    break;
                case 3: // run away
                    Random r = new Random();//40% you cannot get away and the gremlin attacks you
                    if (h.getHealth() > 10) { //can't die while running away bc that's lame
                        int esc = r.nextInt(10) + 1;
                        if (esc <= 4) {
                            System.out.println("the Aramark CEO wont stop chasing you");
                            h.setHealth(h.getHealth() - 10);
                            System.out.println("your health:" + h.getHealth());
                        } else {
                            System.out.println("You ran away...phew");
                            bossing = false;
                        }
                    } else {
                        System.out.println("You ran away");
                        bossing = false;
                    }
                    break;
                default:
                    System.out.println("Wrong Input, try again");
                    break;
            }
        }
    }







}
