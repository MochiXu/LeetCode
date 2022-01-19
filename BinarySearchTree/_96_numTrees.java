package BinarySearchTree;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
 * 返回满足题意的二叉搜索树的种数。
 */
public class _96_numTrees {
    public int numTrees(int n) {
        //用于合并子问题的解
        int sum = 0;

        //最小子问题
        if (n == 0) return 1;
        if (n <= 2) return n;

        //递归入口
        for (int i = 1; i <= n; i++) {
            sum += numTrees(i - 1) * numTrees(n - i);
        }

        //递归出口
        return sum;

    }
}
