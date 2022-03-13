package OtherPractice.ByteDance;
/**
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 *
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 *
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *
 * */
public class _7_reverse {
    public int reverse(int x) {
        int res=0;
        if (x==0)return 0;
        int flag=x>0?1:-1;
        x=Math.abs(x);
        if (x>0)
        while (x!=0){
            int lastNumOfX=x%10;
            x=x/10;
            if (res!=0&&Integer.MAX_VALUE/res<10){
                return 0;
            }
            res=res*10+lastNumOfX;
        }
        return res*flag;
    }
    public static void main(String args[]){
        _7_reverse reverse=new _7_reverse();
        System.out.println(reverse.reverse(-378543));
    }
}
