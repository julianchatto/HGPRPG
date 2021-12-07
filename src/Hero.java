import java.util.Arrays;
import java.util.Random;

public class Hero {
    // Attributes
    private int health;
    private String name;
    private String[] inventory = new String[5];
    private int coins;


    // Constructor
    Hero() {
        this.health = 100;
        this.name = "Petcaugh";
        this.inventory[0] = "Potion";
        this.coins = 1000;
    }

    //Helper Method
    void attack(Enemy e) { // e becomes e1, or e2, or e3
        Random r =  new Random();
        int strike = r.nextInt(20);
        if (strike <= 10) {
            System.out.println("Critical Strike!!!");
            int tempH = e.getHealth() - 50;                 //Critical Hit attack power*5????
            e.setHealth(tempH);
        } else   {
            int tempH = e.getHealth() - 10;
            e.setHealth(tempH);
        }
    }

    // Methods

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getInventory() {
        return inventory;
    }

    public void setInventory(String[] inventory) {
        this.inventory = inventory;
    }

    public int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    @Override
    public String toString() {
        return "Hero " + name + "; Health: " + health + "Coins: " + coins + "; inventory: " + Arrays.toString(inventory);
    }
}

