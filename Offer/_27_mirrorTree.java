package Offer;

import BinarySearchTree.TreeNode;
/*
* 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
*
* 思路：老思路多少有点问题而且不简洁
* */
public class _27_mirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
//        if (root==null)return null;
//        if (root.left==null&&root.right==null)return root;
//        TreeNode temp=root.left;
//        root.left=root.right;
//        root.right=temp;
//        mirrorTree(root.left);
//        mirrorTree(root.right);
//        return root;
        if (root==null)return null;
        TreeNode node=root.left;
        root.left=mirrorTree(root.right);
        root.right=mirrorTree(node);
        return root;
    }
}
