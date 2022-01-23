package BinarySearchTree;

public class _404_sumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root==null)return 0;
        if (root.left==null&&root.right==null)return 0;
        return sumofLeaves(root.left,1)+sumofLeaves(root.right,2);
    }
    public int sumofLeaves(TreeNode root,int direction){
        if(root==null)return 0;
        if(root.left==null&&root.right==null){
            return direction==1? root.val : 0;
        }
        return sumofLeaves(root.left,1)+sumofLeaves(root.right,2);
    }
}
