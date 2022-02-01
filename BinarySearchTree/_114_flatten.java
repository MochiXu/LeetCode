package BinarySearchTree;

import java.util.LinkedList;

/**给你二叉树的根结点 root ，请你将它展开为一个单链表：
 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树 先序遍历 顺序相同。

 思路：使用dfs/先序遍历解决问题，也可以使用先序的迭代过程解决问题
 */
public class _114_flatten {
    LinkedList<TreeNode> nodes=new LinkedList<>();

    public void flatten(TreeNode root) {
        //边界判断
        if(root==null)
            return;
        dfs(root);
        for (int i=0;i<nodes.size()-1;i++){
            nodes.get(i).left=null;
            nodes.get(i).right=nodes.get(i+1);
        }
        nodes.get(nodes.size()-1).right=null;

    }
    public void dfs(TreeNode root){
        if(root==null)return;
        nodes.addLast(root);
        dfs(root.left);
        dfs(root.right);
    }
}
