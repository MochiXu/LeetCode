package Array_list;

import java.util.LinkedHashMap;

public class LRUCache2 {

    LinkedHashMap<Integer,Integer> linkedHashMap=null;
    int capacity=0;
    public LRUCache2(int capacity) {
        this.capacity=capacity;
        linkedHashMap=new LinkedHashMap<>();
    }

    public int get(int key) {
        if (linkedHashMap.containsKey(key)) {
            //此时get到了这个key，那就把这个key放到最后面进行位置更新
            int value=linkedHashMap.get(key);
            linkedHashMap.remove(key,value);
            linkedHashMap.put(key,value);
            return value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if (this.get(key)!=-1){
            linkedHashMap.put(key,value);
        }else {
            if (linkedHashMap.size()==capacity){
                linkedHashMap.remove(linkedHashMap.entrySet().iterator().next().getKey());
            }
            linkedHashMap.put(key,value);
        }
    }
}
