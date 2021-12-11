import java.util.Arrays;
import java.util.Random;

public class Hero {
    // Attributes
    private int health;
    private String name;
    private String[] inventory = new String[8];
    private int[] inventoryCount = new int[8];
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
        this.inventory[0] = "Empty";
        this.inventory[1] = "Empty";
        this.inventory[2] = "Empty";
        this.inventory[3] = "Empty";
        this.inventory[4] = "Empty";
        this.inventory[5] = "Empty";
        this.inventory[6] = "Empty";
        this.inventory[7] = "Empty";
        this.inventoryCount[0] = 2;
        this.inventoryCount[1] = 0;
        this.inventoryCount[2] = 0;
        this.inventoryCount[3] = 0;
        this.inventoryCount[4] = 0;
        this.inventoryCount[5] = 2;
        this.inventoryCount[6] = 0;
        this.inventoryCount[7] = 0;

    }
    // Allows for interactions with inventory
    void replaceInvItem(int i, String s) {
        inventory[i] = s;

    }
    String getInvItem(int i) {
        return inventory[i];
    }
    void replaceInvCount(int i, int s) {
        inventoryCount[i] = s;
    }
    int getInvCount(int i) {
        return inventoryCount[i];
    }

    //Helper Method
    void attack(Enemy e) { // e becomes e1, or e2, or e3
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(15)+1;
        if (rand <= 9) { // normal
            e.setHealth(e.getHealth() - 25*level);
            System.out.println("You hit a normal strike");
        } else if (rand >= 14) {  // critical strike
            e.setHealth(e.getHealth() - 25+level*2);
            System.out.println("Critical Strike!!");
        } else {
            if (e.getType().equals("Sausage")&& magicPowerType.equals("Sausage Slammer")){
                System.out.println("YOU USED YOUR MAGIC POWER TO HIT A SAUSAGE SLAM!! SUPER EFFECTIVE!!");
                e.setHealth(e.getHealth() - 40*level*2);
            }else if (e.getType().equals("Pork Roll")&& magicPowerType.equals("Pork Roll Pounder")){
                System.out.println("YOU USED YOUR MAGIC POWER TO ABSOLUTELY POUND THAT PORK ROLL GREMLIN!! SUPER EFFECTIVE!");
                e.setHealth(e.getHealth() - 40*level*2);
            }else if (e.getType().equals("Bacon")&& magicPowerType.equals("Bacon Beast")){
                System.out.println("YOU ARE A BACON BEAST SO YOUR MAGIC POWER ATTACK WAS SUPER EFFECTIVE!");
                e.setHealth(e.getHealth() - 40*level*2);
            }else{
                e.setHealth(e.getHealth() - 40*level);
                System.out.println("Magic Power!!");
            }
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

    public String[] getInventory(int i) {
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

    public int[] getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(int[] inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    @Override
    public String toString() {
        return name+"'s Stats:" +
                "\nName: " + getName() +
                "\nHP: " + health +
                 "\nmagic power: " + magicPowerType +
                "\ninventory:" + Arrays.toString(inventory) +
                "\ncoins:" + coins +
                "\nlevel:" + level
                ;
    }

    public String toStringInventory() {
        return "Your inventory: " + Arrays.toString(inventory);
    }
}

