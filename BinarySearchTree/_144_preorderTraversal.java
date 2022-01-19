package BinarySearchTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树的前向遍历，对比之前的版本改进了很多，主要是集中在一个while中用判断当前节点是否为空的方式进行后序操作
 * */
public class _144_preorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack =new LinkedList<>();
        List<Integer> list=new ArrayList<>();

        //边界判断
        if (root==null)return list;

        while (stack.size()!=0||root!=null){
            //入栈
            if(root!=null){
                list.add(root.val);//前序遍历的位置
                stack.addLast(root);
                root=root.left;
            }
            else {
                root=stack.pollLast().right;
            }
        }
        return list;
    }
}
