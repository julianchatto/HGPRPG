import java.util.Arrays;
import java.util.Random;

public class Hero {
    // Attributes
    private int health;
    private String name;
    private String[] inventory = new String[8];
    private int coins;
    private int level;
    private String magicPowerType;


    // Constructor
    Hero() {
        this.health = 100;
        this.name = "Petcaugh";
        this.coins = 0;
        this.level = 1;
        this.magicPowerType = "Fire";
    }

    //Helper Method
    void attack(Enemy e) { // e becomes e1, or e2, or e3
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(15)+1;
        if (rand <= 9) { // normal
            e.setHealth(e.getHealth() - 25*level);
            System.out.println("You hit a normal strike");
        } else if (rand >= 13) {  // critical strike
            e.setHealth(e.getHealth() - 25+level*5);
            System.out.println("Critical Strike!!");
        } else {
            e.setHealth(e.getHealth() - 40 + level);
            System.out.println("Magic Power!!");
        }
    }

    void attackFB(FinalBoss fB) { // e becomes e1, or e2, or e3
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(15)+1;
        if (rand <= 9) { // normal
            fB.setHealth(fB.getHealth() - 25*level);
            System.out.println("You hit a normal strike");
        } else if (rand >= 13) {  // critical strike
            fB.setHealth(fB.getHealth() - 25+level*5);
            System.out.println("Critical Strike!!");
        } else {
            fB.setHealth(fB.getHealth() - 40 + level);
            System.out.println("Magic Power!!");
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

    public String getMagicPowerType() {
        return magicPowerType;
    }

    public void setMagicPowerType(String magicPowerType) {
        this.magicPowerType = magicPowerType;
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

    public String toStringInventory() {
        return "Your inventory: " + Arrays.toString(inventory);
    }
}

