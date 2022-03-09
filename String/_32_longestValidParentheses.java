package String;

import java.util.LinkedList;

/**
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * <p>
 * <p>
 * 思路：先把所有能匹配的括号进行标记，然后遍历一次寻找能够找到的最大连续值
 */
public class _32_longestValidParentheses {
    public int longestValidParentheses(String s) {
        char[] arr = s.toCharArray();
        if (arr.length == 0) return 0;
        LinkedList<Character> stack = new LinkedList<>();
        int[] mark = new int[arr.length];
        stack.add('N');
        for (int i = 0; i < arr.length; i++) {
            if (stack.getLast() == '(' && arr[i] == ')') {
                stack.pollLast();
                //更新mark数组
                mark[i] = 1;//更新右侧括号
                for (int j = i - 1; j >= 0; j--) {
                    if (mark[j] == 0) {//更新左侧括号
                        mark[j] = 1;
                        break;
                    }
                }
            }else {
                stack.addLast(arr[i]);
            }
        }
        //遍历mark数组寻找最大连续1的数量
        int maxCount=0;
        int curCount=0;
        for(int i=0;i<mark.length;i++){
            if (mark[i]==1){
                curCount++;
            }else {
                maxCount=Math.max(curCount,maxCount);
                curCount=0;
            }
        }
        return Math.max(maxCount,curCount);
    }

    public static void main(String args[]){
        _32_longestValidParentheses lg=new _32_longestValidParentheses();
        System.out.println(lg.longestValidParentheses("(()"));
    }
}
