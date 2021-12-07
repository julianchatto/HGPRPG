import java.util.Arrays;
import java.util.Random;

public class Hero {
    // Attributes
    private int health;
    private String name;
    private String[] inventory = new String[8];
    private int coins;
    private int level;


    // Constructor
    Hero() {
        this.health = 100;
        this.name = "Petcaugh";
        this.inventory[0] = "Potion";
        this.inventory[1] = "Sausage";
        this.coins = 1000;
        this.level = 1;
    }

    //Helper Method
    void attack(Enemy e) { // e becomes e1, or e2, or e3
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(10)+1;
        if (rand <= 8) { // normal
            e.setHealth(e.getHealth() - (25*level));
        } else {  // critical strike
            e.setHealth(e.getHealth() - (5*25*level));
            System.out.println("Critical Strike!!");
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "health=" + health +
                ", name='" + name + '\'' +
                ", inventory=" + Arrays.toString(inventory) +
                ", coins=" + coins +
                ", level=" + level +
                '}';
    }
}

