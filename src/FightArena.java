public class FightArena {
    public void fight(Gamer hero, Gamer monster,GamesArea.WinLost winLost){
        //TODO
        Runnable runnable=()->{
            boolean isStopBattle = false;
            int step = 1;
            while (!isStopBattle) {
                if(step++%2==0) isStopBattle=nextHit(monster,hero,winLost);
                else isStopBattle=nextHit(hero,monster,winLost);
                try{
                    Thread.sleep(1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        Thread thread=new Thread(runnable);
        thread.start();
    }
    public boolean nextHit(Gamer attack, Gamer guard,GamesArea.WinLost winLost){
        int hit=attack.attack();

        int guardHp=guard.getHp()-hit;
        if(hit>0){
            System.out.println(String.format("%s наносит %d единиц урона...",attack.getName(),hit ));
            if(guardHp>0){
                System.out.println(String.format("У %s осталось %d единиц здоровья...",guard.getName(),guardHp));
                guard.setHp(guardHp);
            }else{
                if(guard instanceof Hero){
                    System.out.println("Монстры победили... Вы проиграли(....");
                    winLost.battleLost();
                }else {
                    System.out.println(String.format("Призванный герой побеждает!!! Забирайте свою награду!!! Залото: %d , Опыт: %d",guard.getGold(), guard.getXp()));
                    attack.setXp(attack.getXp()+guard.getXp());
                    attack.setGold((attack.getGold())+guard.getGold());
                    attack.levelUp();
                    winLost.battleWin();
                }
                return true;
            }
        }else {
            System.out.println(String.format("%s промахнулся...",attack.getName()));
        }
        return false;
    }
}
