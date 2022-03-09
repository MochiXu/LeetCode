package Array_list;

import java.util.Arrays;
import java.util.HashSet;

public class _1_twoSum {
    public int[] twoSum(int[] nums, int target) {
//        Arrays.sort(nums);
        HashSet<Integer> hashSet=new HashSet<>();
        int[] re=new int[2];
        for (int i=0;i< nums.length;i++){
            for (int j=0;j<nums.length&&j!=i;j++){
                if (nums[i]+nums[j]==target&&!hashSet.contains(nums[i])&&!hashSet.contains(nums[j])){
                    hashSet.add(nums[i]);
                    hashSet.add(nums[j]);
                    re[0]= nums[i];
                    re[1]= nums[j];
                }
            }
        }
        return re;
    }
    public static void main(String args[]){
        _1_twoSum to=new _1_twoSum();
        int[]a={3,2,4};
        System.out.println(to.twoSum(a,6));
    }
}
