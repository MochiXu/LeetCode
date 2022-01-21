package BinarySearchTree;
/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 * 思路：需要利用BST的性质，也就是pq不能同时位于root的一侧，需要分为位于root的左右两侧
 * 实际上编写代码还是比较简单，就是说只要pq同时大于或者同时小于root，那么root就进行移动
 * 否则的话会出现什么情况呢，会出现p和q一个大于root一个小于root，或者是其中一个等于root，另一个大于或小于root的情况
 * 而这种情况下，root就是他们的最小公共祖先，那么直接返回结果就行
 * */
public class _235_lowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val> p.val&&root.val> q.val) return lowestCommonAncestor(root.left,p,q);
        if(root.val< p.val&&root.val< q.val) return lowestCommonAncestor(root.right,p,q);
        return root;
    }
}
