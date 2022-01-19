package BinarySearchTree;
/**
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
 * */
public class _100_isSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null||q==null){
            return p==null&&q==null;
        }
        //记得判断节点值是否相等,以及这种递归入口的表达方式
        return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right)&&p.val==q.val;
    }
}
