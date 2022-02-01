package DFS;

import java.util.LinkedList;

/**
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 思路：使用层序遍历
 * */
public class _116_connect {
    public Node connect(Node root) {
        LinkedList<Node> queue=new LinkedList<>();
        if(root==null) return null;

        //将第一个根节点入队
        queue.addLast(root);
        while (queue.size()!=0){
            //用队列长度约束遍历深度
            int length=queue.size();
            for (int i=0;i<length;i++){

                //层序遍历--左侧出队右侧入队
                Node node=queue.pollFirst();
                if (node.left!=null) queue.addLast(node.left);
                if (node.right!=null) queue.addLast(node.right);
                //填充每个节点的next指针
                if(i!=length-1)
                    node.next=queue.getFirst();
                if(i==length-1)
                    node.next=null;
            }
        }
        return root;
    }
}
