package NewCoder.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/*
           已知火星人使用的运算符号为#;$
           其与地球人的等价公式如下
           x#y=2*x+3*y+4
           x$y=3*x+y+2
           x y是无符号整数
           地球人公式按照c语言规则进行计算
           火星人公式中$符优先级高于#相同的运算符按从左到右的顺序运算

           输入描述：
           火星人字符串表达式结尾不带回车换行
           输入的字符串说明是 字符串为仅有无符号整数和操作符组成的计算表达式

           1.用例保证字符串中操作数与操作符之间没有任何分隔符
           2.用例保证操作数取值范围为32位无符号整数，
           3.保证输入以及计算结果不会出现整型溢出
           4.保证输入的字符串为合法的求值报文
           例如: 123#4$5#76$78
           5.保证不会出现非法的求值报文
           例如: #4$5 这种缺少操作数
                4$5#  这种缺少操作数
                4#$5  这种缺少操作数
                4 $5  有空格
                3+4-5*6/7 有其他操作符
                12345678987654321$54321 32位整数溢出

           输出描述：
             根据火星人字符串输出计算结果
             结尾不带回车换行

           案例1：
          输入：
           7#6$5#12
          输出：
           226

           说明 示例7#6$5#12=7#(3*6+5+2)#12
                           =7#25#12
                           =(2*7+3*25+4)#12
                           =93#12
                           =2*93+3*12+4
                           =226
         */
public class _46_Convert {
    private int solution1(String x,String y){

        return 2*Integer.parseInt(x)+3*Integer.parseInt(y)+4;
    }
    private int solution2(String x,String y){
        return 3*Integer.parseInt(x)+Integer.parseInt(y)+2;
    }
    public static void main(String args[]){
        _46_Convert convert=new _46_Convert();
        Scanner scanner=new Scanner(System.in);
        String origin=scanner.nextLine();
        String number=origin.replace('#',' ');
        number=number.replace('$',' ');
        LinkedList<String> numberList=new LinkedList<>(Arrays.asList(number.split(" ")));
        LinkedList<String> list=new LinkedList<>();
        char[] originChar=origin.toCharArray();
        for (int i=0;i<originChar.length;i++){
            if (originChar[i]=='#'||originChar[i]=='$'){
                list.add(originChar[i]+"");
            }
        }
        //可以使用indexOf方法，这样就能很好的去处理
        int pos$=list.indexOf("$");

        //先计算所有的$
        while (pos$!=-1){
            int temp=convert.solution2(numberList.get(pos$),numberList.remove(pos$+1));
            numberList.set(pos$,temp+"");
            list.remove(pos$);
            pos$=list.indexOf("$");
        }
        //再计算剩下的#
        while (numberList.size()!=1){
            numberList.addFirst(convert.solution1(numberList.pollFirst(),numberList.pollFirst())+"");
        }


        System.out.println(numberList.get(0));


    }
}
