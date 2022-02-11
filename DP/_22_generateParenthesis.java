package DP;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 *
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 *
 * 思路：新增一对括号n+1的时候有三种可能的情况
 *      1、在最外层加
 *      2、在n对括号的所有个体上增加
 *      3、单独放入一对（）
 * */
public class _22_generateParenthesis {
    List<String> res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
       dfs(n,n,"");
       return res;
    }
    public void dfs(int left,int right,String curStr){
        //right<left说明了存在)开头的括号对
        if (right<left)return;
        if (left==0&&right==0){
//            System.out.println("**"+curStr);
            res.add(curStr);
            return;
        }
//        System.out.println(curStr);
        if (left>0) dfs(left-1,right,curStr+"(");
        if (right>0) dfs(left,right-1,curStr+")");
    }
    public static void main(String args[]){
        _22_generateParenthesis generateParenthesis=new _22_generateParenthesis();
        generateParenthesis.generateParenthesis(2);
    }
}
