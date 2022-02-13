package String;

import java.util.HashMap;
import java.util.LinkedList;
//使用滑动窗口试试
public class _3_lengthOfLongestSubstring2 {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxSize=-1;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        if (s.length()==0)
            return 0;

        for (int i=0;i<s.length();i++){
            if (!hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i),i);
                maxSize=Math.max(maxSize,i-left+1);
            }else {
                left=Math.max(left,hashMap.get(s.charAt(i))+1);
                hashMap.clear();
                i=left-1;
            }
        }
        return maxSize;

    }

    public static void main(String args[]){
        _3_lengthOfLongestSubstring2 lengthOfLongestSubstring2=new _3_lengthOfLongestSubstring2();
        System.out.println(lengthOfLongestSubstring2.lengthOfLongestSubstring("tmmzuxt"));
    }

}
