package Offer;
/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * 二分
 * */
public class _53_search {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int index=-1,flag=-1;
        while (left<=right){
            index=(left+right)/2;
            if (nums[index]==target){
                flag=0;
                break;
            }else if (nums[index]<target){
                left=index+1;
            }else {
                right=index-1;
            }
        }
        int result=0;
        if (index!=-1&&flag==0){
            for (int i=index+1;i<nums.length;i++){
                if (nums[i]==target) result++;
            }
            for (int i=index-1;i>=0;i--){
                if (nums[i]==target) result++;
            }
            return result+1;
        }
        return 0;
    }
}
