package OtherPractice.ThoughtWorks;

//单例模式构建一个Market对象，并维护一个商场商品hashmap<商品、商品数量>
public class Market2 {
    private volatile static Market2 market;
    private Market2(){}
    public Market2 getMarket(){
        if (market==null){
            synchronized (Market2.class){
                if (market==null)
                    market=new Market2();
            }
        }
        return market;
    }
}
