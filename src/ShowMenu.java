import java.util.Scanner;

public class ShowMenu {
    Scanner scanner=new Scanner(System.in);
    private int command;
    public void getStartMenu(){
        do{
            System.out.println( """
            Куды Вы хотите пойти:
            1. К торговцу
            2. В темный лес
            3. На выход
            """);
            command=selectCommand();
            switch (command){
               case 1 -> getMenuTrader();
               case 2 -> getMenuFight();
               case 3 -> System.out.println("Заходи еще...");
               default -> System.out.println("Введен не корректный пункт меню. Повторите ввод...");
            }
        }while(command!=3);

    }
    public void getMenuTrader(){
        do{
            System.out.println("""
                1. Начать/продолжить торговлю
                2. Вернуться в город
            """);
            command=selectCommand();
            switch (command){
                case 1->System.out.println("Начинаем торговлю");
                case 2->System.out.println("Заходи еще...");
                default -> System.out.println("Введен не корректный пункт меню. Повторите ввод...");
            }
        }while(command!=2);
    }
    public void getMenuFight(){
        do{
            System.out.println("""
                1. Начать/продолжить бой
                2. Вернуться в город
            """);
            command=selectCommand();
            switch (command){
                case 1->System.out.println("Начать/продолжить бой");
                case 2->System.out.println("Заходи еще...");
                default -> System.out.println("Введен не корректный пункт меню. Повторите ввод...");
            }
        }while(command!=2);

    }

    public int selectCommand(){
        int number;
        try{
            number= scanner.nextInt();
        }catch(NumberFormatException e){
            number=0;
        }
        return number;
    }
}
