package Offer;

import BinarySearchTree.TreeNode;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 * */
public class _26_isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A==null||B==null)return false;
        if (A.val==B.val){
            return compare(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }else {
            return isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }
    }

    public boolean compare(TreeNode A,TreeNode B){
        if (B==null)return true;
        if (A==null||A.val!=B.val)return false;
        return compare(A.left,B.left)&&compare(A.right,B.right);
    }
}
