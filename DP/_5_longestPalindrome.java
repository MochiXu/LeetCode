package DP;

import java.util.LinkedList;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * 思路：DP想不通，如果使用栈的话，复杂度将会非常高，而且不容易计算
 *      这里的解决方案就是，逐个的扫描，以每个扫描的元素为中心去判断回文串的长度
 * */
public class _5_longestPalindrome {
    public String longestPalindrome(String s) {
        char[] arr=s.toCharArray();
        int flag=-1;
        String [] arr_string=new String[arr.length];
        for (int i=0;i<arr.length;i++)
            arr_string[i]=arr[i]+"";
        LinkedList<String> stack=new LinkedList<>();

        int current_num=1;
        int max_num=1;
        int max_index=-1;
        for (int i=1;i<= arr.length-2;i++){
            //奇数情况
            for (int j=1;j<=i&&j<=arr.length-i-1;j++){
                if (arr[i-j]==arr[i+j]){
                    //i位置的左侧j和右侧j相同，相同则记录长度
                    current_num+=2;
                }else {
                    //出现一次不相同就跳出
                    break;
                }
            }
            if (current_num>max_num){
                max_num=current_num;
                max_index=i;
                flag=0;
            }

            current_num=1;
            //偶数情况
            for (int j=1;j<=i+1&&j<=arr.length-i-1;j++){
                if (arr[i-j+1]==arr[i+j]){
                    if (j==1)current_num+=1;
                    if (j!=1)current_num+=2;

                }else break;
            }
            if (current_num>max_num){
                max_num=current_num;
                max_index=i;
                flag=1;
            }

            current_num=1;
            //偶数情况
            for (int j=1;j<=i&&j<=arr.length-i-1;j++){
                if (arr[i-j]==arr[i+j-1]){
                    if (j==1)current_num+=1;
                    if (j!=1)current_num+=2;
                }else break;
            }
            if (current_num>max_num){
                max_num=current_num;
                max_index=i;
                flag=2;
            }

            current_num=1;
        }
        if (arr.length==2){
            if (arr[0]==arr[1])
                return s;
            else return arr_string[0];
        }
        String ans="";
        if (max_index==-1&&arr.length==1) return arr_string[0];
        if (max_index==-1)return arr_string[0];
        if (flag==0) {
            for (int i = max_index - (max_num - 1) / 2; i <= max_index + (max_num - 1) / 2; i++) {
                ans += arr_string[i];
            }
        }
        if (flag==1) {
            for (int i = max_index - max_num / 2 + 1; i <= max_index + max_num / 2; i++)
                ans += arr_string[i];
        }
        if (flag==2) {
            for (int i = max_index - max_num / 2; i <= max_index + max_num / 2 - 1; i++)
                ans += arr_string[i];
        }

        System.out.println(max_index+" "+max_num+" "+flag);
        return ans;

    }
    public static void main(String agrs[]){
        _5_longestPalindrome longestPalindrome=new _5_longestPalindrome();
//        System.out.println(longestPalindrome.longestPalindrome("babad"));
        System.out.println(longestPalindrome.longestPalindrome("aaaa"));
    }
}
