package NewCoder.Easy;

import java.util.LinkedList;
import java.util.Scanner;

/*
 运维工程师采集到某产品线网运行一天产生的日志n条
 现需根据日志时间先后顺序对日志进行排序
 日志时间格式为H:M:S.N
 H表示小时(0~23)
 M表示分钟(0~59)
 S表示秒(0~59)
 N表示毫秒(0~999)
 时间可能并没有补全
 也就是说
 01:01:01.001也可能表示为1:1:1.1

 输入描述
    第一行输入一个整数n表示日志条数
    1<=n<=100000
    接下来n行输入n个时间

  输出描述
    按时间升序排序之后的时间
    如果有两个时间表示的时间相同
    则保持输入顺序

  示例：
    输入：
     2
     01:41:8.9
     1:1:09.211
    输出
      1:1:09.211
      01:41:8.9
  示例
     输入
      3
      23:41:08.023
      1:1:09.211
      08:01:22.0
     输出
       1:1:09.211
       08:01:22.0
       23:41:08.023

   示例
     输入
       2
       22:41:08.023
       22:41:08.23
     输出
       22:41:08.023
       22:41:08.23
     时间相同保持输入顺序
      */
public class _78_Logs {
    private int H;
    private int M;
    private double SN;

    public _78_Logs(int H, int M, double SN) {
        this.H = H;
        this.M = M;
        this.SN = SN;
    }

    @Override
    public String toString() {
        return this.H+":"+this.M+":"+this.SN;
    }

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int logNum = Integer.parseInt(in.nextLine());
        LinkedList<_78_Logs> list=new LinkedList<>();
        for (int i = 0; i < logNum; i++) {
            String[] tempLo = in.nextLine().split(":");
            _78_Logs log = new _78_Logs(
                    Integer.parseInt(tempLo[0]),
                    Integer.parseInt(tempLo[1]),
                    Double.parseDouble(tempLo[2])
            );
            list.add(log);
        }
        list.sort((right,left)->{
            if (left.H!=right.H){
                return right.H- left.H;
            }else if(left.M!=right.M){
                return right.M- left.M;
            }else {
                return (int) (right.SN- left.SN);
            }
        });
        for (_78_Logs log : list){
            System.out.println(log);
        }
    }
}
