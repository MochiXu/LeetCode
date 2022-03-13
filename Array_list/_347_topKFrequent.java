package Array_list;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 *
 * */
public class _347_topKFrequent {
    public int[] topKFrequent(int[] nums, int k) {
        //首先确定所有元素的出现次数
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i< nums.length;i++){
            if (hashMap.containsKey(nums[i])){
                hashMap.put(nums[i],hashMap.get(nums[i])+1);
            }else {
                hashMap.put(nums[i],1);
            }
        }
        //进行堆排序(TopN问题就使用最小堆)
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>((right,left)->{
            return hashMap.get(right)-hashMap.get(left);
        });
        //使用最小堆依次处理所有的元素
        for (int key: hashMap.keySet()){
            if (priorityQueue.size()<k){
                priorityQueue.add(key);
            }else if (priorityQueue.size()==k){
                if (hashMap.get(key)>hashMap.get(priorityQueue.peek())){
                    priorityQueue.remove();
                    priorityQueue.add(key);
                }
            }
        }
        //依次返回堆中的元素
        int[]res=new int[priorityQueue.size()];
        for (int i= res.length-1;i>=0;i--){
            res[i]=priorityQueue.remove();
        }
        return res;
    }
}
