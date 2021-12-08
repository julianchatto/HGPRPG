public class FinalBoss {
    private int health;
    private int attackPower;

    FinalBoss(){
        this.health=1000;
        this.attackPower=100;
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

    @Override
    public String toString() {
        return "FinalBoss{" +
                "health=" + health +
                ", attackPower=" + attackPower +
                '}';
    }

    void bossing (Hero h,FinalBoss f) {
        if (h.getLevel()<5){ //need to be level 5 to fight CEO
            System.out.println("The Aramark CEO is no joke. Try defeating more breakfast gremlins before you take him on.");
        } else{
            //fight final boss normally, still should be almost impossible without mega brekky
        }

    }
}
