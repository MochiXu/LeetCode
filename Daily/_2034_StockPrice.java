package Daily;

import java.util.*;

public class _2034_StockPrice {


    TreeMap<Integer, Integer> time_price;
    TreeMap<Integer, Integer> price_count;//

    public _2034_StockPrice() {
        time_price = new TreeMap<>();
        price_count = new TreeMap<>();
    }

    public void update(int timestamp, int price) {

        if (time_price.get(timestamp) == null) {//不存在，则直接插入
            time_price.put(timestamp, price);

            //新增price的数量
            if (price_count.get(price) == null)
                price_count.put(price, 1);
            else price_count.put(price, price_count.get(price) + 1);
        } else {//已经存在
            int old_price=time_price.get(timestamp);
            if(old_price!=price){
                //将old_price的数量减去1
                int count=price_count.get(old_price);
                if(count==1) price_count.remove(old_price);
                else price_count.put(old_price,count-1);
                //新增price的数量
                if (price_count.get(price) == null)
                    price_count.put(price, 1);
                else price_count.put(price, price_count.get(price) + 1);
                //新增time--price字段
                time_price.put(timestamp, price);
            }

        }


    }

    public int current() {
        return time_price.get(time_price.lastKey());

    }

    public int maximum() {
        return price_count.lastKey();

    }

    public int minimum() {
        return price_count.firstKey();
    }

    public static void main(String args[]) {
        _2034_StockPrice stock = new _2034_StockPrice();
        stock.update(1, 10);
        stock.update(2, 5);
        System.out.println(stock.maximum());
        stock.update(1, 3);
        System.out.println(stock.maximum());

    }
}
