package BinarySearchTree;

/**
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称
 */
public class _101_isSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return check(root,root);
    }
    //不要陷入具体的递归细节，把握递归出口以及递归函数
    public boolean check(TreeNode rool, TreeNode roor) {
        if (rool == null || roor == null) {
            return rool == null && roor == null;
        }
        //递归出口+递归函数,此处递归出口与100题类似
        return check(rool.left, roor.right) && check(rool.right, roor.left) && rool.val == roor.val;
    }
}
