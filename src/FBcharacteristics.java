import java.util.Random;

public class FBcharacteristics {
    private int health;
    private int attackPower;

    //Constructor
    FBcharacteristics() {
        this.health = 800;
        this.attackPower = 100;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    void attackFB (Hero h) {
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 5 * AP
        int rand = r.nextInt(10) + 1;
        if (rand <= 8) { // normal
            h.setHealth(h.getHealth() - (attackPower));
            System.out.println("Normal Strike bozo.");
        } else {  // critical strike
            h.setHealth(h.getHealth() - (attackPower * 2));
            System.out.println("THEY HIT A CRITICAL STRIKE!!...darn");
        }

    }
}
