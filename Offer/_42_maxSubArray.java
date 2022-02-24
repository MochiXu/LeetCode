package Offer;

import java.util.Arrays;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * 思路：这题肯定要用DP，需要确定的是状态转移方程
 * 🏁题目说的是连续的子数组，所以如何去定义dp[n]是个比较重要的问题
 * 刚开始自己的思路是定义dp[n]为数组中0～n部分的子数组和的最大值，这是一种传统的定义方法，但是这种定义方法会出现一种问题：就是状态转移方程
 * 无法实现，想想看去求解dp[n+1]的时候，如果n是负数怎么办，如果n是正数又怎么办，如何保证n+1的和前一个加在一起的值是预期的子数组，很难实现。
 * <p>
 * 所以参考了题解：将dp[n]定义为以数组n为结尾的连续数组的最大值，这样子把传统解决问题的从左往右的思路更改成从右往左，去计算的时候好计算些。
 * <p>
 * 状态转移方程:
 * 1.nums[n-1]<0时：dp[n]=nums[n];
 * 2.nums[n-1]>=0时：dp[n]=dp[n-1]+nums[n];
 */
public class _42_maxSubArray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums.length == 1) return nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i - 1] < 0 ? nums[i] : nums[i] + dp[i - 1];
        }
        Arrays.sort(dp);
        return dp[nums.length - 1];
    }

    public static void main(String args[]) {
        _42_maxSubArray maxSubArray = new _42_maxSubArray();
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray.maxSubArray(a));
    }
}
