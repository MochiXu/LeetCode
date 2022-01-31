package BinarySearchTree;

import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * 思路：使用层序遍历的思想，进行正常的层序遍历，但是需要记录遍历深度，如果是奇数深度，则从左往右入栈，如果是偶数深度，则从右往左入栈
 */
public class _103_zigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> lists = new LinkedList<>();


        if (root == null) {
            return lists;
        }

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.addLast(root);
        int num = 1;
        while (stack.size() != 0) {
            LinkedList<Integer> list  = new LinkedList<>();//用于暂存层级节点数据
            int length = stack.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = stack.pollFirst();
                if (node.left != null) stack.addLast(node.left);
                if (node.right != null) stack.addLast(node.right);
                if (num % 2 == 1) {
                    list.addLast(node.val);
                } else {
                    list.addFirst(node.val);
                }
            }
            lists.add(list);
            num++;
        }
        return lists;
    }


}
