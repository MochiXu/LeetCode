package onLine.Shopee;

//最大乘积子数组
public class Solution1 {
    public long GetSubArrayMaxProduct(long[] nums) {
        long maxNum=Long.MIN_VALUE;
        long imax=1;//记录最大值
        long imin=1;//记录最小值
        //遍历
        for (int i=0;i<nums.length;i++){
            //小于0的时候，最小值会变成最大值，最大值会变成最小值，所以这里进行交换
            if (nums[i]<0){
                long temp=imax;
                imax=imin;
                imin=temp;
            }
            //状态转移
            imax=Math.max(imax*nums[i],nums[i]);
            imin=Math.min(imin*nums[i],nums[i]);
            maxNum=Math.max(maxNum,imax);
        }
        return maxNum;
    }
}
