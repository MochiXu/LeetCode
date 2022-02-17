package NewCoder.Easy;
/*
  给定一个射击比赛成绩单
  包含多个选手若干次射击的成绩分数
  请对每个选手按其最高三个分数之和进行降序排名
  输出降序排名后的选手id序列
  条件如下
    1. 一个选手可以有多个射击成绩的分数，且次序不固定
    2. 如果一个选手成绩少于3个，则认为选手的所有成绩无效，排名忽略该选手
    3. 如果选手的成绩之和相等，则相等的选手按照其id降序排列

   输入描述:
     输入第一行
         一个整数N
         表示该场比赛总共进行了N次射击
         产生N个成绩分数
         2<=N<=100

     输入第二行
       一个长度为N整数序列
       表示参与每次射击的选手id
       0<=id<=99

     输入第三行
        一个长度为N整数序列
        表示参与每次射击选手对应的成绩
        0<=成绩<=100

   输出描述:
      符合题设条件的降序排名后的选手ID序列

   示例一
      输入:
        13
        3,3,7,4,4,4,4,7,7,3,5,5,5
        53,80,68,24,39,76,66,16,100,55,53,80,55
      输出:
        5,3,7,4
      说明:
        该场射击比赛进行了13次
        参赛的选手为{3,4,5,7}
        3号选手成绩53,80,55 最高三个成绩的和为188
        4号选手成绩24,39,76,66  最高三个成绩的和为181
        5号选手成绩53,80,55  最高三个成绩的和为188
        7号选手成绩68,16,100  最高三个成绩的和为184
        比较各个选手最高3个成绩的和
        有3号=5号>7号>4号
        由于3号和5号成绩相等  且id 5>3
        所以输出5,3,7,4

*/

import java.util.*;

import static java.util.Arrays.asList;

public class _86_shot {
    private void sortPerson(int shotNum,LinkedList<Integer> person,LinkedList<Integer> count){
        //利用HashMap存储每个人的射击次数
        HashMap<Integer,Integer> personFrequency=new HashMap<>();
        for (int i=0;i<shotNum;i++){
            if (!personFrequency.containsKey(person.get(i))){
                personFrequency.put(person.get(i),1);
            }else {
                personFrequency.put(person.get(i),personFrequency.get(person.get(i))+1);
            }
        }
        //创建最终排名的List存储每个运动员
        LinkedList<Integer> list=new LinkedList<>();
        for (int i=0;i<shotNum;i++){
            if (personFrequency.get(person.get(i))>=3&&!list.contains(person.get(i))){
                list.add(person.get(i));
            }
        }
        //为每位运动员计算最高三个分数之和
        LinkedList<Integer> list_count=new LinkedList<>();
        for (int i=0;i<list.size();i++){
            int personID=list.get(i);
            ArrayList<Integer> arrayList= new ArrayList<>();
            for (int j=0;j<shotNum;j++) {

                if (person.get(j)==personID){
                    arrayList.add(count.get(j));
                }
            }
            Collections.sort(arrayList);
            list_count.add(arrayList.get(arrayList.size()-1)+arrayList.get(arrayList.size()-2)+arrayList.get(arrayList.size()-3));
        }
        //合法成绩运动员list
        //运动员成绩list_count
        //进行排序
        for (int i=0;i<list_count.size()-1;i++){
            for (int j=0;j<list_count.size()-1-i;j++){
                if (list_count.get(j+1)>=list_count.get(j)){
                    if (list_count.get(j+1)==list_count.get(j)&&list.get(j+1)>list.get(j)){
                        int temp=list.get(j);
                        list.set(j,list.get(j+1));
                        list.set(j+1,temp);
                    }
                    int temp1=list_count.get(j);
                    int temp2=list.get(j);
                    list_count.set(j,list_count.get(j+1));
                    list.set(j,list.get(j+1));
                    list_count.set(j+1,temp1);
                    list.set(j+1,temp2);
                }
            }
        }
        for (int i=0;i< list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        for (int i=0;i< list.size();i++){
            System.out.print(list_count.get(i)+" ");
        }
    }

    private int getCount(LinkedList<Integer> list,int target){
        int num=0;
        for (int i: list){
            if (i==target)
                num++;
        }
        return num;
    }

//    private int getIndex(LinkedList<Integer> list,int target){}


    public static void main(String args[]){
        Scanner scanner=new Scanner(System.in);
        //总共射击的次数
        int shotNum=Integer.parseInt(scanner.nextLine());
        //每次射击的选手ID
        String[] personID=scanner.nextLine().split(",");
        LinkedList<Integer> person=new LinkedList<>();
        for (String s:personID){
            person.add(Integer.parseInt(s));
        }
        //每次射击的选手成绩
        String[] personCount=scanner.nextLine().split(",");
        LinkedList<Integer> count=new LinkedList<>();
        for (String s:personCount){
            count.add(Integer.parseInt(s));
        }
        System.out.println(shotNum);
        System.out.println(person);
        System.out.println(count);
        _86_shot shot=new _86_shot();

        int[]a={3, 3, 7, 4, 4, 4, 4, 7, 7, 3, 5, 5, 5};
        int[]b={53, 80, 68, 24, 39, 76, 66, 16, 100, 55, 53, 80, 55};
        LinkedList<Integer>aa=new LinkedList<>();
        LinkedList<Integer>bb=new LinkedList<>();
        for (int i=0;i<a.length;i++){
            aa.add(a[i]);
            bb.add(b[i]);
        }
        shot.sortPerson(13,aa,bb);
    }

}
