package BinarySearchTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树后序遍历迭代方式
 * 先访问只能是根节点，访问根->左入栈->右入栈，再出栈就是根-右-左，最终反转就是左-右-根
 */
public class _145_postorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        LinkedList<TreeNode> stack = new LinkedList<>();
        while (stack.size() != 0 || root != null) {
            if(root!=null) {
                //访问根
                list.add(root.val);
                //加入左
                if (root.left != null) stack.addLast(root.left);
                //加入右
                if (root.right != null) stack.addLast(root.right);
                //弹出栈顶
                root=stack.pollLast();
            }
        }
        Collections.reverse(list);
        return list;
    }
}
