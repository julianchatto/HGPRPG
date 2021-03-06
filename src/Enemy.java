import java.util.Random;

public class Enemy {
    private int health;
    private int attackPower;
    private String type;

    // Constructor
    Enemy() {
        this.health = 50;
        this.attackPower = 10;
        this.type = "fire";
    }

    // enemy attack hero
    void attack(Hero h) {
        Random r = new Random();
        int rand = r.nextInt(15)+1;

        if (rand <= 9) { // normal
            h.setHealth(h.getHealth() - (attackPower*h.getLevel()));
            System.out.println("They hit a Normal Strike");
        } else if (rand>=14) {  // critical strike
            h.setHealth(h.getHealth() - (attackPower*2*h.getLevel()));
            System.out.println("THEY HIT A CRITICAL STRIKE!!...darn");
        } else { // magic

            if (type.equals("Sausage") && h.getMagicPowerType().equals("Bacon Beast")) { // sausage w/ bacon
                System.out.println("The Gremlin hit a super effective Magic Strike");
                h.setHealth(h.getHealth()-((attackPower+30)*h.getLevel()*2));
            } else if (type.equals("Pork Roll") && h.getMagicPowerType().equals("Sausage Slammer")) { // pork roll w/ bacon
                System.out.println("The Gremlin hit a super effective Magic Strike");
                h.setHealth(h.getHealth()-((attackPower+30)*h.getLevel()*2));
            } else if (type.equals("Bacon") && h.getMagicPowerType().equals("Pork Roll Pounder")) { // bacon w/ pork roll
                System.out.println("The Gremlin hit a super effective Magic Strike");
                h.setHealth(h.getHealth()-((attackPower+30)*h.getLevel()*2));
            } else { // regular magic
                h.setHealth(h.getHealth()-((attackPower+20)*h.getLevel()));
                System.out.println("They hit a Magic Strike!");
            }
        }

    }
    // getters/setters
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

}
