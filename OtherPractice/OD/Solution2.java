package OtherPractice.OD;

import java.util.*;

public class Solution2 {
    public static class obj{
        String url;
        int count;
        public obj(String url,int count){
            this.url=url;
            this.count=count;
        }

        public void setCount(int count) {
            this.count = count;
        }

    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        //维护一个Treemap
        int index=0;
        TreeMap<Integer,obj> treeMap=new TreeMap<>();
        HashMap<String,Integer> hashMap=new HashMap<>();
        while (sc.hasNext()){
            String line=sc.nextLine();
            String url="";
            int top=0;
            if (line.length()==1){
                //需要输出前n个数字
                top=Integer.parseInt(line);
                //对treemap进行排序
                Set<Map.Entry<Integer,obj>> mapEntries=treeMap.entrySet();
                List<Map.Entry<Integer,obj>> list=new LinkedList<>(mapEntries);
                Collections.sort(list,(right,left)->{
                    if (right.getValue().count> left.getValue().count){
                        return -1;
                    }else if(right.getValue().count< left.getValue().count){ return 1;}
                    else {
                        return left.getValue().url.compareTo(right.getValue().url);
                    }
                });
                //进行输出
                for(int i=0;i<top;i++){
                    System.out.print(list.get(i).getValue().url);
                    if (i!=top-1) System.out.print(",");
                }
                System.out.println();
            }else{
                //需要更新访问量最高的url
                url=line;
                //遍历TreeMap
                int flag=-1;
                for (Object o:treeMap.keySet()){
                    if (treeMap.get(o).url.equals(url)){
                        treeMap.get(o).setCount(treeMap.get(o).count+1);
                        flag=1;//表示存在这个url并且更新了
                        break;
                    }
                }
                if(flag==-1){
                    treeMap.put(index++,new obj(line,1));
                }
            }

        }
    }
}
