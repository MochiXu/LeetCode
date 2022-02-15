package Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * 给定一个包含 n 个整数的数组nums，判断nums中是否存在三个元素a ，b ，c ，使得a + b + c = 0 ？请找出所有和为 0 且不重复的三元组。
 *
 * 思路：使用DFS，主要是只有三层，感觉时间复杂度应该还行，试试看先
 *  运行超时
 * */
public class _07_threeSum {
    private List<List<Integer>> lists=new ArrayList<>();
    private List<Integer> list=new ArrayList<>();
    int deep=0;
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length<3)return lists;
        for (int i=0;i<nums.length;i++){
            deep=0;
            list.clear();
            dfs(nums,i,-1);
        }
        return lists;
    }
    public void dfs(int[]nums,int i,int pre){
        if (deep>3)return;
       deep++;
       list.add(nums[i]);
       if(deep==3){
           if (list.get(0)+list.get(1)+list.get(2)==0){
               List<Integer> preList=new ArrayList<>(list);
               Collections.sort(list);
               if (!lists.contains(list))lists.add(list);
               list=preList;
           }
           return;
       }
       for (int j=0;j<nums.length;j++){
           if (j!=i&&j!=pre){
               dfs(nums,j,i);
               deep--;
               list.remove(list.size()-1);
           }
       }
    }

    public static void main(String args[]){
        _07_threeSum threeSum=new _07_threeSum();
        int[] arr={9,-4,-5,8,-5,7,5,-6,-4,-13,9,-10,-13,-6,2,-15,-13,-9,-4,-13,-9,-9,13,-13,-9,9,-15,1,0,-14,-8,-13,-11,-5,2,0,9,14,9,-9,8,-5,-12,10,-3,5,3,-1,12,14,1,10,12,-1,13,-12,-14,13,4,-7,6,4,-5,11,6,4,-12,0,3,4,-2,-3,7,1,14,-11,-8,2,-5,11,-7,3,6,-9,9,4,-14,10,-6,-2,-11,-14,-13,-9,4,0,11,-1,-15,-9,-12,-1,3,10,7,-5,6,6,12,8,2,-9,-4,-6,-11,-9,5,-10,-14,-15,3};
        System.out.println(threeSum.threeSum(arr));
    }
}
