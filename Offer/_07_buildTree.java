package Offer;

import DFS.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 * 思路：准备根据先序遍历和中序遍历的特点进行递归操作
 */
public class _07_buildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //边界判断--如果数据合法就不需要判断
        if (preorder.length != inorder.length) {
            return null;
        }
        //假设数据合法
        if (preorder.length==0||inorder.length==0)
            return null;
        if (preorder.length == 1 && inorder.length == 1 && preorder[0] == inorder[0]) {
            return new TreeNode(inorder[0]);
        }
        //寻找根节点
        int rootNum = preorder[0];
        int index = 0;
        for (; index < inorder.length; index++) {
            if (inorder[index] == rootNum) break;
        }
        //确定剩下的元素
        int[] nextPreL = new int[index];
        int[] nextPreR = new int[preorder.length - index - 1];
        int[] nextInL = new int[index];
        int[] nextInR = new int[inorder.length - index - 1];
        for (int i = 1, j = 0; i < index + 1; i++, j++) {
            nextPreL[j] = preorder[i];
        }
        for (int i = index + 1, j = 0; i < preorder.length; i++, j++) {
            nextPreR[j] = preorder[i];
        }
        for (int i = 0; i < index; i++) {
            nextInL[i] = inorder[i];
        }
        for (int i = index + 1,j=0; i < inorder.length; i++,j++) {
            nextInR[j] = inorder[i];
        }
        TreeNode root=new TreeNode(preorder[0]);
        root.left=buildTree(nextPreL,nextInL);
        root.right=buildTree(nextPreR,nextInR);
        return root;
    }
}
