public class Hero extends Gamer implements GamerTrade{
    private int score;


    public Hero(String name) {

        super(name, 25, 20,0,0);
    }
    public void trade(int gold){
        int xpplus=0;private int experience=0; //опыт

        setXp(getXp()+xpplus);
    }
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
