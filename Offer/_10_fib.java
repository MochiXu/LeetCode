package Offer;
/**
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0, F(1)= 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 思路：使用动态规划
 * */
public class _10_fib {
    public int fib(int n) {
        if (n==0)return 0;
        if (n==1)return 1;
        int []result=new int[n+1];

        result[0]=0;
        result[1]=1;
        for (int i=2;i<=n;i++){
            result[i]= (int) ((result[i-1]+result[i-2])%1000000007);
        }
        return result[n];
    }
    public static void main(String args[]){
        _10_fib fib=new _10_fib();
        System.out.println(fib.fib(45));
    }
}
