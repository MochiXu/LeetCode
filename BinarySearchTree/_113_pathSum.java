package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;
/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 思路：深度优先搜索，或者使用递归，但是直接想递归有点点无从下手，参照112题可以使用递归，那此处还是用DP靠谱,257的回溯方法也可以尝试
 * 测试下git版本
 *
 * */
public class _113_pathSum {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        //参照257方法使用回溯
        List<List<Integer>> lists=new LinkedList<>();

        //边界判断
        if(root==null) {
            return lists;
        }
        if(root.left==null&&root.right==null&&root.val!=targetSum){
            return lists;
        }
        //最小子问题
        if(root.left==null&&root.right==null&&root.val==targetSum){
            List<Integer> list=new LinkedList<>();
            list.add(root.val);
            lists.add(list);
            return lists;
        }


        //向上进行回溯
        List<List<Integer>> lists_left=pathSum(root.left,targetSum-root.val);
        List<List<Integer>> lists_right=pathSum(root.right,targetSum-root.val);

        //递归出口
        for (List<Integer> list : lists_left){
            list.add(0,root.val);
            lists.add(list);
        }
        for (List<Integer> list : lists_right){
            list.add(0,root.val);
            lists.add(list);
        }
        return lists;



    }

}
