package Offer;

import java.util.HashMap;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * */
public class _50_firstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character,Integer> hashMap=new HashMap<>();
        char[] chars=s.toCharArray();
        for (char c : chars){
            if (hashMap.containsKey(c))
                hashMap.put(c,hashMap.get(c)+1);
            else hashMap.put(c,1);
        }

        for (char c : chars){
            if (hashMap.get(c)==1)
                return c;
        }
        return ' ';
    }
}
