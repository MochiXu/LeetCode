package BinarySearchTree;

import java.util.ArrayList;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 *
 *
 * 思路：考虑到需要判断左子树节点右子树节点值的比较，因此需要用子函数传参数才行【此思路没有完全写出来，需要参考题解的方法，传参可以是上下限】
 * 其他思路：可以使用中序遍历，比较Sort之后的数组和Sort之前的数组是否一致
 * */
public class _98_isValidBST {

    //第一版本
//    public boolean isValidBST(TreeNode root) {
//        return subValidBST(root.left, root.val, 1)&&subValidBST(root.right, root.val, 2);
//    }
//
//    public boolean subValidBST(TreeNode root, int num,int direction){
//        if(root==null)return true;
//        if(root.left==null&&root.right==null){
//            if(direction==1){
//                if(root.val<num) return true;else return false;
//            }else if(direction==2){
//                if(root.val>num) return true;else return false;
//            }
//        }
//        if(root.left==null&&direction==1) return true;
//        if (root.left==null&&direction==2) return subValidBST(root.right,root.val,2);
//        if(root.right==null&&direction==2) return true;
//        if (root.right==null&&direction==1) return subValidBST(root.left,root.val,1);
//
//        return false;
//    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> arr=new ArrayList<>();
        inOrder(root,arr);
        for (int i=1;i<arr.size();i++){
            if(arr.get(i)>=arr.get(i-1)) return false;
        }
        return true;
    }

    public void inOrder(TreeNode root, ArrayList<Integer> arrayList){
        if(root!=null){
            inOrder(root.left,arrayList);
            arrayList.add(root.val);
            inOrder(root.right,arrayList);
        }
    }

}
