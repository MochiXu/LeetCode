package BinarySearchTree;
/**
 * 将有序数组转为BST
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/convert-sorted-array-to-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * */
public class _108_sortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length==0) return null;
        return sortSubBST(nums,0,nums.length-1);
    }
    public TreeNode sortSubBST(int[] nums,int begin,int end){
        //最小子问题（递归）
        if(begin>end) return null;
        if(begin==end) return new TreeNode(nums[begin]);
        //创建当前二分根节点
        TreeNode root=new TreeNode(nums[(begin+end)/2]);
        //使用递归赋值左右子树
        root.left=sortSubBST(nums,begin,(begin+end)/2-1);
        root.right=sortSubBST(nums,(begin+end)/2+1,end);
        return root;
    }
}
