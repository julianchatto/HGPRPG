import java.util.Random;

public class FinalBoss {
// if level > # then give option to fight final boss
    private int health;
    private int attackPower;
    private int coindrop;

   //Constructor
    FinalBoss() {
        this.health = 200;
        this.attackPower = 30;
    }

    void bossing (Hero h) {
        boolean bossing = true;
        while (bossing) {
            Random r = new Random();
            // 20% of the time it is a CRITICAL HIT, 5 * AP
            int rand = r.nextInt(10) + 1;
            if (rand <= 8) { // normal
                h.setHealth(h.getHealth() - (attackPower * h.getLevel()));
                System.out.println("Normal Strike bozo.");
            } else {  // critical strike
                h.setHealth(h.getHealth() - (attackPower * 5 * h.getLevel()));
                System.out.println("THEY HIT A CRITICAL STRIKE!!...darn");
            }
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
