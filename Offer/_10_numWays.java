package Offer;
/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 思路：画图可知，青蛙跳台阶相当于斐波那契的遍体
 * */
public class _10_numWays {
    public int numWays(int n) {
        int [] result=new int[n+1];
        if (n==0)return 1;
        if (n==1)return 1;
        result[0]=1;
        result[1]=1;
        result[2]=2;
        for (int i=3;i<=n;i++){
            result[i]=(int) (result[i-1]+result[i-2])%1000000007;
        }
        return result[n];
    }
}
