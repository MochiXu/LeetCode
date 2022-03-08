package onLine.HuaWei;

import java.util.Arrays;
import java.util.Scanner;

/*
* 同种颜色的所有数字可以被该颜色中最小的数字整除
* 计算最少需要多少种颜色给N个数字上色
* */
public class Soulution1 {
    public static int getVisited(int[] visited){
        int res=0;
        for (int i=0;i<visited.length;i++){
            res+=visited[i];
        }
        return res;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] input=new int[n];
        for (int i=0;i<n;i++){
            input[i]=sc.nextInt();
        }
        Arrays.sort(input);
        //对input进行遍历计算
        int[] visited=new int[n];
        int num=0;
        while (Soulution1.getVisited(visited)!=-n){
            int i=0;
            for (;i<n;i++){
                if (visited[i]==0){
                    visited[i]=-1;
                    break;
                }
            }
            for (int j=i+1;j<n;j++){
                if(input[j]%input[i]==0){
                    visited[j]=-1;
                }
            }
            num++;
        }
        System.out.println(num);
    }
}
