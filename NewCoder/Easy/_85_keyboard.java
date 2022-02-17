package NewCoder.Easy;

import java.util.Scanner;

/*
* 有一个特殊的五键键盘
    上面有A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A
    A键在屏幕上输出一个字母A
    Ctrl-C将当前所选的字母复制到剪贴板
    Ctrl-X将当前选择的字母复制到剪贴板并清空所选择的字母
    Ctrl-V将当前剪贴板的字母输出到屏幕
    Ctrl-A选择当前屏幕中所有字母
    注意：
      1. 剪贴板初始为空
      2. 新的内容复制到剪贴板会覆盖原有内容
      3. 当屏幕中没有字母时,Ctrl-A无效
      4. 当没有选择字母时Ctrl-C、Ctrl-X无效
      5. 当有字母被选择时A和Ctrl-V这两个输出功能的键,
         会先清空所选的字母再进行输出

    给定一系列键盘输入,
    输出最终屏幕上字母的数量

    输入描述:
       输入为一行
       为简化解析用数字12345分别代替A、Ctrl-C、Ctrl-X、Ctrl-V、Ctrl-A的输入
       数字用空格分割

    输出描述:
        输出一个数字为屏幕上字母的总数量

    示例一:
        输入:
          1 1 1
        输出:
          3

   示例二:
        输入:
          1 1 5 1 5 2 4 4
        输出:
          2
* */
public class _85_keyboard {
    private int getCount(String[] input){
        String curString="";
        String copyBoard="";
        Boolean select=false;//默认没有选中任何元素
        for (int i=0;i<input.length;i++){
            if (input[i].equals("1")){
                //输入A
                if (select==false)
                    curString=curString+"A";
                else curString="A";
                select=false;
            }else if(input[i].equals("2")){
                //ctrl C 到粘贴板
                if (select==true){
                    copyBoard=curString;
                }

                //select不变化
            }else if(input[i].equals("3")){
                //剪切到粘贴板
                if (select==true){
                    copyBoard=curString;
                    curString="";
                }

                select=false;
            }else if(input[i].equals("4")){
                //ctrl V 到字符串
                if (select==true){
                    curString=copyBoard;
                }else {
                    curString=curString+copyBoard;
                }
                select=false;
            }else if(input[i].equals("5")){
                //全选
                if (curString.length()==0)
                    select=false;
                else
                    select=true;
            }
        }
        return curString.length();
    }

    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        String[] input=scanner.nextLine().split(" ");
        _85_keyboard keyboard=new _85_keyboard();
        System.out.println(keyboard.getCount(input));

    }
}
