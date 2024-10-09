import java.util.Random;
import java.util.Scanner;

public class GameWorld {
    private static Scanner scanner=new Scanner(System.in);
    Hero hero;
    public GameWorld() {

        while(hero==null){
            System.out.println("Введите имя игрока, его ловкость и силу через запятую");
            String string=getScanner();
            String[] stringArray=string.split(",");
            try{
               // hero=new Hero(stringArray[0],Integer.parseInt(stringArray[1]),Integer.parseInt(stringArray[2]));
            }
            catch(NumberFormatException e){
                System.out.println("Ошибка задания параметров.Введите корректные значения");
            }
        }
    }
    public String getScanner() {
        return scanner.nextLine();
    }



    public int setMenu(){
        int n=0;
        try{
            n=Integer.parseInt(scanner.nextLine());
        }catch(NumberFormatException e){
            System.out.println("Введен не корректный пункт меню. Повторите ввод...");
        }
        return n;
    }
//    public void fight(Hero hero,Gamer monster){
//        Random rnd=new Random();
//        //Gamer monster;
//        if(rnd.nextInt(100)>50) monster=new Goblin();
//        else monster=new Skeleton();
//        //fight
//
//        do{
//
//            if(hero.getHp()>0){
//                monster.setHp(monster.getHp()-hero.attack());
//            }else break;
//
//            if(monster.getHp()>0){
//                hero.setHp(hero.getHp()-monster.attack());
//            }else break;
//
//        }while(hero.getHp()<=0||monster.getHp()<=0);
//
//        if(hero.getHp()>0){
//        //    hero.fightWin(monster.getAgility(), monster.getDamage());
//        }
//    }
}
