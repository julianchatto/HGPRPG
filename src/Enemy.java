import java.util.Random;

public class Enemy {
    private int health;
    private int attackPower;
    private String type;

    Enemy() {
        this.health = 50;
        this.attackPower = 10;
        this.type = "fire";
        System.out.println("JAMES CORBETT ! ! ! ! ! CHANGE ! ! ! ! !");
    }

    void attack(Hero h) {
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(10)+1;
        if (rand <= 8) { // normal
            h.setHealth(h.getHealth() - attackPower);
        } else {  // critical strike
            h.setHealth(h.getHealth() - attackPower*5);
            System.out.println("Critical Strike!!");
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


    @Override
    public String toString() {
        return "Enemy" +
                "health:" + health +
                "Attack Power:" + attackPower +
                "type: '" + type + '\'' +
                '}';
    }
}
