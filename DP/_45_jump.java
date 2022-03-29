package DP;

public class _45_jump {
    public int jump(int[] nums) {
        //初始化跳跃起点
        int left=0;
        int right=1;
        int count=0;
        while (right< nums.length){
            int maxRight=0;
            for (int i=left;i<right;i++){
                maxRight=Math.max(maxRight,nums[i]+i);
            }
            left=right;
            right=maxRight+1;
            count++;
        }
        return count;
    }
}
