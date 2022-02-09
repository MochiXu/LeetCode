package DFS;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回-1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class _322_coinChange {
    int[] coinArr;
    int length = 0;

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        coinArr = coins;
        length = coinArr.length;

        //一定要确定memo中存储的是最优解才行
        //将memo内元素初始化为-1
        memo=new int[amount+1];
//        for (int i=0;i<amount+1;i++)
//            memo[i]=-1;

         return dfs(amount);

    }

    public int dfs(int amount) {

        if (amount == 0) {
            //DFS完成，
            return 0;
        }
        //待匹配金额小于最小零钱、或为负值
        if (amount < coinArr[0] || amount < 0)
            return -1;

        //此处设置为不等于0，其实在等于-1的时候也是可以直接返回的，因为没有解嘛
        if (memo[amount]!=0)
            return memo[amount];//返回的话一定是返回最佳的

        //进行DFS
        int res=Integer.MAX_VALUE;
        for (int i = length - 1; i >= 0; i--) {
            int count=dfs(amount - coinArr[i]);
            //此处能够保证备忘录中记录的是最佳的数目
            if (count!=-1){
                res=Math.min(count+1,res);
            }
        }
        if (res!=Integer.MAX_VALUE)memo[amount]=res;
        else memo[amount]=-1;
        return memo[amount];
    }

    public static void main(String args[]) {
        _322_coinChange coinChange = new _322_coinChange();
        int[] coins = {186, 419, 83, 408};
//        int[] coins = {1, 2, 5};
        System.out.println(coinChange.coinChange(coins, 4154));
    }
}
