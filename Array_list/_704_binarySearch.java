package Array_list;

public class _704_binarySearch {
    public int search(int[] nums, int target) {
        if (nums.length==0)return -1;
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int mid=(left+right)/2;
            if (nums[mid]<target) left=mid+1;
            if (nums[mid]>target) right=mid-1;
            if (nums[mid]==target)return mid;
        }
        return nums[left]==target?left:-1;
    }
}
