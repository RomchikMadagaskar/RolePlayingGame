import java.util.Random;

public abstract class Gamer {
    private String name;
    private int agility;    //ловкость
    private int xp=100; //здоровье
    private int damage; //сила
    private int goodHit=0;
    private int experience; //опыт
    private int gold; //золото

    public Gamer(String name, int agility, int damage, int experience, int gold) {
        this.name=name;
        this.agility = agility;
        this.damage = damage;
        this.experience=experience;
        this.gold=gold;
    }
    public int attack(){
        if(setDamage()!=0){        //проверка на промах
            if(goodHit==5){    //проверка на критический удар
                goodHit=0;
                return damage*2;
            }
            return damage;
        }else {
            return 0;
        }
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

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getXp() {
        return xp;
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
}
