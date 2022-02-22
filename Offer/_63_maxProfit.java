package Offer;
/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * 思路：不会，还是得看题解，核心是获得dp的式子
 *
 * dp[n]=max(dp[n-1],prices[n]-min)
 * */
public class _63_maxProfit {
    public int maxProfit(int[] prices) {
        if (prices.length==0)return 0;
        int minValue=Integer.MAX_VALUE;
        int []min=new int[prices.length];
        for (int i=0;i<prices.length;i++){
            min[i]=Integer.MAX_VALUE;
        }
        int []dp=new int[prices.length];
        minValue=prices[0];
        //初始化
        min[0]=minValue;
        dp[0]=-1;
        //动态规划
        for (int i=1;i<prices.length;i++){
            //记录历史最低买入价格
            minValue= Math.min(minValue, prices[i]);
            min[i]=minValue;
            //dp状态转移
            dp[i]=Math.max(dp[i-1],prices[i]-min[i-1]);
        }
        if (dp[prices.length-1]>0)return dp[prices.length-1];
        else return 0;
    }
}
