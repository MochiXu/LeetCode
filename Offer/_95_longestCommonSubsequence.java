package Offer;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 *
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 *
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 *
 * */
public class _95_longestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        char[] text1_arr=text1.toCharArray();
        char[] text2_arr=text2.toCharArray();
        int[][] dp=new int[text1_arr.length+1][text2_arr.length+1];
        for (int i=0;i<text1_arr.length+1;i++){
            for (int j=0;j< text2_arr.length+1;j++){
                dp[i][j]=0;
            }
        }
        for (int i=0;i< text1_arr.length;i++){
            for (int j=0;j< text2_arr.length;j++){
                //穷举dp
                if (text1_arr[i]==text2_arr[j]){
                    dp[i+1][j+1]=dp[i][j]+1;
                }else {
                    dp[i+1][j+1]=Math.max(dp[i][j+1],dp[i+1][j]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String args[]){
        _95_longestCommonSubsequence longestCommonSubsequence=new _95_longestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("abcde","ace"));
    }

}
