package Offer;
/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 *
 * */
public class _58_reverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        int stringLength=s.length();
        if (stringLength==0)return "";
        if (stringLength==1)return s;
        if (stringLength<n){
            n=n%stringLength;
        }
        return s.substring(n,stringLength)+s.substring(0,n);
    }
}
