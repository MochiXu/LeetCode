package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 返回二叉树的所有路径(结点数>=1)
 * 输入：root = [1,2,3,null,5]
 * 输出：["1->2->5","1->3"]
 *
 * 耗时：10min
 * */
public class _257_binaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list=new LinkedList<>();
        //最小子问题
        if(root==null) return list;
        if(root.left==null&&root.right==null) {
            list.add(""+root.val);
        }
        //向上追溯root是非叶子节点，root为中间节点
        List<String> list_left=binaryTreePaths(root.left);
        List<String> list_right=binaryTreePaths(root.right);
        for (int i=0;i<list_left.size();i++){
            list.add(i,root.val+"->"+list_left.get(i));
        }
        for (int i=0;i<list_right.size();i++){
            list.add(i,root.val+"->"+list_right.get(i));
        }
        return list;
    }
}
