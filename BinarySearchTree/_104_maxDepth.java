package BinarySearchTree;

/**给定一个二叉树，找出其最大深度。
 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 说明: 叶子节点是指没有子节点的节点。
 * */
public class _104_maxDepth {
    //无须陷入具体的递归细节
    public int maxDepth(TreeNode root) {
        //递归出口
        if(root==null)return 0;
        if (root.left==null&&root.right==null)return 1;
        //递归入口
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
