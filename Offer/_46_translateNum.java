package Offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * 思路：使用动态规划
 * 这里的动态规划思路应该就是传统的动态规划，从左往右计算应该就行
 * 涉及到状态转移方程的时候应该分情况去考虑
 */
public class _46_translateNum {
    public int translateNum(int num) {
        char[] chars = (num + "").toCharArray();
        if (chars.length == 1) return 1;
        int[] dp = new int[chars.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= chars.length; i++) {
            if (chars[i - 2] == '0' ||chars[i - 2] > '2'|| (chars[i - 2] == '2' && chars[i - 1] > '5')) {
                dp[i] = dp[i - 1];
            } else {

//                dp[i] = i == 2 ? dp[i - 1] + 1 : dp[i - 2] + dp[i - 1];//这里是为了处理dp[0]=0的状态
                dp[i] =  dp[i - 2] + dp[i - 1];//dp[0]取1的时候，可以不用多进行判断
            }
        }
        return dp[chars.length];
    }
}
