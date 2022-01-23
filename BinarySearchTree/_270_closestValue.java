package BinarySearchTree;
/**
 * 给定一个不为空的二叉搜索树和一个目标值 target，请在该二叉搜索树中找到最接近目标值 target 的数值。
 *
 * 注意：
 *
 * 给定的目标值 target 是一个浮点数
 * 题目保证在该二叉搜索树中只会存在一个最接近目标值的数
 *
 * 思路：需要工具函数：找到BST某节点的下一个中序节点，和上一个中序节点
 * BST的下一个中序节点为右子树的左下方节点
 * BST的上一个中序节点是左子树的右下方节点
 *
 * 我的思路是比较[root中序左侧节点，root，root中序右侧节点] 他们三者与target差值绝对值的大小。
 * 分别记为 [L,M,R]
 * 那么M最小时，直接输出root
 * L最小时，将root改为左子树根节点
 * R最小时，将root改为右子树根节点
 *
 * 实际写代码的时候应当注意左右子树是否为空的判断，然后在构思的时候还是陷入了递归的具体细节，导致了时间浪费
 * 如何避免不陷入递归细节？
 * 那就只需要考虑最基本的三种树型，仅有一个根节点、有一个根节点和左孩子、有一个根节点和左右孩子
 * */
public class _270_closestValue {
    public int closestValue(TreeNode root, double target) {
        //root为叶结点时
        if(root.left==null&&root.right==null) return root.val;
        if(root.left==null){
            if(Math.abs(root.val-target)>Math.abs(getRight(root).val-target)) return closestValue(root.right,target);
            else return root.val;
        }
        if (root.right==null){
            if(Math.abs(root.val-target)>Math.abs(getLeft(root).val-target)) return closestValue(root.left,target);
            else return root.val;
        }
        if(Math.abs(root.val-target)<Math.min(Math.abs(getLeft(root).val-target),Math.abs(getRight(root).val-target)))
            return root.val;
        else if(Math.abs(getLeft(root).val-target)<Math.abs(getRight(root).val-target)) return closestValue(root.left,target);
        else return closestValue(root.right,target);

    }
    //寻找左子树的最右下节点
    public TreeNode getLeft(TreeNode root){
        TreeNode node_left=root.left;
        while (node_left.right!=null){
            node_left=node_left.right;
        }
        return node_left;
    }
    //寻找右子树的最左下节点
    public TreeNode getRight(TreeNode root){
        TreeNode node_right=root.right;
        while(node_right.left!=null){
            node_right=node_right.left;
        }
        return node_right;
    }
}
