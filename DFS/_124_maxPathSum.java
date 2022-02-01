package DFS;

/**
 * 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * 思路：需要返回最大路径和，可以找出所有可能的路径
 * 所有在递归过程中可能出现的情况如下分析
 * root+left+right、root+left、root+right、root
 * 通过对比上述四种值的大小，来选取max_sum更新的目标值，需要注意的是return的时候只能return root的一侧（root与left或者是root与right）
 */
public class _124_maxPathSum {
    int max_sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        subMaxPath(root);
        return max_sum;
    }
    public int subMaxPath(TreeNode root){
        //边界处理
        if (root == null) return 0;
        if (root.left == null && root.right == null){
            if(root.val>max_sum) max_sum= root.val;
            return root.val;
        }

        //进入递归
        int left_sum = subMaxPath(root.left);
        int right_sum = subMaxPath(root.right);

        //递归返回处理
        int connect_1=left_sum+ root.val;
        int connect_2=right_sum+ root.val;
        int connect_3=right_sum+ root.val+left_sum;

        int max=Math.max(root.val, Math.max(connect_1,Math.max(connect_2,connect_3)));
        if(max>max_sum)max_sum=max;
        return Math.max(root.val,Math.max(connect_1,connect_2));

    }

    public static void main(String agrs[]){
        TreeNode root=new TreeNode(2);
        root.left=new TreeNode(-1);
        root.right=new TreeNode(-2);
        _124_maxPathSum pathSum=new _124_maxPathSum();
        System.out.println(pathSum.maxPathSum(root));
    }
}
