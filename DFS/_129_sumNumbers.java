package DFS;
/**
 * 给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
 * 每条从根节点到叶节点的路径都代表一个数字：
 *
 * 例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
 * 计算从根节点到叶节点生成的 所有数字之和 。
 *
 * 叶节点 是指没有子节点的节点。
 *
 *
 * 思路：使用DFS、递归都行
 * */
public class _129_sumNumbers {
    private int sum=0;
    private String num="";
    public int sumNumbers(TreeNode root) {
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode root){
        if (root==null)return;

        //得到新的字符串
        String num_origin=num;
        num=root.val+num;

        if(root.left==null&&root.right==null){
            //得出相应的数字，并进行累加
            int number=Integer.parseInt(num);
            sum+=number;
        }
        //dfs
        dfs(root.left);
        dfs(root.right);

        num=num_origin;
    }
}
