package OtherPractice;

import java.util.*;

public class HashIterator {
    public void test(HashMap<Integer,Integer> hashMap){
        //使用Iterator遍历
        Iterator<Map.Entry<Integer,Integer>> iterator=hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry=iterator.next();
            System.out.println("key"+entry.getKey()+" value"+entry.getValue());
        }
//        hashMap.entrySet().stream().sorted((right,left)->{
//           return left.getValue()- right.getValue();
//        });
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(hashMap.entrySet());
        Collections.sort(list,(right,left)->{
            return left.getValue()- right.getValue();
        });

        for (Map.Entry<Integer,Integer> entry:list){
            System.out.println("key"+entry.getKey()+" value"+entry.getValue());
        }
        for (Map.Entry<Integer,Integer> entry : hashMap.entrySet()){
            System.out.println("key"+entry.getKey()+" value"+entry.getValue());
        }
    }

    public void sortHashmap(HashMap<Integer,Integer> hashMap){
        //明确一点，那就是HashMap中不会改变key的位置，因为这是放入具体的内存块的，所以只能复制一份数据进行排序
        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(hashMap.entrySet());
        Collections.sort(list,(entryRight,entryLeft)->{
            return entryLeft.getValue()-entryRight.getValue();
        });
        for (Map.Entry<Integer,Integer> entry:list){
            System.out.println("key"+entry.getKey()+" value"+entry.getValue());
        }
    }

    public void IteratorHashMap(HashMap<Integer,Integer> hashMap){
        Iterator<Map.Entry<Integer,Integer>> iterator=hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,Integer> entry=iterator.next();
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
        List<Map.Entry<Integer,Integer>> entryList=new ArrayList<>(hashMap.entrySet());
        for (Map.Entry<Integer,Integer> entry:entryList){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
    }

    public static void main(String args[]){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(1,3);
        hashMap.put(5,7);
        hashMap.put(6,4);
        hashMap.put(2,-1);
        HashIterator hashIterator=new HashIterator();
        hashIterator.sortHashmap(hashMap);
        hashIterator.IteratorHashMap(hashMap);
    }
}
