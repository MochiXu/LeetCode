package Array_list;
/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 *
 * [0,1,0,3,4,0,0,9,7]
 * */
public class _283_moveZero {
    public void moveZeroes(int[] nums) {
        //感觉用一次遍历就行了，O(n)的复杂度
        int notZero=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[notZero++]=nums[i];
            }
        }
        for (;notZero< nums.length;notZero++){
            nums[notZero]=0;
        }
    }

    public static void main(String args[]){
        _283_moveZero moveZero=new _283_moveZero();
        int[] arr={0,0,1};
        moveZero.moveZeroes(arr);
    }
}
