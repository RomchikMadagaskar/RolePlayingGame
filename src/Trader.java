public class Trader implements GamerTrade{

    @Override
    public String sell(Goods goods) {
        String result="";
        if(goods==Goods.POTION){
            result="1. Малое зелье здоровья";
        } else if (goods==Goods.POTION2) {
            result="2. Большое зелье здоровья";
        }
        return result;
    }
    public enum Goods{
        POTION,
        POTION2
    }
}
