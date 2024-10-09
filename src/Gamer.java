import java.util.Random;

public abstract class Gamer implements GamerBattle{
    private String name;
    private int agility;    //ловкость dexterity
    private int hp =100; //здоровье
    private int damage; //сила strength
    //private int goodHit=0;
    private int xp; //опыт
    private int gold; //золото

    public Gamer(String name, int hp, int agility, int damage, int xp, int gold) {
        this.name=name;
        this.hp=hp;
        this.agility = agility;
        this.damage = damage;
        this.xp=xp;
        this.gold=gold;
    }
    @Override
    public int attack(){
        if(agility*3>(int)(Math.random()*100 return damage;
        else return 0;


//        if(setDamage()!=0){        //проверка на промах
//            if(goodHit==5){    //проверка на критический удар
//                goodHit=0;
//                return damage*2;
//            }
//            return damage;
//        }else {
//            return 0;
//        }
    }

    public int setDamage() {
        int nextBlow=0;
        Random rnd=new Random();
        if(rnd.nextInt(100)<=agility*3) nextBlow=damage;
        else{
            System.out.println("ПРОМАХ!!!!");
            goodHit=0;
        }
        if(goodHit>=5){    //проверка на критический удар
            System.out.println("КРИТИЧЕСКИЙ УДАР Х2!!!");
            goodHit=0;
            nextBlow=damage*2;
        }else goodHit++;

        return nextBlow;
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
}
