package Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
//首先确定一个数，再利用双指针确定另外两个数
public class _07_threeSum2 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums==null||nums.length<3)return Collections.EMPTY_LIST;
        List<List<Integer>> lists=new ArrayList<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length;i++){
            //如果当前数字>0那么再往后也找不到能够凑成0的两个数字，因为已经排好序
            if(nums[i]>0) break;
            //如果预先确定的数字和上次的相同，那么相当于重复步骤，无意义
            if(i>0&&nums[i]==nums[i-1]) continue;
            //预先确定好一个数字
            int target=-nums[i];
            //寻找后面相加可以等于target的数字
            int left=i+1;
            int right=nums.length-1;
            while (left<right){
                if (nums[left]+nums[right]>target) right--;
                else if (nums[left]+nums[right]<target) left++;
                else if (nums[left]+nums[right]==target){
                    //记录结果

                    List<Integer> list=new ArrayList<>();
                    list.add(-target);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    if (!lists.contains(list)) lists.add(list);
                    // 去重
                    while (left < right && nums[left] == nums[++left]);
                    while (left < right && nums[right] == nums[--right]);

                }
            }
        }
        return lists;
    }

    public static void main(String args[]){
        _07_threeSum2 threeSum=new _07_threeSum2();
//        int[] arr={9,-4,-5,8,-5,7,5,-6,-4,-13,9,-10,-13,-6,2,-15,-13,-9,-4,-13,-9,-9,13,-13,-9,9,-15,1,0,-14,-8,-13,-11,-5,2,0,9,14,9,-9,8,-5,-12,10,-3,5,3,-1,12,14,1,10,12,-1,13,-12,-14,13,4,-7,6,4,-5,11,6,4,-12,0,3,4,-2,-3,7,1,14,-11,-8,2,-5,11,-7,3,6,-9,9,4,-14,10,-6,-2,-11,-14,-13,-9,4,0,11,-1,-15,-9,-12,-1,3,10,7,-5,6,6,12,8,2,-9,-4,-6,-11,-9,5,-10,-14,-15,3};
        int[] arr={-1,0,1,2,-1,-4};
        System.out.println(threeSum.threeSum(arr));
    }
}
