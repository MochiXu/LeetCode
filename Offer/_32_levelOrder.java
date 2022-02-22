package Offer;

import BinarySearchTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * */
public class _32_levelOrder {

    public int[] levelOrder(TreeNode root) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        if (root==null) return new int[0];
        LinkedList<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while (queue.size()!=0){
            TreeNode node=queue.pollFirst();
            arrayList.add(node.val);
            if (node.left!=null)queue.add(node.left);
            if (node.right!=null)queue.add(node.right);
        }
        int []a=new int[arrayList.size()];
        for (int i=0;i<arrayList.size();i++){
            a[i]=arrayList.get(i);
        }
        return a;
    }
}
