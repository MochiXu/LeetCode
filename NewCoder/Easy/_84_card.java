package NewCoder.Easy;

import java.util.*;

import static java.util.Arrays.asList;

/**
 * 小组中每位都有一张卡片
 * 卡片是6位以内的正整数
 * 将卡片连起来可以组成多种数字
 * 计算组成的最大数字
 * <p>
 * 输入描述：
 * ","分割的多个正整数字符串
 * 不需要考虑非数字异常情况
 * 小组种最多25个人
 * <p>
 * 输出描述：
 * 最大数字字符串
 * <p>
 * 示例一
 * 输入
 * 22,221
 * 输出
 * 22221
 * <p>
 * 示例二
 * 输入
 * 4589,101,41425,9999
 * 输出
 * 9999458941425101
 */
public class _84_card {
    private String result = "";

    private String process(String[] numStr) {
        //4589,101,41425,9999
        ArrayList<String> arrayList=new ArrayList<>(Arrays.asList(numStr));
        Collections.sort(arrayList,(right,left)->{
            if (right.length()==left.length()){
                //当字符串长度相同的时候
                return left.compareTo(right);
            }else {
                //当字符串长度不同的时候
                int minLength=Math.min(right.length(),left.length());
                //如果公共长度部分可以匹配
                if (right.substring(0,minLength).compareTo(left.substring(0,minLength))==0){
                    String res1=left+right;
                    String res2=right+left;
                    if (res1.compareTo(res2)>0){
                        return 1;//正序排序不需要交换
                    }else return -1;//逆序排序需要交换
                }else {
                    //公共长度部分不可以匹配
                    return left.substring(0,minLength).compareTo(right.substring(0,minLength));
                }
            }
        });
        for (String str: arrayList){
            result+=str;
        }
        return result;
    }

    private void learnTest() {
        //学习一下Comparator和其compare方法

        /*首先关于compareTo*/

        //比较两个字符，会返回左-右的asc差值
        System.out.println("a".compareTo("b"));//-1
        System.out.println("b".compareTo("a"));//1
        System.out.println("b".compareTo("b"));//0

        //比较两个字符串，如果两个字符串的首字母不同，则返回首字符的左-右 asc差值
        System.out.println("bcduyhtgfd".compareTo("adewdw"));
        System.out.println("ceee".compareTo("adewddewedw"));

        //比较两个字符串，如果两个字符串的首字母相同，则递归的往右继续比较
        //如果在比较的过程中出现了一个字符串已经比较完，则返回字符串长度的差值
        System.out.println("bd".compareTo("bdfswi"));
        System.out.println("bdg".compareTo("bdfswi"));
        System.out.println("bd".compareTo("bdd"));

        /*关于Java8排序*/
        List<String> list = Arrays.asList(new String[]{"22","221"});
        Collections.sort(list, (num1, num2) -> {

            return num1.compareTo(num2);
        });
        System.out.println("list:" + list);
    }

    private void learnTest2() {
        Integer a = -20;
        Integer b = 2;
        System.out.println(a.compareTo(b));
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(new Integer[]{2, 3, -1}));
        Collections.sort(list2, (num1, num2) -> {
            //返回0的时候不进行交换
            //返回大于0的时候不进行交换
            //返回小于0的时候进行交换
            //此处的num1是在num2的后面，两个元素都是数组内的元素--->> 如果后面的num1<前面的num2，那么肯定要交换，所以说排序的时候小0进行排序，否则不排序
            return num1.compareTo(num2);
        });
        System.out.println("list2:" + list2);
    }

    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        String [] numStr=scanner.nextLine().split(",");
        _84_card card = new _84_card();
        System.out.println(card.process(numStr));

//        card.learnTest();
//        card.learnTest();
    }
}
