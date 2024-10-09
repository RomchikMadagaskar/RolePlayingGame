public class Hero extends Gamer implements GamerTrade{
    private int score;


    public Hero(String name,int hp,int agility,int damage,int xp,int gold) {

        super(name, hp,agility,damage,xp,gold);
    }
//    public void trade(int gold){
//        int xpplus=0;
//        int experience=0; //опыт
//
//        setHp(getHp()+xpplus);
//    }

//    ___
//    public void fightWin(int gold, int score){
//        setGold(gold);
//        //setExperience(score);
//        int expPlus=getExperience()/100;
//        if(expPlus>0){
//            setDamage(getDamage()+5*expPlus);
//            setAgility(getAgility()+5*expPlus);
//            setGold(getGold()+100);
//        }
//        setExperience(getExperience()+score);
//    }
    public void figtLos(){

    }
}
