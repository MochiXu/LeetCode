package OtherPractice.ByteDance;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
 * <p>
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 输入：nums1 = [1,3], nums2 = [2]
 * 输出：2.00000
 * 解释：合并数组 = [1,2,3] ，中位数 2
 */
public class _4_findMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //边界判断
        if (m == 0 || n == 0) {
            if (n != 0) return n % 2 == 0 ? (nums2[n / 2 - 1] + nums2[n / 2]) / 2.0 : nums2[n / 2];
            if (m != 0) return m % 2 == 0 ? (nums1[m / 2 - 1] + nums1[m / 2]) / 2.0 : nums1[m / 2];
            return 0;
        }
        //逻辑处理
        if ((m + n) % 2 == 0) {
            int n1 = this.getMinK(nums1, nums2, 0, 0, (m + n) / 2);
            int n2 = this.getMinK(nums1, nums2, 0, 0, (m + n) / 2 + 1);
            return (n1 + n2) / 2.0;
        } else {
            return this.getMinK(nums1, nums2, 0, 0, (m + n) / 2 + 1);
        }
    }

    public int getMinK(int[] nums1, int[] nums2, int left1, int left2, int k) {
        //逻辑处理
        int len1=nums1.length;
        int len2=nums2.length;
        while (k != 1) {
            if (len1 - left1 <= k / 2 && nums1[len1-1] <= nums2[k / 2 + left2-1]) {
                //num1的剩余长度小于k/2且nums1中的末尾元素要被舍弃
                k -= (len1 - left1);
                return nums2[k-1+left2];
            }
            else if (len1 - left1 + 1 <= k / 2 && nums1[len1-1] > nums2[k / 2 + left2-1]) {
                //num1的剩余长度小于k/2且nums1中的末尾元素不会被舍弃
                left2 += k / 2;
                k -= k/2;
            }
            else if (len2 - left2 <= k / 2 && nums2[len2-1] <= nums1[k / 2 + left1-1]) {
                //num2的剩余长度小于k/2且nums2中的末尾元素要被舍弃
                k -= (len2 - left2);
                return nums1[k-1+left1];
            }
            else if (len2 - left2 <= k / 2 && nums2[len2-1] > nums1[k / 2 + left1-1]) {
                //num2的剩余长度小于k/2且nums2中的末尾元素不会被舍弃
                left1 += k / 2;
                k -= k/2;
            }
            else if (nums1[k / 2 - 1 + left1] < nums2[k / 2 + left2-1]) {
                //去掉nums1中前k/2个数字
                left1 += k / 2;
                k -= k / 2;
            } else {
                //去掉nums2中前k/2个数字
                left2 += k / 2;
                k -= k / 2;
            }
        }
        //判断是不是nums1越界
        if (left1>= nums1.length){
            return nums2[k-1+left2];
        }
        //判断是不是nums2越界
        if (left2>= nums2.length){
            return nums1[k-1+left1];
        }
        //都没有越界--（实际上面两个数组越界判断是多余的，因为上面针对了这种情况直接return了）
        return Math.min(nums1[left1],nums2[left2]);
    }

    public static void main(String args[]) {
        _4_findMedianSortedArrays findMedianSortedArrays = new _4_findMedianSortedArrays();
        int[] nums1 = {1, 3,4,5,6,7,8};
        int[] nums2 = {2};
        System.out.println(findMedianSortedArrays.getMinK(nums1, nums2, 0, 0, 2));
//        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1,nums2));
    }
}
