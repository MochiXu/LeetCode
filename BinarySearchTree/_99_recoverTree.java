package BinarySearchTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;

/**
 * 给你二叉搜索树的根节点 root ，该树中的 恰好 两个节点的值被错误地交换。请在不改变其结构的情况下，恢复这棵树 。
 * <p>
 * 思路：使用迭代的中序遍历，则会破坏root结构
 * 使用递归的中序遍历，若在递归过程中交换次序后return，则会跳转到别的递归函数继续执行，导致错误
 * <p>
 * 目前先用最简单的O(n)空间复杂度
 */
public class _99_recoverTree {


    public void recoverTree(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        inOrder(list,root);
        int node_num=list.size();
        int index_1=-1;
        int index_2=-1;
        for (int i=1;i<node_num;i++){
            //先假设node_num不小于3
            if(list.get(i).val<list.get(i-1).val){
                if (index_1==-1){
                    index_1=i-1;
                }else {
                    index_2=i;
                    break;
                }
            }
        }
        //进行交换--交换两个不相邻的数字
        if(index_1!=-1&&index_2!=-1){
            int temp=list.get(index_1).val;
            list.get(index_1).val=list.get(index_2).val;
            list.get(index_2).val=temp;
        }
        //进行交换--交换两个相邻的数字
        if(index_1!=-1&&index_2==-1){
            int temp=list.get(index_1).val;
            list.get(index_1).val=list.get(index_1+1).val;
            list.get(index_1+1).val=temp;
        }
    }

    public void inOrder(LinkedList<TreeNode> list, TreeNode root) {
        if (root != null) {
            inOrder(list, root.left);
            list.addLast(root);
            inOrder(list, root.right);
        }
    }

    //使用递归不行，即使return也会污染其他栈，这里使用迭代
    public void inOrder(TreeNode root) {

    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        System.out.println(root.left.val);
        TreeNode temp = root;
        temp.left = null;
        System.out.println(root.left.val);
//        _99_recoverTree recoverTree=new _99_recoverTree();
//        recoverTree.recoverTree(root);


    }
}
