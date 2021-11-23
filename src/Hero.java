import java.util.Arrays;

public class Hero {
    // Attributes
    private int health;
    private String name;
    private String[] inventory = new String[5];


    // Constructor
    Hero() {
        this.health = 100;
        this.name = "Petcaugh";
        this.inventory[0] = "Potion";

    }

    //Helper Method
    void attack(Enemy e) { // e becomes e1, or e2, or e3
        int tempH = e.getHealth() - 10;
        e.setHealth(tempH);
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



    @Override
    public String toString() {
        return "Hero " + name + "; Health: " + health + "; inventory: " + Arrays.toString(inventory);
    }
}

