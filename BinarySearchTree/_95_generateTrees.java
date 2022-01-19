package BinarySearchTree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
 * 可以按 任意顺序 返回答案。
 * https://leetcode-cn.com/problems/unique-binary-search-trees-ii/
 * */
public class _95_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        return generateTree(1,n);
    }
    public List<TreeNode> generateTree(int begin, int end){
        //存储结果: ans保存了begin至end的所有可能的BST根节点
        List<TreeNode> ans = new ArrayList<TreeNode>();

        //递归出口
        if (begin>end) {ans.add(null); return ans;}
        if (begin==end) {ans.add(new TreeNode(begin));return ans;}

        //递归入口
        for (int node_i=begin;node_i<=end;node_i++){
            //获取所有可能形状的左子树根（BST中root左侧的节点值全部小于root）
            List<TreeNode> ans_left=generateTree(begin,node_i-1);
            //获取所有可能形状的右子树根（BST中root右侧的节点值全部大于root）
            List<TreeNode> ans_right=generateTree(node_i+1,end);
            //与node_i组合所有可能的左右子树
            for (TreeNode node_left: ans_left) {
                for (TreeNode node_right : ans_right) {
                    TreeNode root = new TreeNode(node_i);
                    root.left = node_left;
                    root.right = node_right;
                    //将此种可能的BST根节点加入ans
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}
