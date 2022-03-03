package NewCoder.Easy;

import java.util.LinkedList;
import java.util.Scanner;

/*
 某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
 现需要按照身高由低到高排列，
 对身高相同的人，按体重由轻到重排列，
 对于身高体重都相同的人，维持原有的编号顺序关系。
 请输出排列后的学生编号
 输入描述：
    两个序列，每个序列由N个正整数组成，(0<n<=100)。
    第一个序列中的数值代表身高，第二个序列中的数值代表体重，
 输出描述：
    排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
 实例一：
    输入:
     4
     100 100 120 130
     40 30 60 50
    输出:
     2134
 */
public class _79_Shengao {
    private String high;
    private String weigh;
    private int id;
    public _79_Shengao(String high,String weigh,int id){
        this.high=high;
        this.weigh=weigh;
        this.id=id;
    }
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int num=Integer.parseInt(in.nextLine());
        String[] highArr=in.nextLine().split(" ");
        String[] weighArr=in.nextLine().split(" ");
        in.close();
        LinkedList<_79_Shengao> list=new LinkedList<>();
        for (int i=1;i<=num;i++){
            _79_Shengao stu=new _79_Shengao(highArr[i-1],weighArr[i-1],i);
            list.add(stu);
        }
        list.sort((right,left)->{
            if (Integer.parseInt(left.high)!=Integer.parseInt(right.high)){
                //返回值<0的时候会交换:left-right<0说明要交换，则是递减排列
                //返回值>0的时候不会交换:left-right>0的时候不会交换，说明是递减排列
                return Integer.parseInt(right.high)-Integer.parseInt(left.high);
            }else {
                return Integer.parseInt(right.weigh)-Integer.parseInt(left.weigh);
            }
        });
        for (_79_Shengao shengao: list){
            System.out.print(shengao.id);
        }
    }

}
