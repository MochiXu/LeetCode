package String;
/**
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 *
 * 思路：用二维矩阵
 * */
public class _6_convert {
    public String convert(String s, int numRows) {
        char[] str=s.toCharArray();
        if (str.length<=1)return s;
        if (numRows==1)return s;
        int column=(s.length()/(2*numRows-2))*(numRows-1);
        if (s.length()%(2*numRows-2)<=numRows){
            column++;
        }else {
            column+=s.length()%(2*numRows-2)-numRows+1;
        }
        char[][] grid=new char[numRows][column];
        int index=0;
        for (int i=0;i<column;i++){
            int ro=0;
            for (;ro<numRows&&index<s.length();ro++){
                if (grid[ro][i]==0){
                    grid[ro][i]=str[index++];
                }
            }
            ro--;
            if (ro==numRows-1&&index!=str.length){
                while (index!=str.length&&ro!=1){
                    grid[--ro][++i]=str[index++];
                }
            }
        }
        String res="";
        for (int i=0;i< grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]!=0){
                    res+=grid[i][j];
                }
            }
        }
        return res;
    }
    public static void main(String args[]){
        _6_convert convert=new _6_convert();
        System.out.println(convert.convert("AB",1));
    }
}
