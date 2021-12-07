import java.util.Random;
//30 points is stage 1, and the fighting mechanics
//shop,world, enemies, encounters, 2 other interesting things is monday.
//3:30 on thursday

public class Enemy {
    private int health;
    private int attackPower;
    private String type;
    private int coindrop; //make coin drop getter and setter????????

    // Constructor
    Enemy() {
        this.health = 50;
        this.attackPower = 10;
        this.type = "fire";
    }
//    public class Enemy1{
//        private int health;
//        private int attackPower
//    }
    void attack(Hero h) {    //did this in hero class line 21. idk if this should still be here or not - james
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
