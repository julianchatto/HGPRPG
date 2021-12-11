import java.util.Random;
import java.util.Scanner;

public class FinalBoss {
// if level > # then give option to fight final boss
    private int health;
    private int attackPower;
    private int coindrop;

   //Constructor
    FinalBoss() {
        this.health = 800;
        this.attackPower = 100;
    }
    void bossFight (Hero h, World w){
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
                    if (h.getHealth() <= 0) {
                        System.out.println("The CEO won this time, train up and fight him again.");
                        bossing= false;
                    } else {
                        //attack fn
                        System.out.println("You attacked the enemy");
                        if (health <= 0) { //enemy dies
                            System.out.println("Enemy health: 0");
                            System.out.println("You won!");
                            System.out.println("That enemy dropped some righteous loot");
                            h.setCoins(h.getCoins() + (h.getLevel() * 100));
                            System.out.println("You now have " + h.getCoins() + " dabloons...CHA CHING $$$");
                            h.setLevel(h.getLevel() + 1);
                            System.out.println("You also leveled up! level: " + h.getLevel());
                            bossing = false;

                        } else {
                            System.out.println("Enemy health:" + health);
                            System.out.println("Now the enemy is attacking you!");
                            //attack fn
                            if (h.getHealth() <= 0) {
                                System.out.println("you died :(");
                                h.setHealth(100);
                                bossing = false;
                            } else {
                                System.out.println("Your health: " + h.getHealth());
                            }
                        }
                    }
                    break;
                case 2: // heal
                    break;
                case 3: // run away
                    System.out.println("Wrong Input");

            }
        }
    }



    void attack (Hero h ) {
            Random r = new Random();
            // 20% of the time it is a CRITICAL HIT, 5 * AP
            int rand = r.nextInt(10) + 1;
            if (rand <= 8) { // normal
                h.setHealth(h.getHealth() - (attackPower));
                System.out.println("Normal Strike bozo.");
            } else {  // critical strike
                h.setHealth(h.getHealth() - (attackPower * 5));
                System.out.println("THEY HIT A CRITICAL STRIKE!!...darn");
            }

    }


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getCoindrop() {
        return coindrop;
    }

    public void setCoindrop(int coindrop) {
        this.coindrop = coindrop;
    }
}
