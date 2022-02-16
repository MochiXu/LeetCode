package Offer;

import java.util.Arrays;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 思路：这种解题方法肯定不是最优的那个，主要是遇到简单题一定要和面试官沟通
 * 时间优先的情况下感觉可以用hash
 * 空间为1的时候要用二分法（不会）
 * */
public class _03_findRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i=1;i<nums.length;i++){
            if (nums[i]==nums[i-1])
                return nums[i];
        }
        return -1;
    }
}
