import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GamesArea {

   private static BufferedReader br;
   private static Gamer player=null;
   private static FightArena fightArena=null;

   private static Trader trader=null;

   public static void main(String[] args) {
        fightArena=new FightArena();

        br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите имя игрока: ");
       try {
           linkMenu(br.readLine());
       } catch (IOException e) {
           throw new RuntimeException(e);
       }
   }
    private static void linkMenu(String str) throws IOException{
        if(player==null){
            player=new Hero(str,100,20,20,0,0);
            System.out.println("В неравную битву вступает "+player.getName()+" !!!");
        }
        if(trader==null){
            trader=new Trader();
        }
        switch (str){
            case "1":{
                System.out.println(trader.sell(Trader.Goods.POTION)+"(м)");
                System.out.println(trader.sell(Trader.Goods.POTION2)+"(б)");
                System.out.println("м/б");
                linkMenu(br.readLine());
            }
            break;
            case "2":{
                fightStart();
            }
            break;
            case "м":{
                if (player.getGold() > 30) {
                    player.setGold(player.getGold() - 30);
                    player.setHp(player.getHp() + 30);
                    System.out.println("Восстановлено 30 единиц hp");
                } else {
                    System.out.println("Недостаточно золота!!!");
                }
            }
            break;
            case "б":{
                if (player.getGold() > 50) {
                    player.setGold(player.getGold() - 50);
                    player.setHp(player.getHp() + 50);
                    System.out.println("Восстановлено 50 единиц hp");
                } else {
                    System.out.println("Недостаточно золота!!!");
                }
            }
            break;
            case "3":{
                System.out.println("Возвращайся для новых побед!!!");
                System.exit(1);
            }
            break;
            case "да":{
                linkMenu("2");
            }
            break;
            case "нет" :{
                menu();
                linkMenu(br.readLine());
            }
        }
        if(!str.equals("2")) menu();
        linkMenu(br.readLine());
    }
    private static void menu(){
        System.out.println( """
            Куды Вы хотите пойти:
            1. К торговцу
            2. В темный лес
            3. На выход
            """);
    }

    private static  void fightStart(){
        fightArena.fight(player, createMonsters(), new WinLost() {
            @Override
            public void battleWin() {
                System.out.println(String.format("Поздравляю с победой! твои текущие показатели:Уровень - %d, Опыт - %d, Золото - %d, Здоровье - %d ", player.getLevel(),player.getXp(),player.getGold(),player.getHp()));
                System.out.println("Продолжаем поход? (да/нет)");
                try {
                    linkMenu(br.readLine());
                } catch (IOException e){
                    e.printStackTrace();
                }
            }

            @Override
            public void battleLost() {
                System.out.println("Грусть Печаль ты проиграл.... заходи еще в игру и получи еще шанс на победу!");
                    System.exit(1);
            }
        });
    }
    private static Gamer createMonsters(){
       int rnd=(int) (Math.random()*100);
       if(rnd<50) {
           return new Goblin("Гоблин", 50, 10, 10, 50, 20);
       }
       else if (rnd > 50) {
           return new Skeleton("Скелет", 25, 20, 20, 50, 10);
        }
       else if (rnd==50) {
           return new LameDragon("Дракон уже не тот",200,30,50,50,100);
       }
        return null;
    }

    interface WinLost{
            void battleWin();
            void battleLost();
    }
}


