import java.util.Random;

public class Enemy {
    private int health;
    private int attackPower;
    private String type;
    private int coindrop;


    // Constructor
    Enemy() {
        this.health = 50;
        this.attackPower = 15;
        this.type = "fire";
    }

    void attack(Hero h) {
        Random r = new Random();
        // 20% of the time it is a CRITICAL HIT, 2 * AP
        int rand = r.nextInt(15)+1;
        if (rand <= 9) { // normal
            h.setHealth(h.getHealth() - (attackPower*h.getLevel()));
            System.out.println("They hit a Normal Strike");
        } else if (rand>=14){  // critical strike
            h.setHealth(h.getHealth() - (attackPower*2*h.getLevel()));
            System.out.println("THEY HIT A CRITICAL STRIKE!!...darn");
        }else{
            if (type.equals("Sausage")&& h.getMagicPowerType().equals("Bacon Beast")){
                System.out.println("The Gremlin hit a super effective Magic Strike");
                h.setHealth(h.getHealth()-((attackPower+30)*h.getLevel()*2));
            }else if (type.equals("Pork Roll")&& h.getMagicPowerType().equals("Sausage Slammer")){
                System.out.println("The Gremlin hit a super effective Magic Strike");
                h.setHealth(h.getHealth()-((attackPower+30)*h.getLevel()*2));
            }else if (type.equals("Bacon")&& h.getMagicPowerType().equals("Pork Roll Pounder")){
                System.out.println("The Gremlin hit a super effective Magic Strike");
                h.setHealth(h.getHealth()-((attackPower+30)*h.getLevel()*2));
            }else{
                h.setHealth(h.getHealth()-((attackPower+20)*h.getLevel()));
                System.out.println("They hit a Magic Strike!");
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
