package BinarySearchTree;


/**给定一个二叉树，判断它是否是高度平衡的二叉树。
 本题中，一棵高度平衡二叉树定义为：
 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * */
//初次思路：调用maxDeep函数
public class _110_isBalanced {
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        if (Math.abs(maxDeep(root.left)-maxDeep(root.right))>1) return false;
        /**这种情况上行代码不能返回true，这样以来就弱化了跳出的条件，要具备框架思维
         ******** 下面会进行子节点递归调用，所以设置成false提前跳出符合正确逻辑 ♥♥ *******
         * */
        return isBalanced(root.left)&&isBalanced(root.right);
    }
    public int maxDeep(TreeNode root){
        if(root==null)return 0;
        if(root.left==null&&root.right==null)return 1;
        return Math.max(maxDeep(root.left),maxDeep(root.right))+1;
    }

}
