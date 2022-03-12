package OtherPractice.ByteDance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
/**
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * <br/>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
 *
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 *
 * <br/>
 * 1 <= candidates.length <= 30
 * <br/>
 * 1 <= candidates[i] <= 200
 * <br/>
 * candidate 中的每个元素都 互不相同
 * <br/>
 * 1 <= target <= 500
 *
 * */
public class _39_combinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //初始化数组
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer>innerList=new ArrayList<>();


            dfs(candidates, target, innerList, lists);
        return lists;
    }
    public void dfs(int[]nums,int target,List<Integer> innerList,List<List<Integer>> lists){
        if (target==0){
            //这里进行去重，但是没有做到dfs搜索的过程中去重
            ArrayList<Integer> copyOfInnerList=new ArrayList<>(innerList);
            Collections.sort(copyOfInnerList);
            if (!lists.contains(copyOfInnerList))
                lists.add(copyOfInnerList);
            return;
        }
        //边界处理，相当于剪枝[因为已经排序过了]
        if (target<0||nums[0]>target)return;
        for (int i=0;i<nums.length;i++){
            innerList.add(nums[i]);
            //dfs
            dfs(nums,target-nums[i],innerList,lists);
            innerList.remove(innerList.size()-1);
        }
    }

    public static void main(String args[]){
        _39_combinationSum combinationSum=new _39_combinationSum();
        int[]a={2,3,5};
        System.out.println(combinationSum.combinationSum(a,8));
    }
}
