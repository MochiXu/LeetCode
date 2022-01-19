package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;
/**
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[9,20],[15,7]]
 * 每一层在一个List中出现，最外面的一层是一个List
 * */

/**
 * 实际上此题解法可以优化，不需要使用额外的辅助队列
 * 当队列不为空的时候
 * 求当前队列的长度并取出n个元素进行拓展，然后进入下一次迭代
 * */
public class _102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //层序遍历的辅助队列
        LinkedList<TreeNode> stack =new LinkedList<>();
        List<List<Integer>> lists=new LinkedList<>();
        if (root==null) return lists;

        //首先调入根节点
        stack.addLast(root);
        while (stack.size()!=0){
            List<Integer> list=new LinkedList<>();

            //创建辅助队列，以便层序分层记录
            LinkedList<TreeNode> list_node=new LinkedList<>();

            /**
             * 优化版本：不适用额外的辅助队列，记录下来stack的当前长度，然后使用for循环
             * */
            //移出stack中所有的节点到辅助队列
            while (stack.size()!=0){
                TreeNode cur_node=stack.pollFirst();
                list_node.add(cur_node);
                list.add(cur_node.val);
            }
            lists.add(list);
            //根据辅助队列中的node节点调入下一层node
            while (list_node.size()!=0){
                TreeNode cur_node=list_node.pollFirst();
                if (cur_node.left!=null) stack.addLast(cur_node.left);
                if (cur_node.right!=null) stack.addLast(cur_node.right);
            }
        }
        return lists;
    }
}
