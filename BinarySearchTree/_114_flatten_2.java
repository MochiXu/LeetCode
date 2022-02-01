package BinarySearchTree;

import java.util.LinkedList;

/**给你二叉树的根结点 root ，请你将它展开为一个单链表：
 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 展开后的单链表应该与二叉树 先序遍历 顺序相同。

 思路：使用先序迭代的过程解决问题
 */
public class _114_flatten_2 {
    LinkedList<TreeNode> nodes=new LinkedList<>();
    public void flatten(TreeNode root) {
        //边界判断
        if(root==null)
            return;
        //先序迭代
        LinkedList<TreeNode> stack=new LinkedList<>();
        while (stack.size()!=0||root!=null){
            //入栈过程
            if (root!=null){
                stack.addLast(root);
                nodes.addLast(root);
                root=root.left;
            }
            //栈顶pop转向
            else if(root==null){
                TreeNode node=stack.pollLast();
                root=node.right;
            }
        }
        //迭代完成后进行链表展开
        for (int i=0;i<nodes.size()-1;i++){
            nodes.get(i).left=null;
            nodes.get(i).right=nodes.get(i+1);
        }
        nodes.get(nodes.size()-1).right=null;
    }
}
