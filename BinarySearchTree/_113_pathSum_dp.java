package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 *
 * 思路：从来没有使用过DP，这次根据参考答案试一下
 * DP是会遍历所有的路径，所以说在遍历的过程中进行路径的记录比较好
 * 这样的话就要求在遍历的外侧进行
 *
 * 这两种方法的效率是一样的回溯与DP
 *
 * */
public class _113_pathSum_dp {
    List<List<Integer>> path=new LinkedList<>();
    List<Integer> list=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root,targetSum);
        return path;

    }
    //使用dfs替代回溯过程
    public void dfs(TreeNode root,int targetSum){
        //边界判断
        if (root==null)return ;
        list.add(root.val);
        //边界判断
        if(root.left==null&&root.right==null&&root.val==targetSum){
            path.add(new LinkedList<>(list));
        }
        //递归
        dfs(root.left,targetSum-root.val);
        dfs(root.right,targetSum-root.val);

        //每次递归完成之后需要删除最后一个list元素，从而实现list复用
        list.remove(list.size()-1);

    }
}
