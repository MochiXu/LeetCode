package String;

import java.util.LinkedList;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 思路：不知道DP可不可以
 * */
public class _3_lengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int maxNum=-1;
        int curNum=0;
        if (s.length()==0)
            return 0;
        LinkedList<Character> stack=new LinkedList<>();

        char [] chars=s.toCharArray();
        for (int i=0;i<chars.length;i++){
            //从i开始往后访问
            for (int j=i;j<chars.length;j++){
                if (!stack.contains(chars[j])){
                    stack.addLast(chars[j]);
                    curNum++;
                    maxNum= Math.max(curNum, maxNum);
                }else {
                    stack.clear();
                    curNum=0;
                    break;
                }
            }
        }

        return maxNum;

    }
}
