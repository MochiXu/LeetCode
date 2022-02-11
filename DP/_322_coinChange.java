package DP;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 *
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 *
 * 你可以认为每种硬币的数量是无限的。
 * 思路：使用动态规划，穷举+状态转移+base状态
 * */
public class _322_coinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
//        if (amount<0) return -1;
        int[]dp=new int[amount+1];
        for (int i=0;i<amount+1;i++){
            dp[i]=amount+1;
        }
        //base状态
        dp[0]=0;
        //穷举，自底向上
        for (int i=0;i<amount+1;i++){
            for (int j=0;j<coins.length;j++) {
                //需要跳过子问题无解的情况
                if (i-coins[j]<0) continue;
                dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);//这里并不是用了递归，这里是穷举
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];

    }
}
