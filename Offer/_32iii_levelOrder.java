package Offer;

import BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 */
public class _32iii_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int flag = 0;//用于之字形切换标志
        while (queue.size() != 0) {
            //先之字形遍历，然后再加入层序逻辑
            List<Integer> list = new ArrayList<>();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                //之字形存储
                if (flag % 2 == 0) list.add(queue.get(i).val);
                if (flag % 2 != 0) list.add(queue.get(queueSize-i-1).val);
            }
            for (int i = 0; i < queueSize; i++) {
                //层序逻辑
                TreeNode node = queue.pollFirst();
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
            flag++;
            result.add(list);
        }
        return result;
    }
}
