package BinarySearchTree;
/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * */
public class _111_minDepth {
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        if (root.left==null&&root.right==null)return 1;

        //为了判定是否为单支二叉树这种特殊情况，增加一些条件判断
        if(root.left!=null&&root.right!=null)
            return Math.min(minDepth(root.right),minDepth(root.left))+1;
        //此处必有一个子节点是null
        /**此语句实质为深度搜索:见官方题解
         * */
        return root.left==null?minDepth(root.right)+1:minDepth(root.left)+1;
    }
}
