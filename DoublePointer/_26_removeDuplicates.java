package DoublePointer;
/**
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。
 *
 * 由于在某些语言中不能改变数组的长度，所以必须将结果放在数组nums的第一部分。更规范地说，如果在删除重复项之后有 k 个元素，那么 nums 的前 k 个元素应该保存最终结果。
 *
 * 将最终结果插入 nums 的前 k 个位置后返回 k 。
 *
 * 不要使用额外的空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * 思路：使用双指针的写法应该比较靠谱
 * ♥️这题目还是思考了挺长时间的hhh，不过只要明白slow和fast往右移动的过程就行，感觉这比官方的好理解一些，更巧妙
 * */
public class _26_removeDuplicates {



    public int removeDuplicates(int[] nums) {
        if (nums.length<2)return nums.length;
        int fast=1;
        int slow=0;
        while (fast<nums.length){
            if (nums[slow]==nums[fast]){
                fast++;
            }else {
                nums[slow+1]=nums[fast];
                slow++;
                fast++;
            }
        }
        return slow+1;
    }
    public static void main(String args[]){
        _26_removeDuplicates re=new _26_removeDuplicates();
        int[] nums={0,0,1,1,1,2,2,3,3,4};
        System.out.println(re.removeDuplicates(nums));
    }
}
