import java.util.Random;

public class Enemy {
    private int health;
    private int attackPower;
    private String type;
    private int coindrop;


    // Constructor
    Enemy() {
        this.health = 50;
        this.attackPower = 10;
        this.type = "fire";
    }

    void attack(Hero h) {
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(10)+1;
        if (rand <= 8) { // normal
            h.setHealth(h.getHealth() - (attackPower*h.getLevel()));
            System.out.println("Normal Strike");
        } else {  // critical strike
            h.setHealth(h.getHealth() - (attackPower*5*h.getLevel()));
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public int getCoindrop() {
        return coindrop;
    }

    public void setCoindrop(int coindrop) {
        this.coindrop = coindrop;
    }

    @Override
    public String toString() {
        return "Enemy" +
                "health:" + health +
                "Attack Power:" + attackPower +
                "type: '" + type + '\'' +
                '}';
    }


}
