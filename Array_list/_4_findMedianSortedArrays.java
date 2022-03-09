package Array_list;
/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 *
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 *
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 *
 * */
public class _4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //归并排序的时间复杂度就是O(log (m+n))
        int [] num=new int[nums1.length+nums2.length];
        int i=0,j=0,k=0;
        for (;i<nums1.length&&j<nums2.length;){
            if (nums1[i]<=nums2[j]){
                num[k++]=nums1[i++];
            }else {
                num[k++]=nums2[j++];
            }
        }
        while (i<nums1.length){
            num[k++]=nums1[i++];
        }
        while (j<nums2.length){
            num[k++]=nums2[j++];
        }
        if (num.length%2==0){
            return (num[num.length/2]+num[num.length/2-1])/2.0;
        }else {
            return num[num.length/2];
        }
    }

    public static void main(String args[]){
        _4_findMedianSortedArrays fd=new _4_findMedianSortedArrays();
        int []a={1,3};
        int []b={2};
        System.out.println(fd.findMedianSortedArrays(a,b));
    }
}
