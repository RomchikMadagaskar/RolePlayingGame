public class FightArena {
    public void fight(Gamer hero, Gamer monster){
        boolean isStopBattle=false;
        int step=0;
        while(!isStopBattle){

        }
    }
    public void nextHit(Gamer attack, Gamer guard,GamesArea.WinLost winLost){
        int hit=attack.attack();
        int guardHp=guard.getHp()-hit;

        if(hit>0){
            System.out.println(String.format("%s наносит %d единиц урона...",attack.getName(),hit ));
            if(guardHp>0){
                System.out.println(String.format("У %s осталось %в единиц здоровья...",guard.getName(),guardHp));
                guard.setHp(guardHp);
            }else{
             if(guard instanceof Hero){
                 System.out.println("Монстры победили... Вы проиграли(....");
                 winLost.battleLost();
             }else {
                 System.out.println(String.format("Призванный герой побеждает!!! Забирайте свою награду!!! Залото: %d , Опыт: %d",guard.getGold(), guard.getXp()));
                 attack.setXp(attack.getXp()+guard.getXp());
                 attack.setGold((attack.getGold())+guard.getGold());
                 winLost.battleWin();
             }
            }
        }else {
            System.out.println(String.format("%s промахнулся...",attack.getName()));
        }
    }
}
