package OtherPractice.ByteDance;
/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 *
 * 输入：s = "babad"
 * 输出："bab"
 * 解释："aba" 同样是符合题意的答案。
 *
 * */
public class _5_longestPalindrome {
    public String longestPalindrome(String s) {
        if (s.length()<=1)return s;
        int maxlength=0;
        int left=0,right=0;
        for (int i=0;i<s.length();i++){
            int count1=this.getCount(s,i,i);
            int count2=this.getCount(s,i,i+1);
            if (count1*2-1>maxlength){
                left=i-count1+1;
                right=i+count1-1;
                maxlength=count1*2-1;
            }
            if (count2*2>maxlength){
                left=i-count2+1;
                right=i+count2;
                maxlength=2*count2;
            }
        }
        return s.substring(left,right+1);


    }
    public int getCount(String str,int left,int right){
        int count=0;
        for (;left>=0&&right<str.length();left--,right++){
            if (str.charAt(left)==str.charAt(right)){
                count++;
            }else break;
        }
        return count;
    }

    public static void main(String args[]){
        _5_longestPalindrome lo=new _5_longestPalindrome();
        System.out.println(lo.longestPalindrome("cbbd"));
    }
}
