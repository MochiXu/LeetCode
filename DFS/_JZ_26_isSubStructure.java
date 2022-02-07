package DFS;

import java.util.LinkedList;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 思路：直接使用先序遍历的迭代模版
 * */
public class _JZ_26_isSubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(A==null||B==null)return false;
        //可以把下面这个if else合并
        if(A.val==B.val){
            return compare(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
        }else return isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }
    public boolean compare(TreeNode A_root,TreeNode B_root) {
        //此处两个if的顺序不可颠倒
        if (B_root==null)return true;
        if (A_root==null||A_root.val!= B_root.val) return false;
        return compare(A_root.left,B_root.left)&&compare(A_root.right,B_root.right);

    }
    public static void main(String args[]){
        _JZ_26_isSubStructure isSubStructure =new _JZ_26_isSubStructure();
        TreeNode node=new TreeNode(1);
        node.left=new TreeNode(0);
        node.right=new TreeNode(1);
        node.left.left=new TreeNode(-4);
        node.left.right=new TreeNode(-3);
        TreeNode node1=new TreeNode(1);
        node1.left=new TreeNode(-4);
        System.out.println(isSubStructure.isSubStructure(node,node1));
    }


}
