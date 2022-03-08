package OtherPractice.ThoughtWorks;

import java.util.HashMap;

public class Market {
    private volatile static Market market;
    private HashMap<Integer,Integer> hashMap;
    private Market(){
        //私有化构造函数
        hashMap=new HashMap<>();
        hashMap.put(2,1);
    }
    public static Market getMarket(){
        if (market==null){
            synchronized (Market.class){
                if (market==null){
                    market=new Market();
                }
            }
        }
        return market;
    }

    public HashMap<Integer, Integer> getHashMap() {
        return hashMap;
    }

    private void add(int key, int value){
        hashMap.put(key,value);
    }

    public static void main(String args[]){
        Market market=Market.getMarket();
        System.out.println(market.getHashMap().get(2));
        market.getHashMap().put(2,3);
        Market market2=Market.getMarket();
        System.out.println(market2.getHashMap().get(2));
    }
}
