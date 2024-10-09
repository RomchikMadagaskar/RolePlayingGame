import java.util.Random;

public abstract class Gamer implements GamerBattle{
    private String name;
    private int agility;    //ловкость dexterity
    private int hp =100; //здоровье
    private int damage; //сила strength
    private int xp; //опыт
    private int gold; //золото
    int level=1;
    int startXp=100;
    int critDown=0;

    public Gamer(String name, int hp, int agility, int damage, int xp, int gold) {
        this.name=name;
        this.hp=hp;
        this.agility = agility;
        this.damage = damage;
        this.xp=xp;
        this.gold=gold;
    }
    @Override
    public int attack() {
        if (agility * 3 > (int) (Math.random() * 100)) {
            if (critDown > 4) {
                critDown = 0;
                System.out.println("КРИТИЧЕСКИЙ УДАР!!!x2");
                return damage * 2;
            } else {
                critDown++;
                return damage;
            }
        } else {
            critDown = 0;
            return 0;
        }
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getHp() {
        return hp;
    }

    public int getAgility() {
        return agility;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    public int getXp() {
        return xp;
    }
    public int getGold(){
        return gold;
    }
    public void setXp(int xp){
        this.xp=xp;
    }
    public void setGold(int gold){
        this.gold=gold;
    }
    public void levelUp(){
        if(startXp*level<xp){
            level++;
            agility+=+10;
            hp+=10;
            damage+=10;
            gold+=100;
        }
    }
    public int getLevel(){
        return level;
    }

}
