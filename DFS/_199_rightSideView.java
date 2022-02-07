package DFS;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 *
 * 思路：记录层序遍历的最右侧节点
 * */
public class _199_rightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new LinkedList<>();
        if (root==null)return list;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.addLast(root);
        while (queue.size()!=0){
            int level_length= queue.size();
            list.add(queue.get(level_length-1).val);
            TreeNode node=null;
            for (int i=0;i<level_length;i++) {
                node = queue.pollFirst();
                if (node.left!=null)queue.addLast(node.left);
                if (node.right!=null)queue.addLast(node.right);
            }
        }
        return list;
    }
}
