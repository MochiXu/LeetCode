package Offer;
/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 * */
public class _53_missingNumber {
    public int missingNumber(int[] nums) {
        //边界处理
        if (nums.length==1){
            if (nums[0]==1)return 0;
            else return nums[0]+1;
        }
        if (nums[nums.length-1]==nums.length-1)
            return nums[nums.length-1]+1;

        //正式二分
        int left=0;
        int right=nums.length-1;
        while (left<=right){
            int index=(left+right)/2;
            if (nums[index]==index){
                left=index+1;
            }else if (nums[index]>index){
                right=index-1;
            }
        }
        if (left==0)
            return nums[0]-1;
        if (left==nums.length)
            return nums[nums.length-1]-1;
        return nums[left]-1;


    }

    public static void main(String args[]){
        _53_missingNumber missingNumber=new _53_missingNumber();
        int[] arr={0,2};
//        int[] arr={0,1,2,3,4,5,6,7,9,10,11};
        System.out.println(missingNumber.missingNumber(arr));
    }
}
