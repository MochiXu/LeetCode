package Offer;
//整数除法
//Java负整数的二进制是补码

/**
 * 思路如下
 * 每次左移1bit都是扩大2倍
 * 如36/7
 * 36/7*2*2=1，得到1*2*2=4
 * 36-28=8/7=1，得到1*2^0=1
 * 8-7=1/7=0，得到0*2^0=0
 */
public class _01_divide {
    public int divide(int a, int b) {
        //注意：Java中int类型的除法只有一种情况会导致溢出即Integer.MIN/-1，原因是补码只有一个0，导致负数部分比正数部分多了一个数字，负负得正就会溢出
        if (a == Integer.MIN_VALUE && b == -1)
            return Integer.MAX_VALUE;
        if (b == 1)
            return a;
        if (b == -1)
            return -a;
        if (a == 0) return 0;

        //Integer.MIN_VALUE作为被除数的时候，如果转为正数进行计算，肯定会溢出，所以接下来进行处理的时候把正数都更改为负数进行计算。
        int result = 0;
        int flag = -1;//-1均为负，0均为正，1表示a正b负，2表示a负b正
        if (a > 0 && b > 0) {
            flag = 0;
        }
        if (a > 0 && b < 0) {
            flag = 1;
        }
        if (a < 0 && b > 0) {
            flag = 2;
        }
        if (a>0) a=-a;
        if (b>0) b=-b;


        while (a <= b) {
            int leftNum = getLeftShift(a, b);
            int curRes = 1;//设置成1的原因是，每次只要是进入while循环，就说明最起码的除法结果>1
            int originB = b;

            curRes <<= leftNum;
            a = a - (b << leftNum);

            b = originB;
            result += curRes;
        }
        return flag == 0||flag==-1 ? result :  - result;
    }

    //默认a为负数且b为负数
    public int getLeftShift(int a, int b) {
        //a是被除数、b是除数，目标：找到b<<leftNum < a 时，leftNum的最大值
        int leftNum = 0;
        while (b >= a&& b>=Integer.MIN_VALUE>>1) {//b不能一直左移，左移越界之后就会变成0，从而无限循环
            b <<= 1;//不允许使用乘法，左移扩大二倍
            leftNum++;
        }
        return leftNum==0?0:leftNum - 1;//这里很好理解，如果leftNum=0的话，就说明b处于越界的边缘，那么只能返回0
    }

    private int getMaxShift(int num, int min) {
        // num 是除数，min 是被除数，希望找到 num << shift < min 时，shift 的最大值
        int shift = 0;
        int temp = num;
        while (temp > min && temp >= Integer.MIN_VALUE >> 1) {
            temp <<= 1;
            shift++;
        }
        return shift;
    }

    public static void main(String args[]) {
        _01_divide divide = new _01_divide();
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE >> 1));
//        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(divide.divide(1100540749,-1090366779));
//        System.out.println(Integer.MIN_VALUE);
    }
}
