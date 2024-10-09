import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class GamesArea {

   private static BufferedReader br;
   private static Gamer player=null;
   private static FightArena fightArena=null;

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
        }
        System.out.println("В неравную битву вступает "+player.getName()+" !!!");
        menu();
        switch (str){
            case "1":{
                System.out.println("Торговец еще не приехал");
                linkMenu(br.readLine());

            }
            break;
            case "2":{
                fightStart();
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
        linkMenu(br.readLine());
    }
    private static void menu(){
        System.out.println( """
            Куды Вы хотите пойти:
            1. К торговцу
            2. В темный лесы
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
           System.out.println("Здесь будет дракон, а пока скелет");
           return new Skeleton("Скелет",25,20,20,50,10);
       }
       return null;
    }

    interface WinLost{
            void battleWin();
            void battleLost();
    }

}


