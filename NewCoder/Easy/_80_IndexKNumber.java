package NewCoder.Easy;

import java.util.*;

/**
 *      给定参数n,从1到n会有n个整数:1,2,3,...,n,
 *         这n个数字共有n!种排列.
 *       按大小顺序升序列出所有排列的情况,并一一标记,
 *       当n=3时,所有排列如下:
 *       "123" "132" "213" "231" "312" "321"
 *       给定n和k,返回第k个排列.
 *
 *       输入描述:
 *         输入两行，第一行为n，第二行为k，
 *         给定n的范围是[1,9],给定k的范围是[1,n!]。
 *       输出描述：
 *         输出排在第k位置的数字。
 *
 *       实例1：
 *         输入:
 *           3
 *           3
 *         输出：
 *           231
 *         说明
 *           3的排列有123,132,213...,那么第三位置就是213
 *
 *       实例2：
 *         输入
 *           2
 *           2
 *         输出：
 *           21
 *         说明
 *           2的排列有12,21，那么第二位置的为21
 * */
public class _80_IndexKNumber {
    private ArrayList<String> arrayList=new ArrayList<>();
    private String curStr="";
    private String getKNum(int n,int k){

        LinkedList<Integer>list=new LinkedList<>();
        for (int i=1;i<=n;i++) list.add(i);
        dfs(-1,list);
        Collections.sort(arrayList);
        return arrayList.get(k);

    }
    private void dfs(int root, LinkedList<Integer> list){
        if (list.size()==0){
            curStr=curStr+root;
            arrayList.add(curStr);
            return;
        }
        if (root!=-1) curStr=curStr+root;
        for (int nextNode:list){
            LinkedList<Integer> nextList=new LinkedList<>();
            for (int i=0;i<list.size();i++){
                if (list.get(i)!=nextNode) nextList.add(list.get(i));
            }
            dfs(nextNode,nextList);
            curStr=curStr.substring(0,curStr.length()-1);
        }
    }
    public static void main(String args[]){
        //思路：肯定不能直接用int类型，应该需要用字符串类型
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int k=Integer.parseInt(scanner.nextLine());
        _80_IndexKNumber indexKNumber=new _80_IndexKNumber();
        System.out.println(indexKNumber.getKNum(n,k));
    }
}
