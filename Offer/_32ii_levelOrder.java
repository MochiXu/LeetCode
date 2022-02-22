package Offer;

import BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * */
public class _32ii_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if (root==null)return null;
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()!=0){
            int queueSize= queue.size();
            List<Integer> levelList=new ArrayList<>();
            for (int i=0;i<queueSize;i++){
                TreeNode node=queue.pollFirst();
                levelList.add(node.val);
                if (node.left!=null)queue.addLast(node.left);
                if (node.right!=null)queue.addLast(node.right);
            }
            result.add(levelList);
        }
        return result;
    }
}
